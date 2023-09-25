

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Hi() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String name02 = request.getParameter("name02");
		Person person = new Person();
		person.setName("이지선");
		person.setNickName("시즈니");
		person.setAge(1996);
		person.setGender("female");
		
		
		Person person02 = new Person("마크","메가마인드",1999,"male");
		Person person03 = new Person("런쥔","어깡",2000,"male");
		Person person04 = new Person("한소희","얼짱",1994,"female");
		Person person05 = new Person("차은우","내아이디강남미인",1997,"male");
		Person person06 = new Person("고윤정","무빙연기천재",1996,"female");
		Person person07 = new Person("전여빈","멜로가체질존잼",1994,"female");
		
		List<Person> personList = new ArrayList<>();
		personList.add(person02);
		personList.add(person03);
		personList.add(person04);
		personList.add(person05);
		personList.add(person06);
		personList.add(person07);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("hi.jsp");
		request.setAttribute("me", person); //단순구조로 데이터 보내기
		request.setAttribute("personList", personList); //선형리스트구조로 데이터 보내기
		
	
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
