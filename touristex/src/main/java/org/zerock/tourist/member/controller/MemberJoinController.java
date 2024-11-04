package org.zerock.tourist.member.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.tourist.member.dto.MemberDTO;
import org.zerock.tourist.member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "memberJoinController", value = "/member/join")
public class MemberJoinController extends HttpServlet {

    private MemberService service = MemberService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("/member/join GET......");
        req.getRequestDispatcher("/WEB-INF/member/join.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email1");

        MemberDTO dto = MemberDTO.builder()
                .email1(email)
                .email2(req.getParameter("email2"))
                .memberId(email)
                .name(req.getParameter("name"))
                .memberPw(req.getParameter("pwd1"))
                .phone(req.getParameter("phone"))
                .gender(req.getParameter("gender"))
                .agree(Boolean.valueOf(req.getParameter("agree")))
                .build();

        log.info("/member/join POST..........");
        log.info(dto);
        try {
            service.register(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/index.jsp");

    }
}
