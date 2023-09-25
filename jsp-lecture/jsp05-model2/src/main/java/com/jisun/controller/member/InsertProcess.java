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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//여기서 회원가입 처리....
		//PrintWriter out = response.getWriter();
		//out.println("test");
		com.jisun.common.JDBCConnect jdbcConn =  new com.jisun.common.JDBCConnect();
		MemberDao memberdao = new MemberDao();
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null) {
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
			
			ScriptWriter.alertAndNext(response, "회원가입완료", "../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "서버오류입니다. 다시 시도해주세요.");
		}

	
	}

}