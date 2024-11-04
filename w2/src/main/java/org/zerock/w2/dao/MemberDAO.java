package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    // mid와 mpw를 이용해 데이터베이스의 Member를 찾는 메서드
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String query =
                "SELECT " +
                    "mid, " +
                    "mpw, " +
                    "mname " +
                "FROM " +
                    "tbl_member " +
                "WHERE " +
                    "mid = ? " +
                "AND " +
                    "mpw = ?";

        MemberVO vo = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, mid);
        ps.setString(2, mpw);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        vo = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
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

    public MemberVO selectUuid(String uuid) throws Exception {
        String query =
                "SELECT " +
                        "mid, " +
                        "mpw, " +
                        "mname, " +
                        "uuid " +
                        "FROM " +
                        "tbl_member " +
                        "WHERE " +
                        "uuid = ? ";

        MemberVO vo = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, uuid);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        vo = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .uuid(rs.getString("uuid"))
                .build();
        return vo;
    }
}
