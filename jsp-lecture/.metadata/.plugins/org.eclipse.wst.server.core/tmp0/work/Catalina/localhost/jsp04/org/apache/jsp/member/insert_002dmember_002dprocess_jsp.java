/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-09-20 06:55:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import util.ScriptWriter;
import java.sql.PreparedStatement;
import common.JDBCConnect;

public final class insert_002dmember_002dprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("util.ScriptWriter");
    _jspx_imports_classes.add("common.JDBCConnect");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
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

      out.write("<!-- process 회원가입 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 

	//0.전역변수 할당
	//get : request.getParameter를 사용하여 사용자가 입력한 정보를 받아옵니다.
	String userID = request.getParameter("userID"); //get : 아이디
	String userPW = request.getParameter("userPW"); //get : 비밀번호
	String userName = request.getParameter("userName"); //get : 이름
	
	
    Integer postCode = null; // Integer로 선언하여 null 허용
    if (request.getParameter("postCode") != null && !request.getParameter("postCode").isEmpty()) {
        postCode = Integer.parseInt(request.getParameter("postCode")); // 값이 있는 경우에만 파싱
    }
	

	String address = request.getParameter("address"); //get : 주소
	String detailAddress = request.getParameter("detailAddress"); //get : 상세주소

	//1. driver 찾기
	//2. db연동
	JDBCConnect jdbcConn = new JDBCConnect(); //Oracle 데이터베이스에 연결을 수행
	
	
	

	
	//3. db접근 > 쿼리 작성 > INSERT, UPDATE, DELETE > db 업데이트 > executeUpdate()
	//3. db접근 > 쿼리 작성 > SELECT > db 가져오기 > executeQuery()
	//3-1. 쿼리 작성
	String sql = 
			"insert into member values(seq_member.nextval,?,?,?,?,?,?,sysdate)";
	//3-2. 쿼리 세팅(저장)
	PreparedStatement pstmt = null; //Prepared : SQL 문장을 실행하기
	pstmt = jdbcConn.conn.prepareStatement(sql); //prepare : PreparedStatement 객체를 생성하는 메서드
	//set : pstmt.setString를 사용하여 사용자가 입력한 정보를 db에 저장합니다.
	pstmt.setString(1,userID);
	pstmt.setString(2,userPW);
	pstmt.setString(3,userName);
    if (postCode != null) {
        pstmt.setInt(4, postCode); // postCode 값이 null이 아닌 경우에만 설정
    } else {
        pstmt.setNull(4, java.sql.Types.INTEGER); // postCode 값이 null인 경우
    }
	pstmt.setString(5,address);
	pstmt.setString(6,detailAddress);
	
	//4. db실행 > 쿼리 실행 > db 업데이트 > executeUpdate()
	//4. db실행 > 쿼리 실행 > db 가져오기(결과 확인) : 화면에 뿌린다 > executeQuery()
	//result는 데이터베이스 조작 작업을 실행한 결과로서, 영향을 받는 <레코드 수>를 나타내는 정수입니다. 
	int result = pstmt.executeUpdate(); //executeUpdate() 레코드 수를 반환합니다.
	
	
	
	
	
	//5. 조건 > 회원가입 성공여부 > 방법01 > form
	if(result>0) {
		// 회원가입 성공
		System.out.println("입력 되었음");
		ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../index/index.jsp");
	} else  {
		System.out.println("입력 오류");
		ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해 주세요");
	}
	


	
	
	// 데이터베이스 연결 종료
	

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
