

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/item-result")
public class ItemResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ItemResult() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String items[] = request.getParameterValues("item");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        if(items==null) {
        	out.println("<span>관심없음</span>");
        }
        for(int i =0;i<items.length;i++) {
        	out.println("<span>"+items[i]+"</span>");
        }
        for(String item:items) {
        	out.println("<span>"+item+"</span>");

        }
	}
}
