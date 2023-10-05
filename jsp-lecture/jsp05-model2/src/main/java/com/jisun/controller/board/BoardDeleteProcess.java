package com.jisun.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jisun.dao.BoardDao;
import com.jisun.dto.Board;
import com.jisun.util.ScriptWriter;


public class BoardDeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDeleteProcess() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password"); //비밀번호
		String strNo = request.getParameter("no");
		
		int no = 0;
		if(strNo!=null ) {
			if(!strNo.isEmpty()) {
				no = Integer.parseInt(strNo);
			}
		}
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(no,password);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인해 주세요");
		}
	}

}
