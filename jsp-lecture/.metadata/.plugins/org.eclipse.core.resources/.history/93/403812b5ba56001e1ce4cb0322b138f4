<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div class="container">
		<form action="insert-member-process.jsp" method="post" class=""
			name="member">
			<div class="row d-flex justify-content-center mt-5">
				<div class="col-6">
					<div class="mb-3">
						<label for="userID" class="form-label">ID</label> <input
							type="text" class="form-control" id="userID"
							placeholder="user id" name="userID" />
						<button class="btn btn-primary" id="btnIDCheck">아이디 중복 확인</button>
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="userPW" class="form-label">password</label> <input
							type="password" class="form-control" id="userPW"
							placeholder="user password" name="userPW" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="userPW02" class="form-label">password Confirm</label>
						<input type="password" class="form-control" id="userPW02"
							placeholder="user password" />
						<div class="invalid-feedback">글자 써보기</div>
					</div>
				</div>
			</div>

			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="userName" class="form-label">Name</label> <input
							type="text" class="form-control" id="userName"
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
									placeholder="post code" name="postCode" />
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
							placeholder="address" />
					</div>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<label for="detailAddress" class="form-label">Detail
							Address</label> <input type="text" class="form-control"
							id="detailAddress" placeholder="detail address"
							name="detailAddress" />
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
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					const roadAddr = data.roadAddress; // 도로명 주소 변수
					const extraRoadAddr = ""; // 참고 항목 변수

					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.querySelector("#postCode").value = data.zonecode;
					document.querySelector("#address").value = roadAddr;
					//document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

					// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
					// if (roadAddr !== "") {
					//   document.getElementById("sample4_extraAddress").value = extraRoadAddr;
					// } else {
					//   document.getElementById("sample4_extraAddress").value = "";
					// }

					//var guideTextBox = document.getElementById("guide");
					// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
					// if (data.autoRoadAddress) {
					//   var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
					//   guideTextBox.innerHTML = "(예상 도로명 주소 : " + expRoadAddr + ")";
					//   guideTextBox.style.display = "block";
					// } else if (data.autoJibunAddress) {
					//   var expJibunAddr = data.autoJibunAddress;
					//   guideTextBox.innerHTML = "(예상 지번 주소 : " + expJibunAddr + ")";
					//   guideTextBox.style.display = "block";
					// } else {
					//   guideTextBox.innerHTML = "";
					//   guideTextBox.style.display = "none";
					// }
				},
			}).open();
		}

		$("#btnPostcode").on("click", function() {
			postcode();
			return false;
		});

		$("#btnSubmit").on("click", function(e) {
			if ($("#userID").val().trim() === "") {
				alert("id는 필수입력 사항입니다.");
				$("#userID").val("");
				$("#userID").focus();
				return false;
			} else if ($("#userPW").val().trim() === "") {
				alert("password는 필수입력 사항입니다.");
				$("#userPW").val("");
				$("#userPW").focus();
				return false;
			} else if ($("#userPW02").val().trim() === "") {
				alert("password 확인");
				$("#userPW02").val("");
				$("#userPW02").focus();
				return false;
			}
		});
		$("#userPW02").on("keyup", function() {
			if ($("#userPW").val() !== $("#userPW02").val()) {
				$(".invalid-feedback").show();
				$(".invalid-feedback").text("password가 맞지 않습니다.");
			} else {
				$(".invalid-feedback").hide();
				$(".invalid-feedback").text("");
			}
		});
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

		$("#btnIDCheck").on("click", function() {
			$.ajax({
				url : "idCheck.jsp",
				data : {
					userID : $("#userID").val(),
				},
				//method: "get",
				success : function(data) {
					//console.log("success");
					//console.log(data);
					if(data.count>0) {
						alert("쓸 수 없는 아이디입니다.");
						$("#userID").val("");
					} else {
						const useID = confirm("쓸 수 있는 아이디 입니다. 사용하시겠어요?");
						if(useID) {
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
	</script>
<%@ include file="../include/footer.jsp" %>