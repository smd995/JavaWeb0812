package org.zerock.w2.filter;


import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Login Check Filter.....................");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

//        if (session.isNew()) {
//            resp.sendRedirect("/login");
//            return;
//        }

        if (session.getAttribute("loginInfo") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Cookie cookie = findCookie(req.getCookies(), "remember-me");
        if(cookie == null) {
            resp.sendRedirect("/login");
            return;
        }

        try {
            String uuid = cookie.getValue();
            MemberDTO dto = MemberService.INSTANCE.getByUuid(uuid);
            if(dto == null) {
                throw new Exception("Cookie value is not valid");
            }
            session.setAttribute("loginInfo", dto);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
          e.printStackTrace();
          resp.sendRedirect("/login");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies == null || cookies.length == 0) return null;
        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(cookie-> cookie.getName().equals(name))
                .findFirst();

        return result.isPresent() ? result.get() : null;

    }
}
