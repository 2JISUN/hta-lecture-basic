package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.dao.MemberDao;
import com.jisun.dto.MemberDto;
import com.jisun.dto.ModalState;


public class MemberLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberLoginProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		MemberDto loggedMember = null;
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userID);
		memberDto.setPassword(userPW);
		MemberDao memberDao = new MemberDao();
		loggedMember = memberDao.loginMember(memberDto);
		if(loggedMember!=null) {
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","로그인되었습니다.");
			session.setAttribute("modalState", modalState);
			session.setAttribute("loggedID", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			session.setAttribute("profile", loggedMember.getProfile());
			response.sendRedirect("../board/list");
		}
		
	}

}
