import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ClockTxtLabel extends JLabel implements Runnable {
    @Override
    public void run() {
        while (true) {
            updateTime();
            try {
                Thread.sleep(1000); // 1초마다 업데이트
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateTime() {
        Calendar calendar = Calendar.getInstance(); // 현재 시간 정보를 가져옴
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(calendar.getTime());
        setText(currentTime); // 라벨의 텍스트 업데이트
    }
}

public class DigitalClock extends JFrame {
    DigitalClock() {
        this.setTitle("디지털 시계"); // 프레임 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정


		// 라벨 생성
        ClockTxtLabel clockLabel = new ClockTxtLabel(); // 디지털 시계 라벨 생성
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // 폰트 설정
        clockLabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        this.add(clockLabel); // 라벨 추가

		// 라벨 실행
        Thread clockThread = new Thread(clockLabel); // 라벨을 실행하는 스레드 생성
        clockThread.start(); // 스레드 시작


        this.setSize(300, 100); // 프레임 크기 설정
        this.setVisible(true); // 프레임을 보이게 설정
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DigitalClock(); // 디지털 시계 애플리케이션 실행
        });
    }
}
