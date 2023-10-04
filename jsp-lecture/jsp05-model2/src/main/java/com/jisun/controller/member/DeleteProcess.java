package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;

import com.jisun.dao.MemberDao;
import com.jisun.dto.Member;
import com.jisun.util.ScriptWriter;


public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public DeleteProcess() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPW = request.getParameter("userPW");
		
		//세션에 logged저장된 아이를 불러옴
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("loggedID");
		String userName = (String)session.getAttribute("loggedName");
		
		MemberDao memberDao = new MemberDao();
				
		int result = memberDao.deleteMember(userID,userPW);
	    // 회원 탈퇴 전에 프로필 이미지 파일 이름을 가져옴
	   
		Member loggedMember = (Member)session.getAttribute("loggedMember");
	    String profile = loggedMember.getProfile();
		if(result>0) {
			// 회원 탈퇴 성공 시 프로필 이미지 파일을 삭제
			String uploadDirectory = "C:\\upload"; //디렉토리 경로를 지정
			String realUploadPath = uploadDirectory; // 업로드 디렉토리의 실제 경로를 가져옵니다.
			File profileFile = new File(realUploadPath + File.separator + profile);
	        if (profileFile.exists()) {
                profileFile.delete(); // 파일 삭제
	        }
			ScriptWriter.alertAndNext(response, userName + "님 회원 탈퇴되었습니다", "../index/index");
			session.invalidate();
		} else {

			ScriptWriter.alertAndBack(response, "패스워드 불일치입니다. 다시 시도해주세요.");
		}
	}
}
