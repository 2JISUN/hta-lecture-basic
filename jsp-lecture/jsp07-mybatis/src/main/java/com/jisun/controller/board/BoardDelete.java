package com.jisun.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.jisun.dao.BoardDao;
import com.jisun.dto.ModalState;


public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDelete() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no"); // 글번호
		int no = 0; 
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(no);
		if(result>0) {
			
			String msg = URLEncoder.encode("글이 삭제되었습니다.", StandardCharsets.UTF_8); //한글인식
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show", "글이 삭제되었습니다.");
			
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../board/list");
			
		} else {

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
