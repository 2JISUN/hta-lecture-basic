package com.jisun.controller.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ImageUpload() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미지 전달
		Part ck = request.getPart("upload"); //프로필 이미지
		//경로지정방법2 외부(c드라이브)에 저장 > server.xml에 외부경로를 반드시 추가해주어야함
				String uploadDirectory = "C:\\upload"; //이미지를 업로드할 디렉토리 경로를 지정
				String realUploadPath = uploadDirectory; // 업로드 디렉토리의 실제 경로를 가져옵니다.
				
				
				String partHeader = ck.getHeader("Content-disposition"); // 프로필 이미지의 Content-Disposition 헤더 정보
				String partHeaderArray[] = partHeader.split("filename="); // Content-Disposition 헤더에서 파일 이름을 추출
				String originalFileName = partHeaderArray[1].trim().replace("\"", ""); // Content-Disposition 헤더에서 파일 이름을 추출
				String newFileName = "";
						// 만약 업로드된 파일이 비어있지 않다면, 실제 업로드를 수행합니다.
						if(!originalFileName.isEmpty()) {
							
							// 파일을 실질적인(물리적) 경로에 저장합니다.
							ck.write(realUploadPath + File.separator + originalFileName);
							
							// 파일 이름에서 파일명과 확장자명을 각각 추출합니다.
							String firstFileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")); //파일명
							String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.확장자(.png, ,jpg..)
							
							// 파일 이름에 추가할 날짜를 추출합니다
							Date now = new Date();
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
							String strNow = simpleDateFormat.format(now);
							
							//★새로운 파일 이름을 생성합니다
							newFileName = firstFileName + strNow + ext; //원본파일명 + 날짜 + .png
							
							// 이전 파일을 새로운 파일 이름형식으로 변경합니다.
							File oldFile = new File(realUploadPath + File.separator + originalFileName);
							File newFile = new File(realUploadPath + File.separator + newFileName);
							oldFile.renameTo(newFile);
						}
		
		
		//이미지 전달되었다는 것을 클라이언트에게 전달
		
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<>();
		map.put("url", request.getContextPath()+"/upload/"+newFileName);
		map.put("uploaded", true);
		
		String resultJson = gson.toJson(map);
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/image-uploaded.jsp");
		dispatcher.forward(request, response);
	}
}
