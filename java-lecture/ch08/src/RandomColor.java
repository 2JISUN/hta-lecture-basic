import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomColor {
	public static void main(String[] args) {
		// 1. 컴포넌트 객체 생성 (UI) - JFrame(윈도우), JButton(버튼), JLabel(레이블) 등
        JFrame frame = new JFrame("Random Label Example");
        frame.setSize(300, 300);
        frame.setLayout(null); // 레이아웃 매니저를 null로 설정하여 컴포넌트 위치를 수동으로 조절
        
        Random random = new Random();
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Label " + (i + 1));
            label.setOpaque(true);
            
            // 레이블의 크기를 랜덤하게 설정
            int width = random.nextInt(100) + 50; // 50~149
            int height = random.nextInt(100) + 50; // 50~149
            label.setSize(width, height);
            
            // 레이블의 위치를 랜덤하게 설정
            int x = random.nextInt(200); // 0~199
            int y = random.nextInt(200); // 0~199
            label.setLocation(x, y);
            
            // 랜덤한 색상 선택하여 배경색 지정
            Color randomColor = colors[random.nextInt(colors.length)];
            label.setBackground(randomColor);
            
            frame.add(label);
        }

		// 5. UI 표시 및 종료
		// 모든 설정이 완료되면 화면에 표시하기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
	
}
