package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login doGet.............");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login doPost.............");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String auto = req.getParameter("auto");
        boolean rememberMe = auto !=null && auto.equals("on");

        MemberDTO loginInfo = null; // loginInfo를 try-catch 바깥에서 선언

        try {
            loginInfo = memberService.login(mid, mpw);
            if (rememberMe) {
                String uuid = UUID.randomUUID().toString();
                memberService.modifyUuid(mid, uuid);
                loginInfo.setUuid(uuid);
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setPath("/");
                rememberCookie.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(rememberCookie);
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", loginInfo); // 로그인 성공 시 세션에 로그인 정보 저장
            resp.sendRedirect("/todo/list"); // 로그인 성공 후 리다이렉트할 페이지 지정

        } catch (Exception e) {
            log.error("Login failed", e); // 로그에 에러 메시지 추가
            resp.sendRedirect("/login?result=error");
        }
    }
}
