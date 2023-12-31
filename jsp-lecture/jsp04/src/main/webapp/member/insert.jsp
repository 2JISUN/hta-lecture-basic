<!-- page 회원가입 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<form 
		action="insert-member-process.jsp" 
		method="post" 
		class=""
		id="joinForm" 
		name="member">
		
		<%
		// 아이디
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<div class="row">
						<!-- 입력창 -->
						<div class="col-6">
							<input 
									type="text" 
									class="form-control" 
									id="userID" 
									placeholder="아이디"
									name="userID" />
						</div>	
						
						<!-- 중복확인 버튼 -->
						<div class="col-6 mt-3 align-items-baseline px-0">
							<button class="btn btn-primary" id="btnIDCheck">아이디 중복 확인</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		
		<%
		// 비밀번호
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<input
							type="password" 
							class="form-control" 
							id="userPW"
							placeholder="비밀번호" 
							name="userPW" />
				</div>
			</div>
		</div>
		
		<%
		// 비밀번호 재확인
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<input
							type="password" 
							class="form-control" 
							id="userPW02"
							placeholder="비밀번호 재학인" />
					<div class="invalid-feedback">글자 써보기</div>
				</div>
			</div>
		</div>
		
		<%
		//이름
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<input
							type="text" 
							class="form-control" 
							id="userName"
							placeholder="이름" 
							name="userName" />
				</div>
			</div>
		</div>
		
		<%
		//우편번호
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<div class="row">
						<div class="col-6">
						<!--<label for="postCode" class="form-label">우편번호</label>  -->
							<input
									type="text" 
									class="form-control" 
									id="postCode"
									placeholder="우편번호" 
									name="postCode" />
						</div>
						
						<div class="col-6 mt-3 align-items-baseline px-0">
							<button class="btn btn-primary mt-3" id="btnPostcode">우편번호 및 주소 선택</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%
		//주소
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<input
						type="text" 
						class="form-control" 
						id="address" 
						name="address"
						placeholder="주소" />
				</div>
			</div>
		</div>
		
		
		<%
		//상세주소
		%>
		<div class="row d-flex justify-content-center">
			<div class="col-6">
				<div class="mb-3">
					<!-- <label for="detailAddress" class="form-label">Detail Address</label> --> 
						<input 
						type="text" 
						class="form-control" 
						id="detailAddress"
						placeholder="상세주소" 
						name="detailAddress" />
				</div>
			</div>
		</div>
		
		<%
		//process 버튼
		%>
		<div class="mt-5 mb-5 d-flex justify-content-center">
			<div class="">
				<!-- 회원가입 -->
				<button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
				<!-- Ajax 회원가입 -->
				<button type="submit" class="btn btn-primary" id="btnSubmitAjax">Ajax 회원가입</button>
				<button type="reset" class="btn btn-secondary">취소</button>
			</div>
		</div>
	</form>
</div>



<script>
	// 다음 주소지 API 사용하기
	// https://postcode.map.daum.net/guide
	function postcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				const roadAddr = data.roadAddress; // 도로명 주소 변수
				const extraRoadAddr = ""; // 참고 항목 변수

				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.querySelector("#postCode").value = data.zonecode; //우편번호
				document.querySelector("#address").value = roadAddr; //주소
			},
		}).open();
	}


	// $(jQuery)로 버튼을 찾고 기능 추가 
	// 기능 : 다음 주소지 API 사용하기
	$("#btnPostcode").on("click", function() {
		postcode();
		return false;
	});
	
	

	// $(jQuery)로 버튼을 찾고 기능 추가 
	// 기능 : 아이디, 비밀번호는 반드시 입력받아야 함
	$("#btnSubmit, #btnSubmitAjax").on("click", function(e) {
				if (   $("#userID").val().trim() === ""
				 	|| $("#userPW").val().trim() === ""
				 	|| $("#userName").val().trim() === "") {
					alert("아이디, 비밀번호, 이름은 필수로 입력되어야 합니다.");
					return false;
				}
	});
	
	

	// 기능 : '비밀번호'와 '비밀번호 재확인' 입력값이 일치하는지 여부
	// jquery
	$("#userPW02").on("keyup", function() {
		if ($("#userPW").val() !== $("#userPW02").val()) {
			$(".invalid-feedback").show();
			$(".invalid-feedback").text("password가 맞지 않습니다.");
		} else {
			$(".invalid-feedback").hide();
			$(".invalid-feedback").text("");
		}
	});
	
	// 바닐라 스크립트
	//   const btnSubmit = document.querySelector("#btnSubmit");
	//   btnSubmit.addEventListener("click", function (e) {
	//     if (member.userID.value.trim() === "") {
	//       e.preventDefault();
	//       alert("id는 필수입력 사항입니다.");
	//       member.userID.value = "";
	//       member.userID.focus();
	//       return false;
	//     }
	//   });

	
	
	// 기능 : 아이디 중복 확인 후 결과에 따라 메시지 출력
	$("#btnIDCheck").on("click", function() {
		
		// 아이디 입력받지 않았을 경우
	    var userID = $("#userID").val().trim(); // 입력 값 양 끝 공백 제거
	    if (userID === "") {
	        alert("아이디를 입력하세요."); // 입력 값이 비어 있는 경우 경고창 출력
	        return false; // 아무 작업도 하지 않고 종료
	    }

		$.ajax({
			url : "idCheck.jsp",
			data : {
	            userID: userID, // 수정된 입력 값 사용
			},
			success : function(data) {

				if (data.count > 0) {
					alert("쓸 수 없는 아이디입니다.");
					$("#userID").val("");
				} else {
					const useID = confirm("쓸 수 있는 아이디 입니다. 사용하시겠어요?");
					if (useID) {
						$("#userID").attr("readonly", true);
					}
				}
			},
			fail : function(error) {
				console.log(error);
			},
			complete : function(data) {
				console.log("complete");
				console.log(data);
			}
		});
		return false;
	});

	/* 		
	
	 // 기능 : 비밀번호 보기/감추기 (유저선택사항)
	 $("#btnShowPassword").on("click", function(){
	 if($("#userPW").attr("type")==="password"){
	 $("#userPW").attr("type","text");
	 $("#btnShowPassword").text("비밀번호 감추기");
	 } else {
	 $("#userPW").attr("type","password");
	 $("#btnShowPassword").text("비밀번호 보기");
	 }
	 return false;
	 }); 
	 */

	// 기능 : Ajax 회원가입
	$("#btnSubmitAjax").on("click", function(e) {
		$.ajax({
			url : "../member/insert-member-ajax-process.jsp",
			data : $("#joinForm").serialize(), /* 한 번에 다 바꿀 수 있는 js 메소드 */
			success : function(response) {
				if (reponse.isMemberInsert === "success") {
					alert("회원가입 되었습니다.");
					location.href = "../index/index.jsp";
				} else {
					alert("서버 오류입니다.");
					history.back();
				}
			}
		});
	});
</script>
<%@ include file="../include/footer.jsp"%>



















