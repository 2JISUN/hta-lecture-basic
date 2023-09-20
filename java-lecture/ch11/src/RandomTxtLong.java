import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class RandomTxtLong extends JFrame {

    private JLabel finishLabel;
    private boolean running = true;

    public RandomTxtLong() {
        this.setTitle("Continuous Thread Example");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        finishLabel = new JLabel("finish");
        finishLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        finishLabel.setForeground(Color.RED);
        finishLabel.setVisible(false);
        this.add(finishLabel);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (running) {
                    JLabel threadLabel = new JLabel("thread");
                    threadLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
                    threadLabel.setForeground(Color.GREEN);

                    int x = random.nextInt(250);
                    int y = random.nextInt(250);
                    threadLabel.setBounds(x, y, 50, 20);

                    // "thread" 레이블 추가
                    add(threadLabel);
                    repaint();

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 스레드 종료 후 "thread" 레이블 삭제
                removeThreadLabels();
            }
        });
        thread.start();

        // 클릭 시 스레드 중지 및 "finish" 레이블 표시
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                running = false;
                finishLabel.setVisible(true);
            }
        });

        this.setVisible(true);
    }

    // "thread" 레이블 삭제
    private void removeThreadLabels() {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JLabel && ((JLabel) component).getText().equals("thread")) {
                remove(component);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RandomTxtLong();
            }
        });
    }
}
