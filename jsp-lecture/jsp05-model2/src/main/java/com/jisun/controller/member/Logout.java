/*
[역할]
로직을 수행하는 서블릿

[로직]
클라이언트에서 로그아웃 요청이 오면, 
세션(Session)을 무효화하고 로그아웃 메시지를 표시한 후 다른 페이지로 이동합니다.
*/

package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.util.ScriptWriter;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Logout() {
        super();
    }

    //doGet 메서드에서는 세션 객체를 얻어옵니다. 세션은 사용자의 로그인 상태와 관련된 정보를 저장하는 곳입니다.
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();//session.invalidate()를 호출하여 현재 세션을 무효화시킵니다. 이로써 현재 사용자의 로그인 상태가 해제됩니다.
		ScriptWriter.alertAndNext(response, "로그아웃됨", "../");
	}


	//doPost 메서드에서는 doGet 메서드를 호출하여 GET 요청에 응답합니다.
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
