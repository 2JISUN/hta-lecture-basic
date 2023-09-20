
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

//0.전역변수 할당
//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.

//1. driver 찾기
//2. db연동 및 해제
JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행

//3. db접근 > 쿼리 작성 > select > db 가져오기 > executeQuery()
//3-1. 쿼리 작성
String sql = 
"select "+
	   "no,"+
	   "rpad(substr(id,1,3),length(id),'*') as id,"+  
	   "id as realID,"+  /* 마스킹 안 된 아이디 */
	   "substr(name,1,1) || lpad('*',length(name)-2,'*') || substr(name,length(name),1) as name," +
	   "rpad(substr(postcode,1,2),5,'*') as postcode,"+
	   "address,"+
	   "addressdetail,"+
	   "to_char(regdate,'yyyy/mm/dd') as regdate " + 
"from member"
		;

//3-2. 쿼리 세팅(저장)
PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.


//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
ResultSet rs = null; //rs는 SQL 쿼리의 결과 집합으로 JDBC 객체임
rs = pstmt.executeQuery(); //executeQuery() 쿼리를 데이터베이스로 보내고 그 결과를 가져온다. 

//5. 조건 > 값 전체 뿌리기



%>


<%@ include file="../include/header.jsp" %>





<div class="container">
	<form action="../member/delete-all.jsp">
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
		      <th scope="col">delete</th>
		      <th scope="col">
		      	<input type="checkbox" 
		      		   id="checkAll">
		      </th>
		    </tr>
		  </thead>
		  
		  <tbody>
		   		<% while(rs.next()){ %>
		   		    <tr>
			   	      <th scope="row"><%=rs.getInt("no")%></th>
			   	      <td>
			   	      	<a href="../member/info.jsp?userID=<%=rs.getString("realID") %>">
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
		<button class="btn btn-danger" id="btnAll">
			삭제
		</button>
	</form>
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
			url:"../member/delete-process02.jsp",
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