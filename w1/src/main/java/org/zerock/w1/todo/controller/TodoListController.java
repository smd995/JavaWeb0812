package org.zerock.w1.todo.controller;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력 화면을 볼 수 있도록 구성");
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        // request에 dtoList를 저장
        req.setAttribute("list", dtoList);
        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
//        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/todo/list.jsp");
//        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동");
    }
}
