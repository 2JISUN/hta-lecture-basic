/*
[역할]
로직을 수행하는 서블릿

[로직]
클라이언트로부터 전달된 사용자 아이디(userID)를 받아와서, 
해당 아이디가 데이터베이스에 이미 존재하는지 확인한 후 그 결과를 JSON 형식으로 응답

[클라이언트 응답]
id-check.jsp

*/

package com.jisun.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.jisun.dao.MemberDao;


public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IDCheck() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		MemberDao memberDao = new MemberDao();
		int count = memberDao.idCheck(userID);
		Gson gson = new Gson();
		Map<String,Integer> map = new HashMap<>();
		map.put("count", count);
		String resultJson = gson.toJson(map); //{count:1}
		
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/id-check.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
