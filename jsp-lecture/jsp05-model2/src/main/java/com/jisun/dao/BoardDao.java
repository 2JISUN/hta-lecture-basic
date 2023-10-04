package com.jisun.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jisun.common.JDBCConnect;
import com.jisun.dto.Board;
import com.jisun.service.BoardService;

public class BoardDao implements BoardService {
	
	// 유저가 작성한 게시판 데이터를 데이터베이스에 삽입하는 메서드입니다.
	@Override
	public List<Board> list() {
		List<Board> boardList = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		ResultSet rs = null;
		Board board = new Board();
		try {
			String sql = "select * from board";
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<Board>();
			while (rs.next()) {
				board.setNo(rs.getInt("no"));
				board.setId(rs.getString("id"));
				board.setPassword(rs.getString("password"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				boardList.add(board);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return boardList;
	}
	

	@Override
	public int insertBoard(Board board) {
		int result = 0;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0)";
		try {
			
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			
			pstmt.setString(1,board.getId());
			pstmt.setString(2,board.getPassword());
			pstmt.setString(3,board.getName());
			pstmt.setString(4,board.getTitle());
			pstmt.setString(5,board.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		return result;
	}


	@Override
	public Board viewBoard(int no) {
		Board board = null;
		JDBCConnect jdbcConn = new JDBCConnect();
		String sql = "select * from board where no = ?";
		ResultSet rs =null;
		try {
			PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				board.setNo(rs.getInt("no"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcConn.close();
		}
		
		return board;
	}

}
