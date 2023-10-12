package com.jisun.controller.board;

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


public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		BoardDao boardDao = new BoardDao();
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("category",category);
		searchMap.put("keyword",keyword);
		List<BoardDto> searchList = boardDao.getSearchBoard(searchMap);
		System.out.println(searchList.size()); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}