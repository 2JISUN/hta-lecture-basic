import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.*;

// JPanel을 상속받아 Runnable 인터페이스를 구현한 클래스
class RandomThread extends JPanel implements Runnable {
    private boolean end = false; // 종료 여부를 나타내는 변수

    // 종료 여부를 "반환"하는 메서드
    public boolean isEnd() {
        return end;
    }

    // 종료 여부를 "설정"하는 메서드
    public void setEnd(boolean end) {
        this.end = end;
    }

    // 생성자에서 레이아웃 설정
    RandomThread() {
        this.setLayout(null); // null 레이아웃으로 설정
    }

    // 스레드 실행 내용을 구현한 메서드
    @Override
    public void run() {
        while (true) {
            JLabel label = new JLabel("thread"); // "thread" 문자열을 가진 레이블 생성
            label.setSize(120, 30); // 레이블 크기 설정
			label.setForeground(Color.GREEN); 
            int posX = (int) (Math.random() * getWidth()); // 랜덤한 x 좌표 계산
            int posY = (int) (Math.random() * getHeight()); // 랜덤한 y 좌표 계산
            label.setLocation(posX, posY); // 레이블 위치 설정
            add(label); // 레이블을 패널에 추가
            repaint(); // 패널 다시 그리기 요청
            try {
                Thread.sleep(100); // 0.1초 일시 정지
                if (end) { // 종료 조건을 만족하면
                    removeAll(); // 모든 컴포넌트 제거
                    label = new JLabel("finish"); // "end" 문자열을 가진 레이블 생성
                    label.setForeground(Color.RED); // 레이블 전경색 설정
                    label.setSize(120, 30); // 레이블 크기 설정
                    label.setLocation(130, 130); // 레이블 위치 설정
                    add(label); // 레이블을 패널에 추가
                    repaint(); // 패널 다시 그리기 요청
                    return; // 메서드 종료
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


// 메인 클래스
public class RandomTxt extends JFrame {
    Thread thread;

    RandomTxt() {
        this.setTitle("Thread"); // 프레임 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
        RandomThread randomThread = new RandomThread(); // 랜덤 스레드 생성
		thread = new Thread(randomThread); // 랜덤 스레드를 이용해 스레드 생성
		
        randomThread.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                randomThread.setEnd(true); // 클릭 시 종료 조건 설정
            }
        });
        this.setContentPane(randomThread); // 프레임 컨텐츠 패널을 랜덤 스레드로 설정
        thread.start(); // 스레드 실행 시작
        this.setSize(300, 300); // 프레임 크기 설정
        this.setVisible(true); // 프레임을 보이게 설정
    }

    public static void main(String[] args) {
        new RandomTxt(); // RandomTxt 객체 생성
    }
}
