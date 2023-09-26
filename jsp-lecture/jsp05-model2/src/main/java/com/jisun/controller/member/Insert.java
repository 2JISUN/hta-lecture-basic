/*
[역할]
페이지를 불러오기 위한 서블릿

[로직]
클라이언트가 GET 요청을 보내면, 
회원 가입 폼이 포함된 JSP 페이지로 이동합니다.

*/

package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Insert() {
        super();
    }
    //doGet 메서드에서는 회원 가입 폼이 포함된 JSP 페이지로 포워딩합니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher를 사용하여 JSP 페이지로 포워딩합니다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/insert.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
