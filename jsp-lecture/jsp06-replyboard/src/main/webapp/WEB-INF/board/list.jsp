<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div class="container">
		<h2 class="mb-5 mt-5">list.jsp</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">no</th>
		      <th scope="col">title</th>
		      <th scope="col">writer</th>
		      <th scope="col">date</th>
		      <th scope="col">hit</th>
		      <th scope="col">group</th>
		      <th scope="col">level</th>
		      <th scope="col">step</th>
		      
		      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${boardList }" var="board" varStatus="status">
		    <tr>
		      <td>${status.index }</td>
		      <td><a href="../board/view?no=${board.no}" class="step step${board.restep }">${board.title }</a></td>
		      <td>${board.name }</td>
		      <td>${board.regDate }</td>
		      <td>${board.hit }</td>
		      <td>${board.regroup }</td>
		      <td>${board.relevel }</td>
		      <td>${board.restep }</td>
		      
		    </tr>
		    </c:forEach>
		    
		  </tbody>
		</table>
	</div>
<%@ include file="../include/footer.jsp" %>
    