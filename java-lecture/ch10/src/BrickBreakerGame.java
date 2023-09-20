import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BrickBreakerGame extends JFrame {
	private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BALL_DIAMETER = 20;
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 10;
    private static final int BRICK_ROWS = 5;
    private static final int BRICK_COLUMNS = 10;
    private static final int BRICK_WIDTH = 50;
    private static final int BRICK_HEIGHT = 20;

    private int ballX = WIDTH / 2 - BALL_DIAMETER / 2;
    private int ballY = HEIGHT / 2 - BALL_DIAMETER / 2;
    private int ballXSpeed = 2; // 빠른 속도로 변경
    private int ballYSpeed = 2;

    private int paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;

    private boolean[][] bricks = new boolean[BRICK_ROWS][BRICK_COLUMNS];

    private boolean gameOver = false;

    BrickBreakerGame() {
        this.setTitle("Brick Breaker Game");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트 > 방향키
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
			// 방향키
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT && !gameOver) {
                    if (paddleX > 0) {
                        paddleX -= 10; // 빠른 움직임으로 변경
                    }
                }
                if (keyCode == KeyEvent.VK_RIGHT && !gameOver) {
                    if (paddleX < WIDTH - PADDLE_WIDTH) {
                        paddleX += 10; // 빠른 움직임으로 변경
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    ballX += ballXSpeed;
                    ballY += ballYSpeed; // 공의 Y축 이동

                    if (ballX <= 0 || ballX >= WIDTH - BALL_DIAMETER) {
                        ballXSpeed = -ballXSpeed;
                    }

                    if (ballY <= 0) {
                        ballYSpeed = -ballYSpeed;
                    }

                    if (ballY >= HEIGHT - BALL_DIAMETER) {
                        gameOver = true;
                    }

                    Rectangle ballRect = new Rectangle(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);
                    Rectangle paddleRect = new Rectangle(paddleX, HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);

                    if (ballRect.intersects(paddleRect)) {
                        ballYSpeed = -ballYSpeed;
                    }

                    for (int row = 0; row < BRICK_ROWS; row++) {
                        for (int col = 0; col < BRICK_COLUMNS; col++) {
                            if (bricks[row][col]) {
                                Rectangle brickRect = new Rectangle(col * (BRICK_WIDTH + 5), row * (BRICK_HEIGHT + 5),
                                        BRICK_WIDTH, BRICK_HEIGHT);
                                if (ballRect.intersects(brickRect)) {
                                    bricks[row][col] = false;
                                    ballYSpeed = -ballYSpeed;
                                }
                            }
                        }
                    }

                    // 게임 오버 체크
                    boolean allBricksBroken = true;
                    for (int row = 0; row < BRICK_ROWS; row++) {
                        for (int col = 0; col < BRICK_COLUMNS; col++) {
                            if (bricks[row][col]) {
                                allBricksBroken = false;
                                break;
                            }
                        }
                    }
                    if (allBricksBroken) {
                        gameOver = true;
                    }

                    repaint();
                }
            }
        });

        for (int row = 0; row < BRICK_ROWS; row++) {
            for (int col = 0; col < BRICK_COLUMNS; col++) {
                bricks[row][col] = true;
            }
        }

        timer.start();
        this.setVisible(true);
    }
	
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, BALL_DIAMETER, BALL_DIAMETER);

        g.setColor(Color.GREEN);
        g.fillRect(paddleX, HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);

        g.setColor(Color.YELLOW);
        for (int row = 0; row < BRICK_ROWS; row++) {
            for (int col = 0; col < BRICK_COLUMNS; col++) {
                if (bricks[row][col]) {
                    g.fillRect(col * (BRICK_WIDTH + 5), row * (BRICK_HEIGHT + 5), BRICK_WIDTH, BRICK_HEIGHT);
                }
            }
        }

        if (gameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", WIDTH / 2 - 80, HEIGHT / 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BrickBreakerGame());
    }
}
