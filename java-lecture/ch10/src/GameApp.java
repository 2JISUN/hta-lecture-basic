import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

// GameApp 클래스는 프레임을 생성하고 초기화합니다.
public class GameApp extends JFrame{
	// GameApp 클래스는 프레임을 생성하고 초기화
	GameApp(){
		this.setTitle("SHOOTING GAME"); //프레임의 제목을 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임을 닫을 때 프로그램이 종료하도록 설정
		this.setContentPane(new Ship()); //프레임의 콘텐트 팬을 Ship 클래스의 인스턴스로 설정
		this.setVisible(true); //프레임을 보이도록 설정
		this.pack(); //프레임을 해당 컨텐츠 크기에 맞게 조절
	}
	// 메인 메소드
	public static void main(String[] args) {
		new GameApp();
	}
	
}

// Ship 클래스는 게임의 주요 로직을 담당하는 패널입니다.
class Ship extends JPanel implements KeyListener, ActionListener {
    private Image ship = new ImageIcon("images/spaceship.png").getImage(); //우주선
    private Image bullet = new ImageIcon("images/bullet.png").getImage(); //총알
    private Image bigFire = new ImageIcon("images/fire.png").getImage(); // 불꽃 
    private Image fire = bigFire.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // 불꽃 이미지를 줄여서 저장

    private int shipX = 400; // 우주선의 X 좌표 초기화
    private int shipY = 400; // 우주선의 Y 좌표 초기화

    private int bulletY; // 총알의 Y 좌표 초기화
    private boolean shooting = false; // 총알 발사 여부
	private ArrayList<Bullet> bullets = new ArrayList<>(); // 총알들을 관리하는 리스트
    private List<Fire> fires = new ArrayList<>(); // 불꽃 객체들을 관리하는 리스트

    private Timer timer; // 게임의 주기적인 업데이트를 위한 타이머 객체

    // 스무스한 움직임을 위해서 변수 설정
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean movingUp = false;
    private boolean movingDown = false;

    private boolean gameover = false; // 게임 오버 상태 변수 추가 및 초기화
    private int collisions = 0; // collisions 변수 선언 및 초기화


	// 생성자 Ship()
    Ship() {
        this.setPreferredSize(new Dimension(800, 600)); //패널의 크기를 설정
        this.addKeyListener(this); //키 이벤트를 수신할 수 있도록 이벤트 리스너를 등록
        this.setFocusable(true); // 키 이벤트를 통해 패널이 포커스를 받을 수 있도록 설정
        this.requestFocusInWindow(); // 포커스를 패널로 이동(패널에 포커스를 요청)

        // 타이머 생성 및 시작 > 스무스
        timer = new Timer(10, this); //10ms마다 actionPerformed 메KeyListener소드를 호출하는 타이머를 생성
        timer.start(); //타이머 시작
        
    }

	// 이미지 그리기
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 슈퍼 클래스의 paintComponent 메소드를 호출하여 배경을 지우고 이미지 그리기
        // 우주선 이미지 그리기
		g.drawImage(ship, shipX, shipY, null);

        // 총알 그리기 > 총알을 발사 여부에 따른 이미지 
        for (Bullet bullet : bullets) {
            g.drawImage(this.bullet, bullet.getX(), bullet.getY(), null);
        }

        // 불꽃 그리기
        for (Fire fire : fires) {
            g.drawImage(this.fire, fire.getX(), fire.getY(), null);
    }
    }

    // 메소드 > 부드러운 움직임
    @Override
    public void actionPerformed(ActionEvent e) {
        // 우주선 움직임 업데이트 > 스무스
        if (movingLeft) {
            shipX = Math.max(shipX - 5, 0);
        }
        if (movingRight) {
            shipX = Math.min(shipX + 5, getWidth() - ship.getWidth(null));
        }
        if (movingUp) {
            shipY = Math.max(shipY - 5, 0);
        }
        if (movingDown) {
            shipY = Math.min(shipY + 5, getHeight() - ship.getHeight(null));
        }

        // 총알 움직임 업데이트 
        if (shooting) {
            bulletY -= 5;
            if (bulletY < 0) {
                shooting = false;
            }
        }

        // 총알들을 이동시키고 화면을 벗어난 총알을 제거
        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            bullet.move(); // 총알 이동
            if (bullet.getY() < 0) {
                bullets.remove(i);
            }
        }

        // 불꽃 생성 및 추가
        if (!gameover) { // 게임 오버 상태가 아닐 때만 불꽃 생성
            int randomX = (int) (Math.random() * getWidth()); // 랜덤한 X 좌표
            int randomY = 0; // Y 좌표 초기화
            fires.add(new Fire(randomX, randomY)); // 불꽃 생성 및 추가
        }



        // 불꽃 움직임
        // 불꽃들을 이동시키고 화면을 벗어난 불꽃을 제거
        for (int i = fires.size() - 1; i >= 0; i--) {
            Fire fire = fires.get(i);
            fire.move(); // 불꽃 이동
            if (fire.getY() > getHeight()) {
                fires.remove(i);
            }
        }

        // 충돌 처리
        for (int i = fires.size() - 1; i >= 0; i--) {
            Fire fire = fires.get(i);
            if (fire.intersects(shipX, shipY, ship.getWidth(null), ship.getHeight(null))) {
                fires.remove(i);
                if (collisions >= 2) {
                    gameover = true; // 게임 오버 상태 설정
                    timer.stop(); // 게임 종료 시 타이머 정지
                } else {
                    collisions++;
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    collisions--;
                                }
                            }, 300); // 충돌 후 0.3초 지연

                    // 총알과 불꽃이 닿았을 때 서로 없애기
                    for (int j = bullets.size() - 1; j >= 0; j--) {
                        Bullet bullet = bullets.get(j);
                        if (bullet.intersects(fire.getX(), fire.getY(), fire.getImageWidth(), fire.getImageHeight())) {
                            bullets.remove(j);
                            break; // 한 번에 하나의 총알만 처리
                        }
                    }
                }
            }
        }

        repaint(); // 다시 그리기
    }

	//키보드의 키가 눌렸을 때 호출되는 메소드
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            movingLeft = true;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            movingRight = true;
        } else if (keyCode == KeyEvent.VK_UP) {
            movingUp = true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            movingDown = true;
        } else if (keyCode == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(shipX + ship.getWidth(null) / 2 - bullet.getWidth(null) / 2, shipY));
        }
    }


	//구현하지 않은 메소드로 내용이 없습니다.
    @Override
    public void keyTyped(KeyEvent e) {
    }

	// 키보드의 키가 눌렸을 때 호출되는 메소드
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            movingLeft = false;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            movingRight = false;
        } else if (keyCode == KeyEvent.VK_UP) {
            movingUp = false;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            movingDown = false;
        }
    }


	// 내부 클래스로 총알 클래스를 생성하여 위치와 이동 등을 관리
    private class Bullet {
        private int x;
        private int y;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void move() {
            y -= 5; // 총알을 위로 이동
        }

        public boolean intersects(int x, int y, int width, int height) {
            return new Rectangle(this.x, this.y, bullet.getWidth(null), bullet.getHeight(null)).intersects(x, y, width, height);
        }
    }

    // 내부 클래스로 불꽃 클래스를 생성하여 위치와 이동 등을 관리
        private class Fire {
        private int x;
        private int y;
        private int speed; // 불꽃의 속도
        private Image fireImage; // 불꽃 이미지

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
            this.speed = (int) (Math.random() * 5) + 1; // 불꽃의 속도를 랜덤하게 설정
            this.fireImage = fire; // 불꽃 이미지 초기화
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

        public void move() {
            y += speed; // 불꽃을 아래로 이동
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, getImageWidth(), getImageHeight());
        }

        public boolean intersects(int x, int y, int width, int height) {
            Rectangle fireBounds = new Rectangle(this.x, this.y, getImageWidth(), getImageHeight());
            Rectangle otherBounds = new Rectangle(x, y, width, height);
            return fireBounds.intersects(otherBounds);
        }

        public int getImageWidth() {
            return fireImage.getWidth(null);
        }

        public int getImageHeight() {
            return fireImage.getHeight(null);
        }
    }

}