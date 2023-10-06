package com.jisun.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.jisun.dao.BoardDao;
import com.jisun.dto.BoardDto;


public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boardList = boardDao.list();
		request.setAttribute("boardList", boardList);
		dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}