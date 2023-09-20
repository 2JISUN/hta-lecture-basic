import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MultiLayout {
    public static void main(String[] args) {
		// JFrame 객체 생성 - 윈도우 창
        JFrame frame = new JFrame("Panel Layout Example");
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout()); // 프레임 레이아웃을 BorderLayout으로 설정

        // 첫 번째 패널
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER)); // 패널 레이아웃을 FlowLayout으로 설정

		// 첫 번째 패널 > 버튼
        JButton openButton = new JButton("열림");
        JButton closeButton = new JButton("닫기");
        JButton exitButton = new JButton("나가기");

        panel1.add(openButton);
        panel1.add(closeButton);
        panel1.add(exitButton);


        // 두 번째 패널
        JPanel panel2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);

                Random random = new Random();
                for (int i = 0; i < 9; i++) {
                    int x = random.nextInt(getWidth() - 10); // 랜덤한 x 좌표
                    int y = random.nextInt(getHeight() - 10); // 랜덤한 y 좌표
                    g.drawString("*", x, y);
                }
            }
        };
        panel2.setBackground(Color.WHITE);

        // 세 번째 패널
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(255, 255, 150));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER)); // 패널 레이아웃을 FlowLayout으로 설정

        JTextField textField = new JTextField(15);
        JButton searchButton = new JButton("검색");

        panel3.add(textField);
        panel3.add(searchButton);

        // 프레임에 패널 추가
        frame.add(panel1, BorderLayout.NORTH); // 첫 번째 패널을 프레임의 위쪽에 배치
        frame.add(panel2, BorderLayout.CENTER); // 두 번째 패널을 프레임의 중앙에 배치
        frame.add(panel3, BorderLayout.SOUTH); // 세 번째 패널을 프레임의 아래쪽에 배치


		// 이벤트 추가
		// "나가기" 버튼에 ActionListener 추가
		// ButtonEvent 클래스의 인스턴스 생성
        ButtonEvent buttonEvent = new ButtonEvent(frame);
		// "나가기" 버튼에 ActionListener로 ButtonEvent 객체를 추가
        exitButton.addActionListener(buttonEvent);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼을 클릭했을 때 프로그램 종료
        frame.setVisible(true); // 프레임을 보이도록 설정
    }
}