

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugudan-result")
public class GugudanResult extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GugudanResult() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        int dan = Integer.parseInt(request.getParameter("dan"));

        out.println(dan + "단 출력합니다");

        for (int i = 1; i < 10; i++) { // 반복 변수의 이름을 i로 변경

            out.println("<li>" + dan + " X " + i + " = " + dan * i + "</li>");

        }
    }
}
