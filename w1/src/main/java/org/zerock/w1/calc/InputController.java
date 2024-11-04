package org.zerock.w1.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inputController", value = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InputController... doGet...");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InputController... doPost...");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
//        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/calc/result.jsp");
//        rd.forward(req, resp);
        resp.sendRedirect("/calc/input?num1=" + num1 + "&num2=" + num2);
    }
}
