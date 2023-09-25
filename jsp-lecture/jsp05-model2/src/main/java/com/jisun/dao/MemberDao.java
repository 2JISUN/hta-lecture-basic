package com.jisun.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jisun.common.JDBCConnect;
import com.jisun.dto.Member;

public class MemberDao {
	public int insertMember(Member member) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,sysdate)";
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setInt(4,member.getPostcode());
			pstmt.setString(5,member.getAddress());
			pstmt.setString(6,member.getAddressdetail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			jdbcConn.close();
		}
		
		return result;
	}
}