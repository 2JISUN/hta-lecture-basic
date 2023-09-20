import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTimerTest extends JFrame {

    private JButton startButton;
    private JLabel timerLabel;
    private int seconds = 0;
    private boolean running = false;

    public SimpleTimerTest() {
        this.setTitle("Simple Timer Test");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        timerLabel = new JLabel("Time: 0 seconds");
        mainPanel.add(timerLabel, BorderLayout.CENTER);

        startButton = new JButton("Start / Stop");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    running = false;
                } else {
                    running = true;
                    startTimer();
                }
            }
        });
        mainPanel.add(startButton, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private void startTimer() {
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000); // 1초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds++;
                    updateLabel();
                }
            }
        });
        timerThread.start();
    }

    private void updateLabel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                timerLabel.setText("Time: " + seconds + " seconds");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleTimerTest();
            }
        });
    }
}
