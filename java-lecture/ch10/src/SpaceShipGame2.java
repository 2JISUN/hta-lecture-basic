import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// SpaceShipGame2 클래스는 게임 애플리케이션의 진입점을 정의합니다.
public class SpaceShipGame2 extends JFrame {
    private ShipPanel shipPanel;

    public SpaceShipGame2() {
        this.setTitle("Space Ship Game"); // 프레임의 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫을 때 프로그램 종료 설정
        shipPanel = new ShipPanel(); // ShipPanel 인스턴스 생성
        this.setContentPane(shipPanel); // 프레임의 콘텐트 팬을 ShipPanel로 설정
        this.pack(); // 프레임 크기를 콘텐트 팬에 맞게 조절
        this.setVisible(true); // 프레임 표시
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SpaceShipGame2());
    }
}

class ShipPanel extends JPanel implements KeyListener, ActionListener {

	// 이미지 불러오기
    private Image background = new ImageIcon("images/space.png").getImage(); // 배경화면 이미지
    private Image ship = new ImageIcon("images/spaceship.png").getImage(); // 우주선 이미지
    private Image bullet = new ImageIcon("images/bullet.png").getImage(); // 총알 이미지
    private Image bigFire = new ImageIcon("images/fire.png").getImage(); // 큰 불꽃 이미지
    private Image fire = bigFire.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // 크기 조절한 불꽃 이미지
	private Image boom = new ImageIcon("images/boom.png").getImage(); // 폭발 이미지


	// 게임 전체
	private Timer timer; // 게임 주기 업데이트를 위한 타이머 객체

	// 우주선
    private int shipX = 400; // 우주선의 초기 X 좌표
    private int shipY = 400; // 우주선의 초기 Y 좌표

	// 총알
    private boolean shooting = false; // 총알 발사 여부
    private ArrayList<Bullet> bullets = new ArrayList<>(); // 총알 객체들을 관리하는 리스트

	// 불꽃
    private Timer fireSpawnTimer; // 불꽃 생성 타이머
	private int fireSpawnTimerDelay = 500; // 불꽃 생성 타이머의 딜레이(ms)
    private List<Fire> fires = new ArrayList<>(); // 불꽃 객체들을 관리하는 리스트
    
    // 충돌
	private Timer collisionDelayTimer; // 충돌 후 딜레이를 위한 타이머
	private boolean hasCollision = false; // 충돌 여부를 나타내는 변수
	private boolean boomVisible = false; // boom 이미지 표시 여부를 나타내는 변수 (충돌여부)
    private int boomX; // boom 이미지의 X 좌표
    private int boomY; // boom 이미지의 Y 좌표

	// 움직임
    private boolean movingLeft = false; // 좌측 이동 여부
    private boolean movingRight = false; // 우측 이동 여부
    private boolean movingUp = false; // 상단 이동 여부
    private boolean movingDown = false; // 하단 이동 여부

    ShipPanel() {
        this.setPreferredSize(new Dimension(800, 600)); // 패널 크기 설정
        this.addKeyListener(this); // 키 이벤트를 수신할 수 있도록 리스너 등록
        this.setFocusable(true); // 키 이벤트를 위한 포커스 설정
        this.requestFocusInWindow(); // 포커스 요청

        timer = new Timer(10, this); // 10ms마다 actionPerformed 메서드 호출하는 타이머 생성
        timer.start(); // 타이머 시작
		
        // 충돌 후 딜레이 타이머 설정
        collisionDelayTimer = new Timer(500, e -> collisionDelayTimer.stop());

		// 불꽃 생성 타이머 설정
        fireSpawnTimer = new Timer(fireSpawnTimerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomX = (int) (Math.random() * getWidth());
                int randomY = 0;
                fires.add(new Fire(randomX, randomY));
            }
        });
        fireSpawnTimer.start();
    }

	// 그래픽 요소 그리기
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 슈퍼 클래스의 paintComponent 메서드 호출하여 배경을 지우고 그리기

        // 배경화면 그리기
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        
	    // 요소(우주선, 총알, 불꽃)을 그립니다.
		// 우주선 그리기
        g.drawImage(ship, shipX, shipY, null);

		// 총알 그리기
        for (Bullet bullet : bullets) {
            g.drawImage(this.bullet, bullet.getX(), bullet.getY(), null);
        }

		// 불꽃 그리기
        for (Fire fire : fires) {
            g.drawImage(this.fire, fire.getX(), fire.getY(), null);
        }

        // 충돌이 감지되었을 때만 boom 이미지 그리기
        if (boomVisible) {
            g.drawImage(boom, boomX, boomY, null);
        }
    }


	// 게임 주기마다 호출되는 메서드
    @Override
    public void actionPerformed(ActionEvent e) {
		// 우주선 이동 업데이트
        if (movingLeft) {
            shipX = Math.max(shipX - 5, 0);
        }
        if (movingRight) {
            shipX = Math.min(shipX + 5, getWidth() - ship.getWidth(null));
        }
        if (movingUp) { // 위로 이동 처리
            shipY = Math.max(shipY - 5, 0);
        }
        if (movingDown) { // 아래로 이동 처리
            shipY = Math.min(shipY + 5, getHeight() - ship.getHeight(null));
        }

		// 총알 발사 시 처리
        if (shooting) {
            bullets.add(new Bullet(shipX + ship.getWidth(null) / 2 - bullet.getWidth(null) / 2, shipY));
            shooting = false;
        }


		// 총알 이동 및 화면 벗어난 총알 제거
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            bullet.move();
            if (bullet.getY() < 0) {
                bullets.remove(i);
            }
        }

		// 불꽃 생성 및 이동
		int maxFires = 10; // 불꽃의 최대 개수 설정
		if (fires.size() < maxFires) {
			int randomX = (int) (Math.random() * getWidth());
			int randomY = 0;
			fires.add(new Fire(randomX, randomY));
		}


        // 충돌 처리
        for (int i = fires.size() - 1; i >= 0; i--) {
            Fire fire = fires.get(i);
            fire.move(); // 불꽃 이동 처리

            if (fire.intersects(shipX, shipY, ship.getWidth(null), ship.getHeight(null))) {
                fires.remove(i);
                collisionDelayTimer.start(); // 충돌 딜레이 타이머 시작
                hasCollision = true; // 충돌이 감지됨

                // boom 이미지 위치 설정
                boomX = fire.getX() - boom.getWidth(null) / 2;
                boomY = fire.getY() - boom.getHeight(null) / 2;
                boomVisible = true; // boom 이미지 표시

                // 1초 후에 충돌 플래그와 boom 이미지 플래그 초기화
                Timer resetCollisionTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hasCollision = false;
                        boomVisible = false;
                        repaint(); // 화면 다시 그리기
                    }
                });
                resetCollisionTimer.setRepeats(false); // 타이머를 한 번만 실행하도록 설정
                resetCollisionTimer.start();
            }

            // 총알과 불꽃이 충돌했을 때 처리
            for (int j = bullets.size() - 1; j >= 0; j--) {
                Bullet bullet = bullets.get(j);
                if (bullet.intersects(fire.getX(), fire.getY(), fire.getImageWidth(), fire.getImageHeight())) {
                    bullets.remove(j);
                    fires.remove(i);
                    hasCollision = false; // 충돌이 해결되었으므로 false로 설정
                    break; // 한 번에 하나의 총알만 처리
                }
            }
        }

        repaint(); // 화면 다시 그리기
    }



	// 키보드의 키가 눌렸을 때 호출되는 메서드
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            movingLeft = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            movingRight = true;
        } else if (keyCode == KeyEvent.VK_UP) {
            movingUp = true; // 위로 이동 추가
        } else if (keyCode == KeyEvent.VK_DOWN) {
            movingDown = true; // 아래로 이동 추가
        } else if (keyCode == KeyEvent.VK_SPACE) {
            shooting = true;
        }
    }
	// 키보드의 키가 타이핑될 때 호출되는 메서드 (사용하지 않음)
    @Override
    public void keyTyped(KeyEvent e) {
    }

	// 키보드의 키가 떼졌을 때 호출되는 메서드
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            movingLeft = false;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            movingRight = false;
        } else if (keyCode == KeyEvent.VK_UP) {
            movingUp = false; // 위로 이동 추가
        } else if (keyCode == KeyEvent.VK_DOWN) {
            movingDown = false; // 아래로 이동 추가
        }
    }

	// 총알 클래스 정의
    private class Bullet {
        private int x;
        private int y;

        Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        void move() {
            y -= 5;  // 총알을 위로 이동
        }
		
		boolean intersects(int x, int y, int width, int height) {
			Rectangle bulletBounds = new Rectangle(this.x, this.y, bullet.getWidth(null), bullet.getHeight(null));
			Rectangle otherBounds = new Rectangle(x, y, width, height);
			return bulletBounds.intersects(otherBounds);
    	}
    }

	// 불꽃 클래스 정의
    private class Fire {
        private int x;
        private int y;
        private int speed;
        private Image fireImage;

        Fire(int x, int y) {
            this.x = x;
            this.y = y;
            this.speed = (int) (Math.random() * 3) + 1; // 불꽃 속도 조정
            this.fireImage = fire;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        void move() {
            y += speed; // 불꽃을 아래로 이동
        }

        int getImageWidth() {
            return fireImage.getWidth(null);
        }

        int getImageHeight() {
            return fireImage.getHeight(null);
        }

        boolean intersects(int x, int y, int width, int height) {
			Rectangle fireBounds = new Rectangle(this.x, this.y, getImageWidth(), getImageHeight());
			Rectangle otherBounds = new Rectangle(x, y, width, height);
			return fireBounds.intersects(otherBounds);
		}
	}
}