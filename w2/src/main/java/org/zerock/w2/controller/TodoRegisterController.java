package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name="todoRegisterController", value="/todo/register")
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/register Get.................................");

        // login 처리
        // HttpSession 객체는 session 안에 들어있는 데이터를 사용
//        HttpSession session = req.getSession();
//        if(session.isNew()){
//            log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
//            resp.sendRedirect("/login");
//            return;
//        }
//        // session.getAttribute(저장되어있는 데어터의 키값)
//        if(session.getAttribute("loginInfo") == null){
//            log.info("로그인한 정보가 없는 사용자");
//            resp.sendRedirect("/login");
//            return;
//        }
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();
        log.info("/todo/register Post.................................");
        log.info(todoDTO);
        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
    }
}
