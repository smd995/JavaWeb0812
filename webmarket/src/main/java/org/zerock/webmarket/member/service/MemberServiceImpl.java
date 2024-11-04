package org.zerock.webmarket.member.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.webmarket.member.domain.MemberVO;
import org.zerock.webmarket.member.dto.MemberDTO;
import org.zerock.webmarket.member.mapper.MemberMapper;
import org.zerock.webmarket.notice.domain.NoticeVO;
import org.zerock.webmarket.notice.dto.NoticeDTO;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  private final MemberMapper MemberMapper;
  private final ModelMapper modelMapper;

  @Override
  public void registerMember(MemberDTO dto) {
    MemberVO vo = modelMapper.map(dto, MemberVO.class);
    MemberMapper.insertMember(vo);
  }
}











