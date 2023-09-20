<%@page import="util.ScriptWriter"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	//0.전역변수 할당
	//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
	//String 어쩌고 = request.getParameter(arg0) //getParameter(arg0) :  하나의 값을 받을 수 있음
	String idx[] = request.getParameterValues("check"); // getParameterValues() : 여러개의 값을 받을 수 있음

	
	//1. driver 찾기
	//2. db연동 및 해제
	JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행
	
	//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
	//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성
	String sql = "delete from member where no=?";
	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
	
	
	int count = 0;
	jdbcConn.conn.setAutoCommit(false); 
	
	
	
	
	
	
	
	// 4. db실행 > 값이 여러개 >  for문 처리
/* 	
	// 4. db실행 > 값이 여러개 >  for문 처리 > executeUpdate()
	for(int i = 0; i<idx.length; i++){
		//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
		pstmt.setInt(1,Integer.parseInt(idx[i]));
		
		//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
		//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
		int result = pstmt.executeUpdate(); //executeUpdate() 레코드 수를 반환합니다.
		
		//5. 조건
		if(result>0){
			count++;
		}
		System.out.println(result);
	}
	
	// 6.db상태 
	
	if(count>=idx.length){		
		jdbcConn.conn.commit();
	} else {
		jdbcConn.conn.rollback();
	} 
	
*/
	
	
	// 4. db실행 > 값이 여러개 > 방법02 > for문 처리 > executeBatch()
	try {
		jdbcConn.conn.setAutoCommit(false);
		for(int i=0;i<idx.length;i++) {
			pstmt.setInt(1,Integer.parseInt(idx[i]));
			pstmt.addBatch();
		}
		int result[] = pstmt.executeBatch();
		System.out.println(result.length);
		System.out.println(Arrays.toString(result));
		jdbcConn.conn.commit();		
		ScriptWriter.alertAndNext(response, "삭제가 완료되었습니다.👍","../member/list.jsp");
	} catch (Exception e) {
		jdbcConn.conn.rollback();
		e.printStackTrace();
		ScriptWriter.alertAndBack(response, "서버 오류 입니다. 잠시만 기다려~~~~~🐊");
	} finally {
		jdbcConn.conn.setAutoCommit(true);
	}
	

	




%>