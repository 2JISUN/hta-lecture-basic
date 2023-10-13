package com.jisun.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jisun.dao.MemberDao;
import com.jisun.dto.MemberDto;
import com.jisun.dto.ModalState;


public class MemberInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberInsertProcess() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		int postCode = Integer.parseInt(request.getParameter("postCode"));
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		
		
		String uploadDirectory = "C:\\upload02";
		String realUploadPath = uploadDirectory;
		
		
		Part part = request.getPart("profile");

		String partHeader = part.getHeader("Content-disposition");
		String partArray[] = partHeader.split("filename=");
		String originalFileName = partArray[1].trim().replace("\"", "");
		String newFileName = "";
		String folder = "";
		if(!originalFileName.isEmpty()) {
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			folder = simpleDateFormat.format(now);
			File dir = new File(realUploadPath+File.separator+folder);
			if(!dir.exists()) {
				dir.mkdir();
			}
			part.write(dir+File.separator+originalFileName);
		
			String firstFileName = originalFileName.substring(0,originalFileName.lastIndexOf("."));
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
			String strNow = simpleDateFormat02.format(now);
			newFileName =  firstFileName+strNow+ext;
			File oldFile = new File(dir+File.separator+originalFileName);
			File newFile = new File(dir+File.separator+newFileName);
			oldFile.renameTo(newFile);
		}
		String profile = folder+File.separator+newFileName;
		
		MemberDto memberDto  = new MemberDto();
		memberDto.setId(userID);
		memberDto.setPassword(userPW);
		memberDto.setName(userName);
		memberDto.setAddress(address);
		memberDto.setPostcode(postCode);
		memberDto.setAddressdetail(detailAddress);
		memberDto.setEmail(email);
		memberDto.setTel(tel);
		memberDto.setProfile(profile);;
		
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto); 
		if(result>0) {
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","회원가입 되었습니다");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/login");
			
		} else {
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","오류입니다.");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/insert");
		}
		

	}

}
	
	
	
	
	
	
	
	
	
	
