package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name="todoReadController", value="/todo/read")
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("todo read ......................");
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO dto = todoService.getOne(tno);
            req.setAttribute("dto", dto);


            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodoCookie");
            String todoListstr = viewTodoCookie.getValue();
            boolean exist = false;

            if(todoListstr != null && todoListstr.indexOf(tno+"-") >= 0) {
                exist = true;
            }

            if(!exist) {
                todoListstr += tno + "-";
                viewTodoCookie.setValue(todoListstr);
                viewTodoCookie.setPath("/");
                viewTodoCookie.setMaxAge(60*60*24);
                resp.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException(e);
        }
    }

    public Cookie findCookie(Cookie[] cookies, String cookieName) {
        Cookie targetCookie = null;

        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(cookieName)) {
                    targetCookie = cookie;
                    break;
                }
            }
        }

        if(targetCookie == null) {
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);
        }
        return targetCookie;
    }
}
