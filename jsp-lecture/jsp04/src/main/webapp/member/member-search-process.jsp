<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="common.JDBCConnect" %>
<%@ page import="util.ScriptWriter" %>

<%
	//0.전역변수 할당
	//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
	
	String searchItem = request.getParameter("searchItem"); //폼
	String searchWord = request.getParameter("searchWord"); //입력
	


	//1. driver 찾기
	//2. db연동
	//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
	//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성 > 컬럼은 ? 불가능함
	
	//3-2. 쿼리 세팅(저장)
	String sql = "";
	JDBCConnect jdbcConn = new JDBCConnect();//Oracle 데이터베이스에 연결을 수행
	PreparedStatement pstmt = null;

	
/* 	<select name="searchItem">
	<option value="name">이름</option>
	<option value="id">아이디</option>
	<option value="address">주소</option>
	<option value="all">전체</option>
	</select> */
	
	
	if(searchItem.equals("name")) {
		sql = "SELECT * FROM BOARD WHERE name like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
	} else if(searchItem.equals("id")) {
		sql = "SELECT * FROM BOARD WHERE id like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
	} else if(searchItem.equals("address")) {
		sql = "SELECT * FROM BOARD WHERE address like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
	} else {
		sql = "SELECT * FROM BOARD WHERE name like '%'||?||'%' or id like '%'||?||'%' or address like '%'||?||'%'";
		pstmt = jdbcConn.conn.prepareStatement(sql);
		pstmt.setString(1,searchWord);
		pstmt.setString(2,searchWord);
		pstmt.setString(3,searchWord);
	}


	// column은 ? 처리 안됨 ?는 값만 처리... mybatis 에서는 #{}츠로 처리 가능
	ResultSet  rs = pstmt.executeQuery();

		
	// 데이터베이스 연결 종료 > 시키면 안됨 > 검색 반복하기 때문!! 
	/* jdbcConn.close(); */

%>


<%@ include file="../include/header.jsp" %>





<div class="container">
	<form action="../member/list.jsp">
		<table class="table">
		  <thead>
		    <tr>
		      		<th scope="col">no</th>
					<th scope="col">id</th>
					<th scope="col">name</th>
					<th scope="col">postcode</th>
					<th scope="col">address</th>
					<th scope="col">detail address</th>
					<th scope="col">regdate</th>
					<!-- <th scope="col">profile</th> -->
					<th scope="col">삭제</th>
					<th scope="col"><input type="checkbox" id="checkAll"></th>
		    </tr>
		  </thead>
		  
		  <tbody>
		   		<% while(rs.next()){ %>
		   		    <tr>
			   	      <th scope="row"><%=rs.getInt("no")%></th>
			   	      <td>
			   	      	<a href="../member/info.jsp?userID=<%=rs.getString("id") %>">
			   	      		<%=rs.getString("id")%>
			   	      	</a>
			   	      </td>
			   	      <td><%=rs.getString("name") %></td>
			   	      <td><%=rs.getString("postcode") %></td>
			   	      <td><%=rs.getString("address") %></td>
			   	      <td><%=rs.getString("addressdetail") %></td>
			   	      <td><%=rs.getString("regdate") %></td>
			   	      <td>
			   	      	<button class="btn btn-danger btnDelete"
			   	      			data-no="<%=rs.getInt("no") %>"> <!-- data-어쩌고 : 사용자가 임의로 속성을 만들 수 있다. -->
			   	      		삭제
			   	      	</button>
			   	      </td>
			   	      <td scope="col">
			   	      	<input type="checkbox" 
					   	       name="check" 
					   	       class="check"
					   	       value="<%=rs.getInt("no")%>">
			   	      </td>
			   	    </tr>
		   		<% } %>
		  </tbody>
		</table>
		<button class="btn btn-danger" id="btnAll">삭제</button>
		<!-- 검색기능 추가 -->
		<!-- 폼 태그 안의 태그에서 name이 중요하다 -->

	</form>
	
	
	<div class="d-flex justify-content-center mt-5">
			<form action="../member/member-search-process.jsp" >
						<select name="searchItem">
							<option value="name">이름</option>
							<option value="id">아이디</option>
							<option value="address">주소</option>
							<option value="all">전체</option>
						</select>
						<input type="text" name="searchWord" >
						<button class="btn btn-primary mx-1" >검색</button>		
			</form>
		</div>
</div>

<script>


	$("#checkAll").on("click",function(){
		if($("#checkAll").is(":checked")) {
			$(".check").prop("checked",true);
		} else {
			$(".check").prop("checked",false);
		}
	});
	
	$(".btnDelete").on("click",function(){
		console.log("나는 마지막 줄에 return false가 있어서 form태그의 액션에 있는 주소로 가지 않음");
		console.log($(this).data("no"));
		console.log($(this));
		const $parent = $(this).parent().parent();
		
		$.ajax({
			url:"../member/delete-process.jsp",
			data:{
				userNo:$(this).data("no"),
			},
			success:function(response){
				console.log(response);
				if(response.isDelete==="success"){
					// alert("삭제 되었음");
					// location.reload(); //새로고침
					console.log($(this)); //삭제 + 새로고침
					$parent.remove();
				} else {
					alert("서버 오류입니다.");
				}
			},
			fail:function(){
				
			}
		})
		return false;

	});
	
	
</script>



<%@ include file="../include/footer.jsp" %>