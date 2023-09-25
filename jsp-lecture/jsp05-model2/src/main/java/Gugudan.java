

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Gugudan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 결과를 request에 저장
		request.setAttribute("name", "jisun_hello");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("gugudan.jsp");
		dispatcher.forward(request,response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
