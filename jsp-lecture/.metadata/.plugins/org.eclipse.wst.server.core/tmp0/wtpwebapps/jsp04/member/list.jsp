<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ServletContext context = pageContext.getServletContext(); //절대경로를 얻는다
System.out.println("context===" + context);
String saveDirectory = "upload";
String realFolder = context.getRealPath(saveDirectory);
JDBCConnect jdbcConn = new JDBCConnect();
String sql = "select no,rpad(substr(id,1,3),length(id),'*') as id, id as realID,"
		+ "substr(name,1,1) || lpad('*',length(name)-2,'*')  || substr(name,length(name),1) as name,"
		+ "rpad(substr(postcode,1,2),5,'*') as postcode,address, addressdetail, "
		+ "to_char(regdate,'YYYY-MM-DD') as regdate from member";
PreparedStatement pstmt = jdbcConn.conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<%@ include file="../include/header.jsp"%>
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
					<!-- <th scope="col">profile</th> -->
					<th scope="col">삭제</th>
					<th scope="col"><input type="checkbox" id="checkAll"></th>
				</tr>
			</thead>
			<tbody>
				<%
				while (rs.next()) {
				%>
				<tr>
					<th scope="row"><%=rs.getInt("no")%></th>
					<td><a
						href="../member/info.jsp?userID=<%=rs.getString("realID")%>"><%=rs.getString("id")%></a></td>
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("postcode")%></td>
					<td><%=rs.getString("address")%></td>
					<td><%=rs.getString("addressdetail")%></td>
					<td><%=rs.getString("regdate")%></td>

					<!-- <td><img src="/jsp04/upload/20230921_15339765.png"></td> -->
					<td><button class="btn btn-danger btnDelete"
							data-no="<%=rs.getInt("no")%>">삭제</button></td>
					<td scope="col"><input type="checkbox" name="check"
						class="check" value="<%=rs.getInt("no")%>"></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div></div>
		<button class="btn btn-danger" id="btnAll">삭제</button>
	</form>
	<form action="../member/member-search-list.jsp">
		<select name="searchItem">
			<option value="name">이름</option>
			<option value="id">아이디</option>
			<option value="address">주소</option>
			<option value="all">싹다</option>

		</select> <input type="text" name="searchWord">
		<button>검색</button>
	</form>
</div>
<script>
	$("#checkAll").on("click", function() {
		if ($("#checkAll").is(":checked")) {
			$(".check").prop("checked", true);
		} else {
			$(".check").prop("checked", false);
		}
	})
	$(".btnDelete")
			.on(
					"click",
					function() {
						console
								.log("나는 마지막 줄에  return false가 있어서 form 태그의 액션에 있는 주소로 가지 않습니다");
						console.log($(this).data("no"));
						console.log($(this));
						const $parent = $(this).parent().parent();
						$.ajax({
							url : "../member/delete-process02.jsp",
							data : {
								userNo : $(this).data("no"),
							},
							success : function(response) {
								console.log(response);
								if (response.isDelete === "success") {
									//alert("삭제 되었습니다.");
									//location.reload();
									console.log($(this));
									$parent.remove();
								} else {
									alert("서버 오류입니다.");
								}
							},
							fail : function() {

							}

						})
						return false;
					});
</script>

<%@ include file="../include/footer.jsp"%>