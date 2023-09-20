import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Circle extends JFrame {

    private JPanel drawingPanel;

	// 생성자
    Circle() {
        this.setTitle("랜덤 circle"); // 프레임 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정

		// 원 생성
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRandomCircle(g);
            }
        };
        this.add(drawingPanel); // 패널 추가


        // 원 출력 스레드 실행
        Thread circleThread = new Thread(() -> {
            while (true) {
                drawingPanel.repaint(); // 패널을 다시 그림
                try {
                    Thread.sleep(500); // 0.5초마다
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        circleThread.start(); // 스레드 시작


		this.setSize(400, 400); // 프레임 크기 설정
        this.setVisible(true); // 프레임을 보이게 설정
    }

	// 원 그리기
    private void drawRandomCircle(Graphics g) {
        Random random = new Random();
        int x = random.nextInt(getWidth() - 50); // 프레임 가로 범위 내에서 랜덤한 x 위치
        int y = random.nextInt(getHeight() - 50); // 프레임 세로 범위 내에서 랜덤한 y 위치
        int diameter = 50; // 원의 지름

        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }

	// 메인 메소드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Circle();
        });
    }
}
