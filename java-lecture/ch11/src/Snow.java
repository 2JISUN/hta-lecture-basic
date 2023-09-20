import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// 눈송이 클래스
class Snowflake {
    int x, y, size, speed;

    // 눈송이 위치값
    public Snowflake(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
    }

    // 눈송이 떨어지는 방식
    public void fall() {
        y += speed;

        // 눈송이가 화면 아래로 벗어나면 다시 위로 올리고 새로운 x 좌표를 설정
        if (y > SnowPanel.PANEL_HEIGHT) {
            y = -size;
            x = new Random().nextInt(SnowPanel.PANEL_WIDTH);
        }

        // 눈송이가 왼쪽이나 오른쪽으로 흔들리는 효과를 주기 위해 x 좌표를 약간 변경
        x += (new Random().nextInt(3) - 1); // -1, 0, 1 중 하나의 값을 더함
    }

    // 눈송이 시각화
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }
}

// 도화지
class SnowPanel extends JPanel implements Runnable {
    static final int PANEL_WIDTH = 800; 
    static final int PANEL_HEIGHT = 600;

	private Image bg = new ImageIcon("images/town.png").getImage(); // 배경 이미지 저장소
    private List<Snowflake> snowflakes = new ArrayList<>(); // 눈송이 저장소

    SnowPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        createSnowflakes(100); // 눈송이 생성
        Thread thread = new Thread(this);
        thread.start(); // 스레드 시작

    }

    // 눈송이 예쁘게 떨구기
    private void createSnowflakes(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(PANEL_WIDTH);
            int y = random.nextInt(PANEL_HEIGHT);
            int size = random.nextInt(5) + 5;
            int speed = size / 2 + random.nextInt(2);
            snowflakes.add(new Snowflake(x, y, size, speed));
        }
    }

    @Override
    public void run() {
        while (true) {
            for (Snowflake snowflake : snowflakes) {
                snowflake.fall();
            }
            repaint(); // 패널을 다시 그림
            try {
                Thread.sleep(50); // 0.05초마다 업데이트
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 그렸던 그림을 넣기
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

		// 배경 이미지 그리기
		g.drawImage(bg, 0, 0, null);

		// 눈송이 그리기
        for (Snowflake snowflake : snowflakes) {
            snowflake.draw(g);
        }
    }
}

public class Snow extends JFrame {
    public Snow() {
        setTitle("눈 내리는 마을");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new SnowPanel());
        pack();
        setLocationRelativeTo(null); // 화면 중앙에 배치
        setVisible(true);
    }

    // 메인 메소드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Snow();
        });
    }
}
