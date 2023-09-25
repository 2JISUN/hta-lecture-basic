/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-09-25 06:52:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/member/../include/header.jsp", Long.valueOf(1695278344167L));
    _jspx_dependants.put("/member/../include/footer.jsp", Long.valueOf(1695089494198L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- page 회원가입 -->\n");
      out.write("\n");
      out.write("\r\n");
      out.write("    \r\n");
 
	String loggedID = (String)session.getAttribute("loggedID");
	String loggedName = (String)session.getAttribute("loggedName");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/form.css\" />\r\n");
      out.write("<script src=\"../js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery-3.7.1.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\">\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <header class=\"d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom\">\r\n");
      out.write("      <a href=\"../index/index.jsp\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none\">\r\n");
      out.write("        <svg class=\"bi me-2\" width=\"40\" height=\"32\"><use xlink:href=\"#bootstrap\"></use></svg>\r\n");
      out.write("        <span class=\"fs-4\">👻 ← click me</span>\r\n");
      out.write("      </a>\r\n");
      out.write("      \r\n");
      out.write("      ");
 if(loggedName==null){ 
      out.write("\r\n");
      out.write("			<!-- 회원가입 -->\r\n");
      out.write("	      <ul class=\"nav nav-pills\">\r\n");
      out.write("	        <li class=\"nav-item\">\r\n");
      out.write("	        	<a href=\"../index/index.jsp\" class=\"nav-link active\" aria-current=\"page\">마이홈</a>\r\n");
      out.write("	        </li>\r\n");
      out.write("	        <li class=\"nav-item\">\r\n");
      out.write("	        	<a href=\"../member/insert.jsp\" class=\"nav-link\">회원가입</a>\r\n");
      out.write("	        </li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../member/login.jsp\" class=\"nav-link\">로그인</a></li>\r\n");
      out.write("	        <!-- <li class=\"nav-item\"><a href=\"../board/list.jsp\" class=\"nav-link\">게시판</a></li> -->\r\n");
      out.write("	      </ul>\r\n");
      out.write("      ");
 } else { 
      out.write("\r\n");
      out.write("	      <!-- 로그아웃 -->\r\n");
      out.write("	      <ul class=\"nav nav-pills\">\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../index/index.jsp\" class=\"nav-link active\" aria-current=\"page\">마이홈</a></li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../member/logout.jsp\" class=\"nav-link\">로그아웃</a></li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../member/info.jsp?userID=");
      out.print(loggedID );
      out.write("\" class=\"nav-link\">");
      out.print( loggedName );
      out.write("</a></li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../board/list.jsp\" class=\"nav-link\">게시판</a></li>\r\n");
      out.write("	      </ul>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- header 끝 -->\r\n");
      out.write("  \r\n");
      out.write("  <main>");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("	<form \n");
      out.write("		action=\"insert-member-process.jsp\" \n");
      out.write("		method=\"post\" \n");
      out.write("		class=\"\"\n");
      out.write("		id=\"joinForm\" \n");
      out.write("		name=\"member\">\n");
      out.write("		\n");
      out.write("		");

		// 아이디
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<div class=\"row\">\n");
      out.write("						<!-- 입력창 -->\n");
      out.write("						<div class=\"col-6\">\n");
      out.write("							<input \n");
      out.write("									type=\"text\" \n");
      out.write("									class=\"form-control\" \n");
      out.write("									id=\"userID\" \n");
      out.write("									placeholder=\"아이디\"\n");
      out.write("									name=\"userID\" />\n");
      out.write("						</div>	\n");
      out.write("						\n");
      out.write("						<!-- 중복확인 버튼 -->\n");
      out.write("						<div class=\"col-6 mt-3 align-items-baseline px-0\">\n");
      out.write("							<button class=\"btn btn-primary\" id=\"btnIDCheck\">아이디 중복 확인</button>\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		\n");
      out.write("		");

		// 비밀번호
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<input\n");
      out.write("							type=\"password\" \n");
      out.write("							class=\"form-control\" \n");
      out.write("							id=\"userPW\"\n");
      out.write("							placeholder=\"비밀번호\" \n");
      out.write("							name=\"userPW\" />\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		");

		// 비밀번호 재확인
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<input\n");
      out.write("							type=\"password\" \n");
      out.write("							class=\"form-control\" \n");
      out.write("							id=\"userPW02\"\n");
      out.write("							placeholder=\"비밀번호 재학인\" />\n");
      out.write("					<div class=\"invalid-feedback\">글자 써보기</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		");

		//이름
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<input\n");
      out.write("							type=\"text\" \n");
      out.write("							class=\"form-control\" \n");
      out.write("							id=\"userName\"\n");
      out.write("							placeholder=\"이름\" \n");
      out.write("							name=\"userName\" />\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		");

		//우편번호
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<div class=\"row\">\n");
      out.write("						<div class=\"col-6\">\n");
      out.write("						<!--<label for=\"postCode\" class=\"form-label\">우편번호</label>  -->\n");
      out.write("							<input\n");
      out.write("									type=\"text\" \n");
      out.write("									class=\"form-control\" \n");
      out.write("									id=\"postCode\"\n");
      out.write("									placeholder=\"우편번호\" \n");
      out.write("									name=\"postCode\" />\n");
      out.write("						</div>\n");
      out.write("						\n");
      out.write("						<div class=\"col-6 mt-3 align-items-baseline px-0\">\n");
      out.write("							<button class=\"btn btn-primary mt-3\" id=\"btnPostcode\">우편번호 및 주소 선택</button>\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		");

		//주소
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<input\n");
      out.write("						type=\"text\" \n");
      out.write("						class=\"form-control\" \n");
      out.write("						id=\"address\" \n");
      out.write("						name=\"address\"\n");
      out.write("						placeholder=\"주소\" />\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		\n");
      out.write("		");

		//상세주소
		
      out.write("\n");
      out.write("		<div class=\"row d-flex justify-content-center\">\n");
      out.write("			<div class=\"col-6\">\n");
      out.write("				<div class=\"mb-3\">\n");
      out.write("					<!-- <label for=\"detailAddress\" class=\"form-label\">Detail Address</label> --> \n");
      out.write("						<input \n");
      out.write("						type=\"text\" \n");
      out.write("						class=\"form-control\" \n");
      out.write("						id=\"detailAddress\"\n");
      out.write("						placeholder=\"상세주소\" \n");
      out.write("						name=\"detailAddress\" />\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		");

		//process 버튼
		
      out.write("\n");
      out.write("		<div class=\"mt-5 mb-5 d-flex justify-content-center\">\n");
      out.write("			<div class=\"\">\n");
      out.write("				<!-- 회원가입 -->\n");
      out.write("				<button type=\"submit\" class=\"btn btn-primary\" id=\"btnSubmit\">회원가입</button>\n");
      out.write("				<!-- Ajax 회원가입 -->\n");
      out.write("				<button type=\"submit\" class=\"btn btn-primary\" id=\"btnSubmitAjax\">Ajax 회원가입</button>\n");
      out.write("				<button type=\"reset\" class=\"btn btn-secondary\">취소</button>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("	// 다음 주소지 API 사용하기\n");
      out.write("	// https://postcode.map.daum.net/guide\n");
      out.write("	function postcode() {\n");
      out.write("		new daum.Postcode({\n");
      out.write("			oncomplete : function(data) {\n");
      out.write("				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\n");
      out.write("\n");
      out.write("				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.\n");
      out.write("				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\n");
      out.write("				const roadAddr = data.roadAddress; // 도로명 주소 변수\n");
      out.write("				const extraRoadAddr = \"\"; // 참고 항목 변수\n");
      out.write("\n");
      out.write("				// 법정동명이 있을 경우 추가한다. (법정리는 제외)\n");
      out.write("				// 법정동의 경우 마지막 문자가 \"동/로/가\"로 끝난다.\n");
      out.write("\n");
      out.write("				// 우편번호와 주소 정보를 해당 필드에 넣는다.\n");
      out.write("				document.querySelector(\"#postCode\").value = data.zonecode; //우편번호\n");
      out.write("				document.querySelector(\"#address\").value = roadAddr; //주소\n");
      out.write("			},\n");
      out.write("		}).open();\n");
      out.write("	}\n");
      out.write("\n");
      out.write("\n");
      out.write("	// $(jQuery)로 버튼을 찾고 기능 추가 \n");
      out.write("	// 기능 : 다음 주소지 API 사용하기\n");
      out.write("	$(\"#btnPostcode\").on(\"click\", function() {\n");
      out.write("		postcode();\n");
      out.write("		return false;\n");
      out.write("	});\n");
      out.write("	\n");
      out.write("	\n");
      out.write("\n");
      out.write("	// $(jQuery)로 버튼을 찾고 기능 추가 \n");
      out.write("	// 기능 : 아이디, 비밀번호는 반드시 입력받아야 함\n");
      out.write("	$(\"#btnSubmit, #btnSubmitAjax\").on(\"click\", function(e) {\n");
      out.write("				if (   $(\"#userID\").val().trim() === \"\"\n");
      out.write("				 	|| $(\"#userPW\").val().trim() === \"\"\n");
      out.write("				 	|| $(\"#userName\").val().trim() === \"\") {\n");
      out.write("					alert(\"아이디, 비밀번호, 이름은 필수로 입력되어야 합니다.\");\n");
      out.write("					return false;\n");
      out.write("				}\n");
      out.write("	});\n");
      out.write("	\n");
      out.write("	\n");
      out.write("\n");
      out.write("	// 기능 : '비밀번호'와 '비밀번호 재확인' 입력값이 일치하는지 여부\n");
      out.write("	// jquery\n");
      out.write("	$(\"#userPW02\").on(\"keyup\", function() {\n");
      out.write("		if ($(\"#userPW\").val() !== $(\"#userPW02\").val()) {\n");
      out.write("			$(\".invalid-feedback\").show();\n");
      out.write("			$(\".invalid-feedback\").text(\"password가 맞지 않습니다.\");\n");
      out.write("		} else {\n");
      out.write("			$(\".invalid-feedback\").hide();\n");
      out.write("			$(\".invalid-feedback\").text(\"\");\n");
      out.write("		}\n");
      out.write("	});\n");
      out.write("	\n");
      out.write("	// 바닐라 스크립트\n");
      out.write("	//   const btnSubmit = document.querySelector(\"#btnSubmit\");\n");
      out.write("	//   btnSubmit.addEventListener(\"click\", function (e) {\n");
      out.write("	//     if (member.userID.value.trim() === \"\") {\n");
      out.write("	//       e.preventDefault();\n");
      out.write("	//       alert(\"id는 필수입력 사항입니다.\");\n");
      out.write("	//       member.userID.value = \"\";\n");
      out.write("	//       member.userID.focus();\n");
      out.write("	//       return false;\n");
      out.write("	//     }\n");
      out.write("	//   });\n");
      out.write("\n");
      out.write("	\n");
      out.write("	\n");
      out.write("	// 기능 : 아이디 중복 확인 후 결과에 따라 메시지 출력\n");
      out.write("	$(\"#btnIDCheck\").on(\"click\", function() {\n");
      out.write("		\n");
      out.write("		// 아이디 입력받지 않았을 경우\n");
      out.write("	    var userID = $(\"#userID\").val().trim(); // 입력 값 양 끝 공백 제거\n");
      out.write("	    if (userID === \"\") {\n");
      out.write("	        alert(\"아이디를 입력하세요.\"); // 입력 값이 비어 있는 경우 경고창 출력\n");
      out.write("	        return false; // 아무 작업도 하지 않고 종료\n");
      out.write("	    }\n");
      out.write("\n");
      out.write("		$.ajax({\n");
      out.write("			url : \"idCheck.jsp\",\n");
      out.write("			data : {\n");
      out.write("	            userID: userID, // 수정된 입력 값 사용\n");
      out.write("			},\n");
      out.write("			success : function(data) {\n");
      out.write("\n");
      out.write("				if (data.count > 0) {\n");
      out.write("					alert(\"쓸 수 없는 아이디입니다.\");\n");
      out.write("					$(\"#userID\").val(\"\");\n");
      out.write("				} else {\n");
      out.write("					const useID = confirm(\"쓸 수 있는 아이디 입니다. 사용하시겠어요?\");\n");
      out.write("					if (useID) {\n");
      out.write("						$(\"#userID\").attr(\"readonly\", true);\n");
      out.write("					}\n");
      out.write("				}\n");
      out.write("			},\n");
      out.write("			fail : function(error) {\n");
      out.write("				console.log(error);\n");
      out.write("			},\n");
      out.write("			complete : function(data) {\n");
      out.write("				console.log(\"complete\");\n");
      out.write("				console.log(data);\n");
      out.write("			}\n");
      out.write("		});\n");
      out.write("		return false;\n");
      out.write("	});\n");
      out.write("\n");
      out.write("	/* 		\n");
      out.write("	\n");
      out.write("	 // 기능 : 비밀번호 보기/감추기 (유저선택사항)\n");
      out.write("	 $(\"#btnShowPassword\").on(\"click\", function(){\n");
      out.write("	 if($(\"#userPW\").attr(\"type\")===\"password\"){\n");
      out.write("	 $(\"#userPW\").attr(\"type\",\"text\");\n");
      out.write("	 $(\"#btnShowPassword\").text(\"비밀번호 감추기\");\n");
      out.write("	 } else {\n");
      out.write("	 $(\"#userPW\").attr(\"type\",\"password\");\n");
      out.write("	 $(\"#btnShowPassword\").text(\"비밀번호 보기\");\n");
      out.write("	 }\n");
      out.write("	 return false;\n");
      out.write("	 }); \n");
      out.write("	 */\n");
      out.write("\n");
      out.write("	// 기능 : Ajax 회원가입\n");
      out.write("	$(\"#btnSubmitAjax\").on(\"click\", function(e) {\n");
      out.write("		$.ajax({\n");
      out.write("			url : \"../member/insert-member-ajax-process.jsp\",\n");
      out.write("			data : $(\"#joinForm\").serialize(), /* 한 번에 다 바꿀 수 있는 js 메소드 */\n");
      out.write("			success : function(response) {\n");
      out.write("				if (reponse.isMemberInsert === \"success\") {\n");
      out.write("					alert(\"회원가입 되었습니다.\");\n");
      out.write("					location.href = \"../index/index.jsp\";\n");
      out.write("				} else {\n");
      out.write("					alert(\"서버 오류입니다.\");\n");
      out.write("					history.back();\n");
      out.write("				}\n");
      out.write("			}\n");
      out.write("		});\n");
      out.write("	});\n");
      out.write("</script>\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <footer class=\"d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top\">\r\n");
      out.write("    <div class=\"col-md-4 d-flex align-items-center\">\r\n");
      out.write("      <a href=\"/\" class=\"mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1\">\r\n");
      out.write("        <svg class=\"bi\" width=\"30\" height=\"24\"><use xlink:href=\"#bootstrap\"></use></svg>\r\n");
      out.write("      </a>\r\n");
      out.write("      <span class=\"mb-3 mb-md-0 text-body-secondary\">Â© 2023 Company, Inc</span>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"nav col-md-4 justify-content-end list-unstyled d-flex\">\r\n");
      out.write("      <li class=\"ms-3\"><a class=\"text-body-secondary\" href=\"#\"><svg class=\"bi\" width=\"24\" height=\"24\"><use xlink:href=\"#twitter\"></use></svg></a></li>\r\n");
      out.write("      <li class=\"ms-3\"><a class=\"text-body-secondary\" href=\"#\"><svg class=\"bi\" width=\"24\" height=\"24\"><use xlink:href=\"#instagram\"></use></svg></a></li>\r\n");
      out.write("      <li class=\"ms-3\"><a class=\"text-body-secondary\" href=\"#\"><svg class=\"bi\" width=\"24\" height=\"24\"><use xlink:href=\"#facebook\"></use></svg></a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </footer>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- footer ë -->\r\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
