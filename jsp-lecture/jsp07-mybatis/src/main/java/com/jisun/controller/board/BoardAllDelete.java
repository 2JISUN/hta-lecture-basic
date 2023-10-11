package com.jisun.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.jisun.dao.BoardDao;

public class BoardAllDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardAllDelete() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		//ArrayList<Integer> noList = new ArrayList<>();
		//noList.add(12);
		//noList.add(13);
		//noList.add(14);
		
		String tempArray[]= request.getParameterValues("no");
		int noList[] = new int[tempArray.length];
		for(int i = 0; i<tempArray.length; i++) {
			noList[i] = Integer.parseInt(tempArray[i]);
		}
		
		int result = boardDao.deleteAllBoard(noList);
		if(result>noList.length) {
			System.err.println("여러개 지워졌음");
		} else {
			System.err.println("오류");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
