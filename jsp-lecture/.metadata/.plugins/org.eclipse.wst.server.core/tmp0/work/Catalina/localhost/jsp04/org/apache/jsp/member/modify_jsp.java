/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-09-19 05:49:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import util.ScriptWriter;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import common.JDBCConnect;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/member/../include/header.jsp", Long.valueOf(1695090973399L));
    _jspx_dependants.put("/member/../include/footer.jsp", Long.valueOf(1695089494198L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("util.ScriptWriter");
    _jspx_imports_classes.add("java.sql.ResultSet");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("      <a href=\"/\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none\">\r\n");
      out.write("        <svg class=\"bi me-2\" width=\"40\" height=\"32\"><use xlink:href=\"#bootstrap\"></use></svg>\r\n");
      out.write("        <span class=\"fs-4\">Simple header</span>\r\n");
      out.write("      </a>\r\n");
      out.write("      \r\n");
      out.write("      ");
 if(loggedName==null){ 
      out.write("\r\n");
      out.write("			<!-- 회원가입 -->\r\n");
      out.write("	      <ul class=\"nav nav-pills\">\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../index/index.jsp\" class=\"nav-link active\" aria-current=\"page\">마이홈</a></li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../member/insert.jsp\" class=\"nav-link\">회원가입</a></li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../member/login.jsp\" class=\"nav-link\">로그인</a></li>\r\n");
      out.write("	        <li class=\"nav-item\"><a href=\"../member/list.jsp\" class=\"nav-link\">게시판</a></li>\r\n");
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
      out.write("	        <li class=\"nav-item\"><a href=\"../member/list.jsp\" class=\"nav-link\">게시판</a></li>\r\n");
      out.write("	      </ul>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- header 끝 -->\r\n");
      out.write("  \r\n");
      out.write("  <main>");
      out.write("\r\n");
      out.write("<div class=\"info w-100 m-auto\">\r\n");
      out.write("	<form action=\"../member/modify-process.jsp\" method=\"post\">\r\n");
      out.write("		<input type=\"hidden\" name=\"userID\" value=\"");
      out.print( loggedID );
      out.write("\"> \r\n");
      out.write("		<table class=\"table striped\">\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th scope=\"row\">ID</th>\r\n");
      out.write("					");
      out.write("\r\n");
      out.write("					<td>");
      out.print( loggedID );
      out.write("</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th scope=\"row\">password</th>\r\n");
      out.write("					<td><div class=\"mb-3\">\r\n");
      out.write("							<input\r\n");
      out.write("								type=\"password\" class=\"form-control\" id=\"userPW\"\r\n");
      out.write("								placeholder=\"user password\" name=\"userPW\" />\r\n");
      out.write("						</div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"d-flex justify-content-center\">\r\n");
      out.write("			<button class=\"btn btn-primary\">회원정본 변경 확인</button>\r\n");
      out.write("			<a href=\"javascript:histroy.back();\" class=\"btn btn-secondary mx-1\">돌아가기</a>\r\n");
      out.write("		</div>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
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
