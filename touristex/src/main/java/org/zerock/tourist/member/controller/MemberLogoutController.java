package org.zerock.tourist.member.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "memberLogoutController", value = "/logout")
public class MemberLogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 현재 세션 가져오기
        HttpSession session = req.getSession(false); // 기존 세션이 없으면 null을 반환

        if (session != null) {
            // 세션 무효화 (세션 데이터 삭제)
            session.invalidate();
            log.info("세션이 무효화되었습니다. 로그아웃 완료.");
        }

        // 로그아웃 후 메인 페이지로 리다이렉트
        resp.sendRedirect("/index.jsp");
    }
}
