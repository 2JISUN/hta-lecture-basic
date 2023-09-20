<!-- process 회원가입 -->
<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	//0.전역변수 할당
	//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
	String userID = request.getParameter("userID"); //get : 아이디
	String userPW = request.getParameter("userPW"); //get : 비밀번호
	String userName = request.getParameter("userName"); //get : 이름
	
	int postCode  = 0;
	if(request.getParameter("postCode")!=null){
		postCode  = Integer.parseInt(request.getParameter("postCode")); //get : 우편번호
	}
	String address = request.getParameter("address"); //get : 주소
	String detailAddress = request.getParameter("detailAddress"); //get : 상세주소

	//1. driver 찾기
	//2. db연동
	JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행
	
	
	//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
	//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성
	String sql = 
			"insert into member values(seq_member.nextval,?,?,?,?,?,?,sysdate)";
	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	pstmt.setString(3,userName);
	pstmt.setInt(4,postCode);
	pstmt.setString(5,address);
	pstmt.setString(6,detailAddress);
	
	//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
	//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
	//result는 데이터베이스 조작 작업을 실행한 결과로서, 영향을 받는 <레코드 수>를 나타내는 정수입니다. 
	int result = pstmt.executeUpdate(); //executeUpdate() 레코드 수를 반환합니다.
	
	//5. 조건 > 회원가입 성공여부
	if(result>0) {
		// 회원가입 성공
		System.out.println("입력 되었음");
		ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../index/index.jsp");
	} else  {
		System.out.println("입력 오류");
		ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해 주세요");
	}
	
	// 데이터베이스 연결 종료
	
%>









