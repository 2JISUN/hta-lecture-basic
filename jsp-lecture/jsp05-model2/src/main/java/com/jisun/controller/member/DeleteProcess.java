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
import com.jisun.util.ScriptWriter;


public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public DeleteProcess() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPW = request.getParameter("userPW");
		
		//세션에 logged저장된 아이를 불러옴
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userName = (String)session.getAttribute("loggedName");
		
		MemberDao memberDao = new MemberDao();
				
		int result = memberDao.deleteMember(userID,userPW);
		if(result>0) {
			ScriptWriter.alertAndNext(response, userName + "님 회원 탈퇴되었습니다", "../index/index");
		} else {

			ScriptWriter.alertAndBack(response, "패스워드 불일치입니다. 다시 시도해주세요.");
		}

	}

}
