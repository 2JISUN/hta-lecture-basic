
/*
DAO (Data Access Object) 폴더 = db 연동 로직을 짠다 + sql

DAO는 데이터베이스와 상호작용하는 역할을 하는 클래스입니다. 
주로 데이터베이스의 CRUD (Create, Read, Update, Delete) 연산을 처리합니다.
각 테이블마다 해당하는 DAO 클래스가 필요하며, 데이터베이스 연결, 쿼리 실행 및 데이터베이스 연산과 관련된 모든 로직을 포함합니다.
DAO 클래스는 DTO 객체를 데이터베이스에 저장하거나 데이터베이스에서 검색하여 DTO 객체로 반환하는 메서드를 제공합니다.
예를 들어, "User" 테이블에 대한 DAO 클래스는 UserDAO.java와 같은 이름으로 생성될 수 있습니다.


*/

package com.jisun.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jisun.common.JDBCConnect;
import com.jisun.dto.Member;
import com.jisun.service.MemberService;

public class MemberDao implements MemberService {
	
	
	// 회원 정보를 데이터베이스에 삽입하는 메서드입니다.
	public int insertMember(Member member) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into member values(seq_member.nextval,?,?,?,?,?,?,?,?,sysdate,?)";
		try {
			
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getEmail());
			pstmt.setString(5,member.getTel());
			pstmt.setInt(6,member.getPostcode());
			pstmt.setString(7,member.getAddress());
			pstmt.setString(8,member.getAddressdetail());
			pstmt.setString(9,member.getProfile());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	
	//사용자의 아이디와 비밀번호를 받아와서 로그인 처리를 하는 메서드입니다.
	@Override
	public Member loginMember(String userID, String userPW) {
		Member loggedMember = null;
		JDBCConnect jdbcConn = new JDBCConnect();
	
		try {
			String sql = "select * from member where id=? and password=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedMember = new Member();
				loggedMember.setId(rs.getString("id"));
				loggedMember.setName(rs.getString("name"));
				loggedMember.setProfile(rs.getString("profile"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return loggedMember;
	}


	
	//사용자 아이디 중복 확인을 위한 메서드입니다.
	@Override
	public Member infoMember(String userID) {
		Member infoMember = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select * from member where id=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				infoMember = new Member();
				infoMember.setPassword(rs.getString("password"));
				infoMember.setAddress(rs.getString("address"));
				infoMember.setAddressdetail(rs.getString("addressdetail"));
				infoMember.setPostcode(rs.getInt("postcode"));
				infoMember.setRegdate(rs.getString("regdate"));
				infoMember.setEmail(rs.getString("email"));
				infoMember.setTel(rs.getString("tel"));
				infoMember.setProfile(rs.getString("profile"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoMember;
		
	}


	//사용자 아이디 중복 확인을 위한 메서드입니다.
	public int idCheck(String userID) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();

		try {
			String sql = "select count(*) as count from member where id=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}


	//사용자 탈퇴를 위한 메서드입니다.
	@Override
	public int deleteMember(String userID, String userPW) {
		int result = 0;
		
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "delete from member where id=? and password=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}

	// 회원정보 수정을 위한 메서드입니다.
	public Member modifyPasswordConfirm(String userID, String userPW) {
		Member modifyMember = null;
		
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "select * from member where id=? and password=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				modifyMember = new Member();
				modifyMember.setAddress(rs.getString("address"));
				modifyMember.setAddressdetail(rs.getString("addressdetail"));
				modifyMember.setPostcode(rs.getInt("postcode"));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return modifyMember;
		
	}



	
	
	//회원정보 수정 메서드입니다.
	public int modifyMember(Member modifyMember) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		try {
			String sql = "update member set name=?, address=?, addressdetail=?, postcode=? where id=?";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setString(1, modifyMember.getName());
			pstmt.setString(2, modifyMember.getAddress());
			pstmt.setString(3, modifyMember.getAddressdetail());
			pstmt.setInt(4, modifyMember.getPostcode());
			pstmt.setString(5, modifyMember.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}
	
	
	
	
}

