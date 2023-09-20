import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 클래스 전체
public class TimerTest extends JFrame {

    private JButton startButton, stopButton; // 시작 버튼과 중지 버튼
    private JLabel timerLabel; // 타이머 레이블
    private Timer timer; // 스윙 타이머
    private int seconds = 0; // 경과 시간(초)

    public TimerTest() {
        // UI틀 만들기 = 컨테이너 및 요소
        this.setTitle("Timer Test");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(); // 레이블 컨테이너
        mainPanel.setLayout(new BorderLayout()); // 레이블 정렬 
        timerLabel = new JLabel("Time: 0 seconds"); //타이머 레이블

        JPanel buttonPanel = new JPanel(); // 버튼 컨테이너
        startButton = new JButton("Start"); //시작 버튼
        stopButton = new JButton("Stop"); //멈춤 버튼


        // 요소에 이벤트 연결
        startButton.addActionListener(new ActionListener() { // Start 버튼 클릭 시 스레드 시작
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        stopButton.addActionListener(new ActionListener() { // Stop 버튼 클릭 시 스레드 중지
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        // 컨테이너에 요소를 추가
        mainPanel.add(timerLabel, BorderLayout.CENTER);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel);

        // UI띄우기
        this.setVisible(true);
    }

    // 메소드 > 시작
    private void startTimer() {
        // 1초마다 actionPerformed 메서드 호출하여 타이머 갱신
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++; // 경과 시간 증가
                timerLabel.setText("Time: " + seconds + " mseconds"); // 레이블 업데이트
            }
        });
        timer.start(); // 타이머 시작
    }

    // 메소드 > 멈춤(초기화)
    private void stopTimer() {
        if (timer != null && timer.isRunning()) { // 타이머가 실행 중일 때만 중지
            timer.stop(); // 타이머 중지
            seconds = 0; // 경과 시간 초기화
            timerLabel.setText("Time: 0 seconds"); // 레이블 초기화
        }
    }

    // 메인 메소드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerTest(); // 애플리케이션 실행
            }
        });
    }
}
