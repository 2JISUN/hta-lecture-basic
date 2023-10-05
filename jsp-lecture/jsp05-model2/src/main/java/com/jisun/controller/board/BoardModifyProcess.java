package com.jisun.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jisun.dao.BoardDao;
import com.jisun.dto.Board;
import com.jisun.util.ScriptWriter;


public class BoardModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardModifyProcess() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		int no=0;
		if(strNo!=null && !strNo.isEmpty()) {
			no= Integer.parseInt(strNo);
		}
		String password = request.getParameter("password");
		BoardDao boardDao = new BoardDao();
		Board modifyBoard = boardDao.modifyBoard(no,password);
		if(modifyBoard!=null) {
			request.setAttribute("modifyBoard", modifyBoard);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/modify-form.jsp");
			dispatcher.forward(request, response);
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호 확인해 주세요.");
		}
	}

}
