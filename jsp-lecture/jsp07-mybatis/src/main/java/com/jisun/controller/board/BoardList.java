package com.jisun.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.jisun.dao.BoardDao;
import com.jisun.dto.BoardDto;
import com.jisun.dto.PageDto;


public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int start = Integer.parseInt(request.getParameter("start"));
		//int end = Integer.parseInt(request.getParameter("start"));
		
		BoardDao boardDao = new BoardDao();
		HashMap <String,Integer> pageMap = new HashMap<>();
		pageMap.put("start", 1);
		pageMap.put("end", 10);
		
		PageDto pageDto = new PageDto();
		pageDto.setStart(1);
		pageDto.setEnd(7);
		List<BoardDto> boardList = boardDao.getAllBoard(pageDto);

		request.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}