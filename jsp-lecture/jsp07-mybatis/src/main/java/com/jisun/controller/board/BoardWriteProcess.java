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
import com.jisun.dto.BoardDto;
import com.jisun.dto.ModalState;


public class BoardWriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public BoardWriteProcess() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		String title = request.getParameter("title"); //제목
		String content = request.getParameter("content"); //비밀번호
		
		
		
		boardDto.setUserID("jisun");
		boardDto.setName("이지선");
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setRegroup(8);
		boardDto.setRelevel(1);
		boardDto.setRestep(1);
		
		int result = boardDao.writeBoard(boardDto);
		if(result>0) {
			//String msg = URLEncoder.encode("글이 등록되었습니다.", StandardCharsets.UTF_8);
			//response.sendRedirect("../board/list?state=show&msg="+msg);
			
			HttpSession session = request.getSession();
			
			ModalState modalState = new ModalState("show","글이 등록되었습니다.");
			session.setAttribute("modalState", modalState);
			
			response.sendRedirect("../board/list");
		} else {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
