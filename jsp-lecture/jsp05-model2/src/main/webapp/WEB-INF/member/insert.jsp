<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div class="container">
		<%-- <h1>${pageContext.request.contextPath }</h1>--%>
		
		<form action="../member/insert-process" 
				method="post" 
				class="" 
				id="joinForm"
				name="member"
				enctype="multipart/form-data">  <!-- 이미지 업로드를 위한 속성 -->
				
			<!-- 이름 -->
			<div class="row d-flex justify-content-center mt-5">
				<div class="col-6">
					<div class="mb-3">
						<div class="row">
							<div class="col-6">
								<input 
									type="text" 
									class="form-control" 
									id="userID"
									placeholder="아이디" 
									name="userID" />
							</div>
							<div class="col-6  mt-3 d-flex align-items-baseline px-0">
								<button class="btn btn-primary mt-3" id="btnIDCheck">아이디 중복 확인</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 비밀번호 -->
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
			
			<!-- 비밀번호 재확인 -->
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<input 
							type="password" 
							class="form-control" 
							id="userPW02"
							placeholder="비밀번호 재확인" />
						<div class="invalid-feedback">글자 써보기</div>
					</div>
				</div>
			</div>

			<!-- 이름 -->
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
			
			<!-- 이메일 -->
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						
						<input
							type="email" 
							class="form-control" 
							id="email"
							placeholder="이메일" 
							name="email" />
					</div>
				</div>
			</div>
			
			<!-- 전화번호 -->
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						
						<input
							type="text" 
							class="form-control" 
							id="tel"
							placeholder="전화번호를 입력해주세요" 
							name="tel" />
					</div>
				</div>
			</div>
			
			<!-- 주소지 -->
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<div class="row">
							<div class="col-6">
								<input
									type="text" 
									class="form-control" 
									id="postCode"
									placeholder="우편번호" 
									name="postCode" />
							</div>
							<div class="col-6 mt-3 align-items-baseline px-0">
								<button class="btn btn-primary mt-3" id="btnPostcode">우편번호
									검색</button> 
							</div>
						</div>
					</div>
				</div>
			</div>
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
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<input 
							type="text" 
							class="form-control"
							id="detailAddress" 
							placeholder="상세주소"
							name="detailAddress" />
					</div>
				</div>
			</div>
			
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<input 
							type="file" 
							class="form-control"
							id="profile" 
							placeholder="프로필 이미지(png, jpg)"
							name="profile" 
							accept=".jpg,.png,.gif,jpeg"/>
					</div>
				</div>
			</div>
			
			<!-- 프로필 이미지 미리보기 -->
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<div class="mb-3">
						<lable>프로필 이미지 미리보기</lable>
						<div class="preview"></div>
					</div>
				</div>
			</div>
			
			
			
			
			<div class="mt-5 mb-5 d-flex justify-content-center">
				<div class="">
					<button type="submit" class="btn btn-primary" id="btnSubmit">회원가입</button>
					<button type="submit" class="btn btn-primary" id="btnSubmitAjax">Ajax회원가입</button>
					<button type="reset" class="btn btn-secondary">취소</button>
				</div>
			</div>
		</form>
	</div>



	<script>
		let isIDCheck = false;
		
		function postcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
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
			} else if (!isIDCheck){
				alert("id 중복 체크를 해주세요");
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
		
		$("#btnSubmitAjax").on("click",function(){
			$.ajax({
				url:"../member/insert-member-ajax-process.jsp",
				data:$("#joinForm").serialize(),
				success:function(response) {
					if(response.isMemberInsert==="success") {
						alert("회원가입 되었습니다.");
						location.href="../index/index.jsp";
					} else {
						alert("서버 오류입니다.");
						history.back();
					}
				}
			});
		})
		
		
		$("#btnIDCheck").on("click", function() {
			$.ajax({
				url : "../member/id-check",
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
							isIDCheck=true;
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
		
		// 이미지 미리보기
		$("#profile").on("change",function(e){
			const file = e.target.files[0];
			const reader = new FileReader();
			const ext = file.name.substring(file.name.lastIndexOf(".")+1);
			
			if(!(ext==="png"||ext==="jpg"||ext==="gif")){
				alret("png,jpg,gif 만 프로필 이미지로 사용가능합니다");
				$(".profile").val("");
				return false;
			} else {
				reader.onload = function(e){
					$(".preview").html(`<img src="\${e.target.result}">`)
				}
				
				
			}
			
			reader.readAsDataURL(file);
		})
		
	</script>
<%@ include file="../include/footer.jsp" %>