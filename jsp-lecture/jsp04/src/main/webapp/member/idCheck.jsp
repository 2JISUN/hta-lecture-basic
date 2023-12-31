<%@page import="java.sql.SQLException"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<%
/* 	
	- 응답방식 : HTTP 응답의 Content-Type 헤더를 설정하는 부분
	 ①application/json > {제목:내용}
	 ②text/html > 제목/내용
	 ③text/plain > <h1>제목</h1>

	- 역할 : 클라이언트에게 전송되는 데이터의 형식과 문자 인코딩을 명시적으로 지정
	- 목적 : 이를 통해 데이터의 정확한 해석과 처리가 가능해집니다.
*/

	response.setContentType("application/json; charset=utf-8");


	//0.전역변수 할당
	//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
	String userID = request.getParameter("userID"); // 사용자가 입력한 아이디를 받아옴
    boolean isAvailable = true; // 중복 여부를 초기에 true로 설정
	
	//1. driver 찾기
	//2. db연동 및 해제
	JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행

	
	//3. db접근 > 쿼리 작성 > select > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성
	String sql = "select count(*) AS count from member where id = ?";
	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
		
	
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
	pstmt.setString(1, userID);
		
	//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
	rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 
	    
	//5. 조건 > 아이디 중복 불가능
	int result = 0;
	if(rs.next()){
		result = rs.getInt("count");
	}
	
	
	//6. 서버 응답용 JSON 객체를 생성합니다. > Spring은 이걸 내장하고 있음...
	//서버에서 클라이언트로 데이터를 전달하기 위해 JSON 형식으로 데이터를 변환하고 전송하기 위함
	//사용목적? 좋아서~~
	// JSON 응답을 위한 맵 생성
	
	Map<String,Integer> map = new HashMap<>();
	map.put("count",result);
	Gson gson = new Gson();
	String json = gson.toJson(map);
	out.println(json);

%>







