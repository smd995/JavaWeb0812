package org.zerock.webmarket.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.webmarket.member.dto.MemberDTO;
import org.zerock.webmarket.member.service.MemberServiceImpl;
import org.zerock.webmarket.notice.dto.NoticeDTO;

import java.lang.reflect.Member;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
  private final MemberServiceImpl memberService;

  @GetMapping("/join")
  public void joinGET(){}

  @PostMapping("/join")
  public void joinPOST(MemberDTO dto){
    memberService.registerMember(dto);
  }
}














