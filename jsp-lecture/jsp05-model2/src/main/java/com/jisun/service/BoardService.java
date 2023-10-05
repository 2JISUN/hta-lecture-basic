/*부장님 zone~*/
/*

서비스 인터페이스(interface)로서, 회원 관련 기능을 제공하는 서비스 계층(Service Layer)의 메서드를 정의한 것입니다. 

웹 애플리케이션을 모델2(MVC) 아키텍처와 같이 계층으로 나누면, 각 계층(프레젠테이션, 서비스, 데이터 액세스)이 독립적으로 변경 및 유지보수 가능하게 됩니다. 
이를 위해 서비스 인터페이스는 비즈니스 로직과 서비스 메서드의 추상화를 담당하며, 구현체는 실제 비즈니스 로직을 구현하게 됩니다.

*/

package com.jisun.service;
import java.util.List;

import com.jisun.dto.Board;

public interface BoardService {
	List<Board> list();
	int insertBoard(Board board); //ckeditor
	Board viewBoard(int no);
	int deleteBoard(int no, String password);

	
}
