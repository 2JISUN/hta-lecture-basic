/*
[역할]
로직을 수행하는 서블릿

[로직]
클라이언트가 POST 요청을 보내면, 
회원 정보를 데이터베이스에 삽입하고 결과를 반환합니다.
*/


package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jisun.common.JDBCConnect;
import com.jisun.dao.MemberDao;
import com.jisun.dto.Member;
import com.jisun.util.ScriptWriter;


public class InsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	//doPost 메서드에서는 클라이언트로부터 전송된 회원 정보를 읽어와서 Member 객체로 저장합니다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new com.jisun.common.JDBCConnect();
		//MemberDao를 사용하여 회원 정보를 데이터베이스에 삽입합니다.
		MemberDao memberdao = new MemberDao();
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null && !request.getParameter("postCode").isEmpty()) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		Member insertMember = new Member();
		insertMember.setId(userID);
		insertMember.setPassword(userPW);
		insertMember.setName(userName);
		insertMember.setAddress(address);
		insertMember.setPostcode(postCode);
		insertMember.setAddressdetail(detailAddress);
		
		
		
		int result = memberdao.insertMember(insertMember);
		if(result>0) {
			//정보가 없을 경우 > 회원가입 성공
			ScriptWriter.alertAndNext(response, "회원가입완료", "../index/index");
		} else {
			
			//정보가 있을 경우 > 회원가입 실패 
			//서버오류
			ScriptWriter.alertAndBack(response, "서버오류입니다. 다시 시도해주세요.");
		}
	}
}