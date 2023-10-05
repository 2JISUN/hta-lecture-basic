package com.jisun.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jisun.dao.BoardDao;
import com.jisun.dao.MemberDao;
import com.jisun.dto.Board;
import com.jisun.dto.Member;
import com.jisun.util.ScriptWriter;


public class BoardModifyConfirmProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardModifyConfirmProcess() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int no = 0;
		if(strNo!=null && !strNo.isEmpty()) {
			no = Integer.parseInt(strNo);
		}
		
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.modifyConfirmProcess(no,title,content);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "수정되었습니다.", "../board/list");
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인해 주세요");
		}

		
	}

}
