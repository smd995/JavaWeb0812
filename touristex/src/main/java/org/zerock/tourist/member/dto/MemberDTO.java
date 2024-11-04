package org.zerock.tourist.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memberId;

    private String memberPw;

    private String name;

    private String phone;

    private String email1;

    private String email2;

    private String gender;

    private boolean agree;

    private Date createDate;

    private String uuid;
}

