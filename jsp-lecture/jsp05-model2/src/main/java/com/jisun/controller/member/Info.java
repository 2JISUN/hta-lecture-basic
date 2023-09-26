/*
[역할]


[로직]

*/

package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jisun.dao.MemberDao;
import com.jisun.dto.Member;
import com.jisun.util.ScriptWriter;


public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Info() {
        super();
    }


    // url로 넘어옴 > doGet 방식을 사용한다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		MemberDao memberDao = new MemberDao();
		Member infoMember = memberDao.infoMember(userID);
		if(infoMember==null) {
			ScriptWriter.alertAndBack(response, "서버 오류입니다. 잠시 후 다시 시도해 주삼");
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/info.jsp");
			request.setAttribute("infoMember", infoMember);
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
