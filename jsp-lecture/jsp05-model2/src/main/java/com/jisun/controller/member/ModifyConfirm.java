package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
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


public class ModifyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyConfirm() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 logged저장된 아이를 불러옴
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userPW = request.getParameter("userPW");
		MemberDao memberDao = new MemberDao();
		Member modifyMember = memberDao.modifyPasswordConfirm(userID,userPW);
		if(modifyMember!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/modify-form.jsp");
			dispatcher.forward(request, response);
		} else {
			ScriptWriter.alertAndBack(response, "패스워드확인plz");
		}

	}
}
