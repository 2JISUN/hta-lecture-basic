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
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jisun.common.JDBCConnect;
import com.jisun.dao.MemberDao;
import com.jisun.dto.Member;
import com.jisun.service.MemberService;
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
		//db필드
		MemberService memberDao = new MemberDao();
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		int postCode = 0;
		if(request.getParameter("postCode")!=null && !request.getParameter("postCode").isEmpty()) {
			postCode = Integer.parseInt(request.getParameter("postCode"));
		}
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		
		Part profile = request.getPart("profile"); //프로필 이미지
		//경로지정방법1 내부에 저장
		//String uploadDirectory = "upload";
		//String realUploadPath = getServletContext().getRealPath(uploadDirectory); // 업로드 디렉토리의 실제 경로를 가져옵니다.
		
		//경로지정방법2 외부(c드라이브)에 저장
		String uploadDirectory = "C:\\upload"; //이미지를 업로드할 디렉토리 경로를 지정
		String realUploadPath = uploadDirectory; //server.xml에 외부경로 추가해줌
		
		String partHeader = profile.getHeader("Content-disposition"); // 프로필 이미지의 Content-Disposition 헤더 정보
		String partHeaderArray[] = partHeader.split("filename="); // Content-Disposition 헤더에서 파일 이름을 추출
		String originalFileName = partHeaderArray[1].trim().replace("\"", ""); // Content-Disposition 헤더에서 파일 이름을 추출
		String newFileName = "";
				// 만약 업로드된 파일이 비어있지 않다면, 실제 업로드를 수행합니다.
				if(!originalFileName.isEmpty()) {
					// 파일을 실질적인(물리적) 경로에 저장합니다.
					profile.write(realUploadPath + File.separator + originalFileName);
					// 파일 이름에서 파일명과 확장자명을 각각 추출합니다.
					String firstFileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")); //파일명
					String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.확장자(.png, ,jpg..)
					// 파일 이름에 추가할 날짜를 추출합니다
					Date now = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
					String strNow = simpleDateFormat.format(now);
					
					//⭐새로운 파일 이름을 생성합니다
					newFileName = firstFileName + strNow + ext; //원본파일명 + 날짜 + .png
					
					// 이전 파일을 새로운 파일 이름형식으로 변경합니다.
					File oldFile = new File(realUploadPath + File.separator + originalFileName);
					File newFile = new File(realUploadPath + File.separator + newFileName);
					oldFile.renameTo(newFile);
				}
		

		Member insertMember = new Member();
		insertMember.setId(userID);
		insertMember.setPassword(userPW);
		insertMember.setName(userName);
		insertMember.setAddress(address);
		insertMember.setPostcode(postCode);
		insertMember.setAddressdetail(detailAddress);
		insertMember.setEmail(email);
		insertMember.setTel(tel);
		insertMember.setProfile(newFileName);
		
		
		
		int result = memberDao.insertMember(insertMember);
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