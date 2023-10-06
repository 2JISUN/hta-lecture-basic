package com.jisun.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jisun.dao.BoardDao;
import com.jisun.dto.BoardDto;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public View() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no=0;
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		BoardDao boardDao = new BoardDao();
		BoardDto viewBoard = boardDao.view(no);
		request.setAttribute("viewBoard", viewBoard);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/view.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}