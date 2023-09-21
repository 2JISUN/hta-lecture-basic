<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//0.전역변수 할당
//get : (String)session.getAttribute를 사용하여 페이지에 저장된 정보를 받아옵니다.

// String loggedID = (String)session.getAttribute("loggedID");
// String loggedName = (String)session.getAttribute("loggedName");


//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
String title = request.getParameter("title"); //제목
String content = request.getParameter("content"); //내용
String password = request.getParameter("password"); //비밀번호
String loggedID = request.getParameter("loggedID"); //로그인된 아이디
String loggedName = request.getParameter("loggedName"); //로그인된 이름

//1. driver 찾기
//2. db연동
JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행

//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
//3-1. 쿼리 작성
String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0)"; /* 조회수 기본값=0 */

//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	pstmt.setString(1,loggedID); //세션값 id
	pstmt.setString(2,password);
	pstmt.setString(3,loggedName); //세션값 name
	pstmt.setString(4,title);
	pstmt.setString(5,content);
	
//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
//result는 데이터베이스 조작 작업을 실행한 결과로서, 영향을 받는 <레코드 수>를 나타내는 정수입니다. 
int result = pstmt.executeUpdate(); //executeUpdate() 레코드 수를 반환합니다.


//5. 조건 > 글쓰기 성공여부

if(result>0) {
		// 글쓰기 성공
		System.out.println("입력 성공");
		ScriptWriter.alertAndNext(response, "게시판에 글이 등록되었습니다.", "../index/index.jsp");
	} else  {
		// 글쓰기 실패, 오류
		System.out.println("입력 오류");
		ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해 주세요");
	}


//데이터베이스 연결 종료
jdbcConn.close();

%>




























