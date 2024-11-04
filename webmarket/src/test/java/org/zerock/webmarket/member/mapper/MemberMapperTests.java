package org.zerock.webmarket.member.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.webmarket.member.domain.MemberVO;

import java.time.LocalDateTime;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MemberMapperTests {

    @Autowired(required = false)
    private MemberMapper mapper;


    @Test
    public void testInsert() {
        MemberVO vo = MemberVO.builder()
                .member_id("abcdefg1234")
                .member_pw("1234")
                .name("abcde")
                .phone("01012341234")
                .email1("abcde")
                .email2("abcde")
                .gender("Male")
                .agree(true)
                .build();

        mapper.insertMember(vo);
    }
}
