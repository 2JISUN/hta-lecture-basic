package com.jisun.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.dao.BoardDao;
import com.jisun.dto.Board;
import com.jisun.util.ScriptWriter;


public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardWriteProcess() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password"); //비밀번호
		String title = request.getParameter("title"); //제목
		String content = request.getParameter("content"); //내용
		doGet(request, response);
		
		Board boardDto = new Board();
		HttpSession session = request.getSession();
		boardDto.setId((String)session.getAttribute("loggedID"));
		boardDto.setName((String)session.getAttribute("loggedName"));
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setPassword(password);
		
		
		BoardDao boardDao = new BoardDao();
		
		int result = boardDao.insertBoard(boardDto);
		if(result>0) {
			response.sendRedirect("../board/list");
			
		} else {
			ScriptWriter.alertAndBack(response, "서버오류입니다.");
		}
	}

}
