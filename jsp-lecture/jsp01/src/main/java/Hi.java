

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public Hi() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		if(age < 18) {
			PrintWriter out = response.getWriter();
			out.println("당신의 이름은 <" + name + "> 입니다. 미성년자는 꺼져라");
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("당신의 이름은 <" + name + "> 입니다. 환영합니다.");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
