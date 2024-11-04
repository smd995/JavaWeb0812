package org.zerock.tourist.member.dao;

import lombok.Cleanup;
import org.zerock.tourist.member.domain.MemberVO;
import org.zerock.tourist.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public String getTime() {
        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();) {

            resultSet.next();

            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return now;
    }

    public void insert (MemberVO vo) throws Exception {
        String sql = "insert into member (Email1, Email2, member_id, name, member_pw, phone, gender, agree) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vo.getEmail1());
        preparedStatement.setString(2, vo.getEmail2());
        preparedStatement.setString(3, vo.getMemberId());
        preparedStatement.setString(4, vo.getName());
        preparedStatement.setString(5, vo.getMemberPw());
        preparedStatement.setString(6, vo.getPhone());
        preparedStatement.setString(7, vo.getGender());
        preparedStatement.setBoolean(8, vo.isAgree());

        preparedStatement.executeUpdate();
    }

    public MemberVO getWithPassword(String id, String pw) throws Exception {
        String query =
                "SELECT " +
                        "member_id, " +
                        "member_pw " +
                        "FROM " +
                        "member " +
                        "WHERE " +
                        "member_id = ? " +
                        "AND " +
                        "member_pw = ?";

        MemberVO vo = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, id);
        ps.setString(2, pw);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        vo = MemberVO.builder()
                .memberId(rs.getString("member_id"))
                .memberPw(rs.getString("member_pw"))
                .build();
        return vo;
    }

    public void updateUuid(String mid, String uuid) throws Exception {
        String sql = "UPDATE tbl_member SET uuid = ? WHERE mid = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uuid);
        ps.setString(2, mid);
        ps.executeUpdate();
    }
}
