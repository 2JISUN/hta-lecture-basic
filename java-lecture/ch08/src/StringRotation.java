import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StringRotation {
	public static void main(String[] args) {
		// JFrame 객체 생성 - 윈도우 창
        JFrame frame = new JFrame("Text Rotation Example");
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());
		
		// JLabel 생성 및 설정
        JLabel label = new JLabel("yerin beck - REST ");
        label.setHorizontalAlignment(SwingConstants.CENTER); // 레이블 가운데 정렬
        frame.add(label, BorderLayout.CENTER); // 레이블을 프레임 중앙에 배치

        // JLabel 이벤트 : 키보드 리스너 추가
        label.addKeyListener(new KeyListener() {

			// Java에서 인터페이스를 구현할 때, 모든 메서드를 오버라이딩하도록 **강제**하는 구조입니다. 이는 인터페이스의 메서드를 모두 정의하고 구현하는 것을 잊지 않도록 도와주는 역할을 합니다. 따라서 이러한 이유로 인해 모든 메서드를 구현해야 합니다.
            @Override
            public void keyTyped(KeyEvent e) {
				// 키가 타이핑되었을 때의 동작 (사용하지 않음)
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode(); // 눌린 키의 코드
                String text = label.getText(); // 현재 레이블 텍스트 가져오기


                // 텍스트 로테이션
                if (keyCode == KeyEvent.VK_RIGHT) { // 오른쪽 화살표 키를 눌렀을 때, 텍스트 회전
                    text = text.charAt(text.length() - 1) + text.substring(0, text.length() - 1);
                } else if (keyCode == KeyEvent.VK_LEFT) { // 왼쪽 화살표 키를 눌렀을 때, 텍스트 회전
                    text = text.substring(1) + text.charAt(0);
                }
                
                label.setText(text); // 회전된 텍스트를 레이블에 설정
            }


            @Override
            public void keyReleased(KeyEvent e) {
				// 키를 눌렀다 뗄 때의 동작 (사용하지 않음)
            }
        });

        // JLabel 포커스 설정
        label.setFocusable(true); // 레이블이 포커스를 받을 수 있도록 설정
        label.requestFocus(); // 레이블에 포커스 설정

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼을 클릭했을 때 프로그램 종료
        frame.setVisible(true); // 프레임을 보이도록 설정
    }
	
}
