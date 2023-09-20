import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingExample {
	public static void main(String[] args) {
		// 1. 컴포넌트 객체 생성 (UI) - JFrame(윈도우), JButton(버튼), JLabel(레이블) 등
		JFrame frame = new JFrame("Swing 예시"); //윈도우 창
		JButton button = new JButton("클릭"); //버튼 생성

		// 2. 컴포넌트 구성 - 각 컴포넌트의 속성 및 동작을 설정할 수 있다.
		// 3. 이벤트 핸들링 - 사용자 입력에 대한 반응을 정의(ex.클릭)
		// 액션(이벤트) 구현 후 처리
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane을 사용하여 메시지 대화 상자 표시
				JOptionPane.showMessageDialog(null, "메시지 대화창 입니다.");
			}
		});


		// 4. 레이아웃 설정 - 각 컴포넌트 배치를 관리
		frame.add(button); //프레임에 버튼 추가
		frame.setSize(1000, 600); //프레임 크기 설정
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼 클릭 시 프로그램 종료
		

		
		// 5. UI 표시 - 모든 설정이 완료되면 화면에 표시하기
		frame.setVisible(true);
		






	}
}
