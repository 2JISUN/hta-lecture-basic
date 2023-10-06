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


public class WriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//title , content
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		
		BoardDao boardDao = new BoardDao();
		BoardDto insertBoardDto = new BoardDto();
		insertBoardDto.setTitle(title);
		insertBoardDto.setContent(content);
		insertBoardDto.setUserID(userID);
		insertBoardDto.setName(name);
		
		int result = boardDao.write(insertBoardDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 등록되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류로 잠시 후 다시 시도해 주시기 바랍니다.");
		}
	}
}