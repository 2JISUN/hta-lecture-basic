package com.jisun.dao;

import org.apache.ibatis.session.SqlSession;

import com.jisun.dto.MemberDto;
import com.jisun.mybatis.MybatisConnectionFactory;

public class MemberDao {
    /**
     * 사용자 로그인을 처리하는 메서드
     * 
     * @param memberDto 로그인 요청 시 전달되는 MemberDto 객체
     * @return 로그인된 Member 정보(MemberDto) 또는 null(로그인 실패 시)
     */
	public MemberDto loginMember(MemberDto memberDto) {
		// 초기화
		MemberDto loggedMember = null;
        // MyBatis의 SqlSession을 가져오는 메서드를 호출하여 SqlSession 객체를 획득
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        // MyBatis 매퍼 파일에 정의된 "loginMember" 쿼리를 실행하고 결과를 받아옴
        loggedMember = sqlSession.selectOne("loginMember", memberDto);
        // 사용이 끝난 SqlSession 객체를 닫음
        sqlSession.close();
        // 로그인된 Member 정보 또는 null을 반환
        return loggedMember;
	}
}
