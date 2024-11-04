package org.zerock.tourist.member.service;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.tourist.member.dao.MemberDAO;
import org.zerock.tourist.member.domain.MemberVO;
import org.zerock.tourist.member.dto.MemberDTO;
import org.zerock.tourist.util.MapperUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {

        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.getModelMapper();
    }

    public void register (MemberDTO dto) throws Exception {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);

        log.info(vo);

        dao.insert(vo);
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;
    }

    public void modifyUuid (String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

}

