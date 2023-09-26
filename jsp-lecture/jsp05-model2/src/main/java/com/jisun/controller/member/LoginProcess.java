/*
[역할]
로직을 수행하는 서블릿

[로직]
클라이언트가 POST 요청을 보내면, 
사용자가 입력한 아이디와 비밀번호를 확인하고
성공 시 로그인 상태를 유지하며 다른 페이지로 리다이렉트하거나, 
실패 시 오류 메시지를 표시합니다.
 
*/

package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.dao.MemberDao;
import com.jisun.dto.Member;
import com.jisun.util.CookieManager;
import com.jisun.util.ScriptWriter;


public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginProcess() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String saveID = request.getParameter("saveID");
		MemberDao memberDao = new MemberDao();
		Member loggedMember = memberDao.loginMember(userID,userPW);
		if(loggedMember!=null) {
			//세션에 logged저장
			HttpSession session = request.getSession();
						session.setAttribute("loggedID",loggedMember.getId() );
						session.setAttribute("loggedName",loggedMember.getName());
						session.setAttribute("loggedMember",loggedMember);
			
			//쿠키 설정
			if(saveID!=null){
				if(saveID.equals("rememberMe")) {
					CookieManager.createCookie(response, "saveIDCookie", userID, 60*60*24*365);
				} else {
					CookieManager.deleteCookie(response, "saveIDCookie");
				}
			} else {
				CookieManager.deleteCookie(response, "saveIDCookie");
			}
			response.sendRedirect("../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "아이디 패스워드 확인해주세요");
		}
			
	}

}
