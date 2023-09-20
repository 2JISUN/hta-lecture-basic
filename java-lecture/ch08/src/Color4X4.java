import javax.swing.*;
import java.awt.*;

public class Color4X4 {

	// 메서드 - 랜덤 색상
	private static Color generateRandomColor(){
		int r = (int) (Math.random()*256);
		int g = (int) (Math.random()*256);
		int b = (int) (Math.random()*256);
		return new Color(r,g,b);
	}


	// 메서드 메인
	public static void main(String[] args) {
		
		// 1. 컴포넌트 객체 생성 (UI)
		// JFrame(윈도우), JButton(버튼), JLabel(레이블) 등
		JFrame frame = new JFrame("Color Grid Example"); //JFrame(윈도우)

		// 2. 컴포넌트 구성
		// 각 컴포넌트의 속성 및 동작을 설정할 수 있다.
		// 3. 이벤트 핸들링
		// 사용자 입력에 대한 반응을 정의(ex.클릭)\

	
		// 4*4 그리드 생성
		JPanel[][] colorJPanels = new JPanel[4][4]; //JPanel(그리드)
		frame.setLayout(new GridLayout(4,4)); // 프레임 레이아웃을 GridLayout으로 설정
		
	
		// 각 그리드 셀에 색상을 설정하고 프레임에 추가
		for(int row = 0; row<4; row++){
			for(int col=0; col<4; col++){
				JPanel panel = new JPanel();
				Color color = generateRandomColor(); // 랜덤 색상 생성
				panel.setBackground(color); // 배경색 설정
				frame.add(panel); //패널을 프레임에 추가
				colorJPanels[row][col] = panel; //그리드 셀에 패널 저장
			}
	
		}



		// 4. 레이아웃 설정
		// 각 컴포넌트 배치를 관리
		frame.setSize(600, 400); //프레임 크기 설정
		
		
		
		// 5. UI 표시 및 종료
		// 모든 설정이 완료되면 화면에 표시하기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램 종료
		frame.setVisible(true); //화면에 출력








	}
	


	



}
