<%@page import="util.ScriptWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="info w-100 m-auto">
	<form action="../member/modify-process.jsp" method="post">
		<input type="hidden" name="userID" value="<%= loggedID %>"> 
		<table class="table striped">
			<tbody>
				<tr>
					<th scope="row">ID</th>
					<%-- <td><input type="text" class="form-control" 
					name="userID" value="<%= loggedID %>" readonly></td> --%>
					<td><%= loggedID %></td>
				</tr>
				<tr>
					<th scope="row">password</th>
					<td><div class="mb-3">
							<input
								type="password" class="form-control" id="userPW"
								placeholder="user password" name="userPW" />
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div class="d-flex justify-content-center">
			<button class="btn btn-primary">회원정본 변경 확인</button>
			<a href="javascript:histroy.back();" class="btn btn-secondary mx-1">돌아가기</a>
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>















