package com.jisun.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jisun.dto.BoardDto;
import com.jisun.dto.PageDto;
import com.jisun.mybatis.MybatisConnectionFactory;

public class BoardDao {
	public List<BoardDto> getAllBoard(HashMap<String,Integer> pageMap) {
		List<BoardDto> boardList = null;
		// SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard",pageMap);
		sqlSession.close();
		return boardList;
	}
	
	
	public List<BoardDto> getAllBoard(PageDto pageDto) {
		List<BoardDto> boardList = null;
		// SqlSession을 하나 열어준다.
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardList = sqlSession.selectList("getAllReplyboard",pageDto);
		sqlSession.close();
		return boardList;
	}
	
	
	public BoardDto getOneBoard(int no) {
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		boardDto = sqlSession.selectOne("getOneBoard",no);
		sqlSession.close();
		return boardDto;
	}
	
	public int writeBoard(BoardDto boardDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("writeBoard",boardDto);
		sqlSession.close();
		return result;
	}
	
	public int deleteBoard(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteBoard",no);
		sqlSession.close();
		return result;
	}
	
	public int updateHit(int no) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateHit",no);
		sqlSession.close();
		return result;
	}
	
	public int deleteAllBoard(int[] noList) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteAllBoard",noList);
		sqlSession.close();
		return result;
	}
	
	

	
}
















