<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("userName");
	String postCode = (String)request.getAttribute("postCode");
	String address = (String)request.getAttribute("address");
	String addressDetail = (String)request.getAttribute("addressDetail");
	

%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<form action="insert-member-process.jsp" method="post" class=""
		name="member">
		<div class="row d-flex justify-content-center mt-5">
			<div class="col-6">
				<div class="mb-3">
					<%= loggedID %>
				</div>
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<label for="userName" class="form-label">Name</label> <input
						type="text" class="form-control" id="userName" value="<%= userName %>"
						placeholder="user name" name="userName" />
				</div>
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<div class="row">
						<div class="col-6">
							<label for="postCode" class="form-label">ZipCode</label> <input
								type="text" class="form-control" id="postCode"
								placeholder="post code" name="postCode" value="<%= postCode %>" />
						</div>
						<div class="col-6 mt-3 align-items-baseline px-0">
							<button class="btn btn-primary mt-3" id="btnPostcode">우편번호
								확인</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<label for="address" class="form-label">Address</label> <input
						type="text" class="form-control" id="address" name="address"
						placeholder="address"  value="<%= address %>" />
				</div>
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<label for="detailAddress" class="form-label">Detail
						Address</label> <input type="text" class="form-control" id="detailAddress"
						placeholder="detail address" name="detailAddress" value="<%=addressDetail%>" />
				</div>
			</div>
		</div>
		<div class="mt-5 mb-5 d-flex justify-content-center">
			<div class="">
				<button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</div>
		</div>
	</form>
</div>

<script>
	function postcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				const roadAddr = data.roadAddress; // 도로명 주소 변수
				const extraRoadAddr = ""; // 참고 항목 변수

				document.querySelector("#postCode").value = data.zonecode;
				document.querySelector("#address").value = roadAddr;

			},
		}).open();
	}

	$("#btnPostcode").on("click", function() {
		postcode();
		return false;
	});
</script>
<%@ include file="../include/footer.jsp"%>