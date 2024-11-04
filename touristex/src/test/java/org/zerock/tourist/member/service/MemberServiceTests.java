package org.zerock.tourist.member.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.tourist.member.dto.MemberDTO;

@Log4j2
public class MemberServiceTests {

    private MemberService service;

    @BeforeEach
    public void ready() {
        service = MemberService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        MemberDTO dto = MemberDTO.builder()
                .email1("abcd1")
                .email2("naver.com")
                .memberId("abcd1")
                .name("김길수1")
                .memberPw("12341")
                .phone("01012341234")
                .gender("m")
                .agree(true)
                .build();

        log.info("---------------------------");
        log.info(dto);

        service.register(dto);
    }

}
