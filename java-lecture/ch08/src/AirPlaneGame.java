import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AirPlaneGame {
    public static void main(String[] args) {
		// JFrame 객체 생성 - 윈도우 창
        JFrame frame = new JFrame("Airplane Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 비행기 객체 생성
        AirplanePanel airplanePanel = new AirplanePanel();
        frame.add(airplanePanel);

		// 비행기 : 키보드 리스너 추가
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                airplanePanel.moveAirplane(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
		// 프레임을 보이도록 설정 
        frame.setVisible(true);
    }
}

class AirplanePanel extends JPanel {
    private ImageIcon airplaneIcon;
    private int airplaneX, airplaneY;

    public AirplanePanel() {
        airplaneIcon = new ImageIcon("C:\\Users\\user\\Desktop\\2JISUN\\java-lecture\\ch08\\images\\airplane.png");
		// 비행기 초기 위치를 화면 가운데에 설정
        airplaneX = getWidth() / 2 - airplaneIcon.getIconWidth() / 2;
        airplaneY = getHeight() / 2 - airplaneIcon.getIconHeight() / 2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        airplaneIcon.paintIcon(this, g, airplaneX, airplaneY);
    }

    public void moveAirplane(int keyCode) {
        int speed = 5; // 비행기 이동 속도

        if (keyCode == KeyEvent.VK_UP) {
            airplaneY -= speed;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            airplaneY += speed;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            airplaneX -= speed;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            airplaneX += speed;
        }

        repaint(); // 화면 갱신
    }
}