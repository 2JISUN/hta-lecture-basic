/*
[역할]
페이지를 불러오기 위한 서블릿

[로직]
클라이언트가 GET 요청을 보내면, 
로그인 페이지(login.jsp)를 표시합니다.

*/

package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();

    }

    // 페이지 넘겨주는 방식 : get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
