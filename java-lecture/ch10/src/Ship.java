import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ship extends JPanel implements KeyListener, ActionListener, Runnable {
    private Image ship = new ImageIcon("images/spaceship.png").getImage();
    private Image bullet = new ImageIcon("images/bullet.png").getImage();
    private int shipX = 400; // 우주선의 X 좌표
    private int shipY = 400; // 우주선의 Y 좌표
    private int bulletX;
    private int bulletY;
    private boolean shooting = false; // 총알 발사 여부
    private Timer timer;

    Ship() {
        this.setPreferredSize(new Dimension(800, 600));
        this.addKeyListener(this);
        this.setFocusable(true); // 키 이벤트를 받을 수 있도록 포커스 설정
        this.requestFocusInWindow(); // 포커스를 패널로 이동

        // 타이머 생성 및 시작
        timer = new Timer(10, this);
        timer.start();
        
        Thread th = new Thread(this);
        th.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ship, shipX, shipY, null);

        if (shooting) {
            g.drawImage(bullet, bulletX, bulletY, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (shooting) {
            bulletY -= 5; // 총알을 위로 이동
            if (bulletY < 0) {
                shooting = false; // 화면 위로 나가면 총알 발사 종료
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            shipX = Math.max(shipX - 10, 0); // 좌측 이동, 최소값 0으로 제한
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            shipX = Math.min(shipX + 10, getWidth() - ship.getWidth(null)); // 우측 이동, 최대값 화면 너비로 제한
        } else if (keyCode == KeyEvent.VK_UP) {
            shipY = Math.max(shipY - 10, 0); // 상단 이동, 최소값 0으로 제한
        } else if (keyCode == KeyEvent.VK_DOWN) {
            shipY = Math.min(shipY + 10, getHeight() - ship.getHeight(null)); // 하단 이동, 최대값 화면 높이로 제한
        } else if (keyCode == KeyEvent.VK_SPACE) {
            if (!shooting) {
                // 총알 초기화 및 발사 위치 설정
                bulletX = shipX + ship.getWidth(null) / 2 - bullet.getWidth(null) / 2;
                bulletY = shipY;
                shooting = true;
            }
        }
        repaint(); // 우주선 위치가 변경되었으므로 다시 그리기
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Ship());
    }
}
