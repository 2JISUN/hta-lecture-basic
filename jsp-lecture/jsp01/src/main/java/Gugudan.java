

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Gugudan() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<h1>hello servlet</h1>");
		out.println("<h1>헬로 서블릿</h1>");
		// servlet : 자바 코드안에 html 쓰기
		// jsp	   : html안에 자바 코드 쓰기
	}


}
