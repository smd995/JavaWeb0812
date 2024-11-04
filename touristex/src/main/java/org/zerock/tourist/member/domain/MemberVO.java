package org.zerock.tourist.member.domain;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVO {

    private String memberId;

    private String memberPw;

    private String name;

    private String phone;

    private String email1;

    private String email2;

    private String gender;

    private boolean agree;

    private Date createDate;

}
