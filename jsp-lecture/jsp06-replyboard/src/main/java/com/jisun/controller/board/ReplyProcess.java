package com.jisun.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jisun.dao.BoardDao;
import com.jisun.dto.BoardDto;
import com.jisun.util.ScriptWriter;


public class ReplyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		int regroup = Integer.parseInt(request.getParameter("regroup"));
		int relevel = Integer.parseInt(request.getParameter("relevel"));
		int restep = Integer.parseInt(request.getParameter("restep"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setRegroup(regroup);
		boardDto.setRelevel(relevel);
		int levelResult = boardDao.updateRelevel(boardDto);
		boardDto.setUserID(userID);
		boardDto.setName(name);
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDto.setRegroup(regroup);
		boardDto.setRelevel(relevel+1);
		boardDto.setRestep(restep+1);
		int result = boardDao.reply(boardDto);
		if(result>0) {
			response.sendRedirect("../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "다시 쓰세요");
		}
	}
}