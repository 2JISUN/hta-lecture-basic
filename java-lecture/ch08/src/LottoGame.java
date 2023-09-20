import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Arrays; // Arrays 클래스를 import

public class LottoGame {
    public static void main(String[] args) {
		// JFrame 객체 생성 - 윈도우 창
        JFrame frame = new JFrame("Lotto Game");
        frame.setSize(800, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LottoPanel panel = new LottoPanel(); // 로또 번호를 표시하는 패널 생성

        JLabel resultLabel = new JLabel("Enter 키를 눌러 로또 번호 생성");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(panel, BorderLayout.CENTER); // 패널을 중앙에 배치
        frame.add(resultLabel, BorderLayout.SOUTH); // 결과 레이블을 아래쪽에 배치

        frame.setVisible(true); // 프레임을 보이도록 설정
    }
}

class LottoPanel extends JPanel {
    private final JLabel[] labels; // 로또 번호를 표시할 레이블 배열
    private final Random random; // 랜덤 숫자 생성을 위한 랜덤 객체

    public LottoPanel() {
        setBackground(Color.PINK); // 배경색 설정
        setSize(50, 50);
        setLayout(new GridLayout(1, 6, 10, 10)); // 1x6 그리드 레이아웃 설정

        random = new Random(); // 랜덤 객체 생성

        labels = new JLabel[6]; // 6개의 로또 번호를 표시할 레이블 배열 생성
        for (int i = 0; i < 6; i++) {
            labels[i] = new JLabel(); // 레이블 생성
            labels[i].setForeground(Color.BLACK); // 숫자 색상 설정
            labels[i].setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬

            Font labelFont = labels[i].getFont(); // 기존 레이블의 폰트 정보 가져오기
            labels[i].setFont(labelFont.deriveFont(Font.BOLD, 24)); // 글꼴 크기 24, 볼드 스타일

            labels[i].setBorder(new LineBorder(Color.CYAN, 5)); // 테두리 설정
            add(labels[i]); // 레이블을 패널에 추가
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int[] lottoNumbers = generateLottoNumbers(); // 랜덤한 로또 번호 생성
					Arrays.sort(lottoNumbers); // 생성한 번호를 오름차순으로 정렬
                    updateLabels(lottoNumbers); // 레이블에 번호 업데이트
                }
            }
        });

        setFocusable(true); // 패널에 포커스 설정
        requestFocus(); // 패널에 포커스 요청
    }

    private int[] generateLottoNumbers() {
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            lottoNumbers[i] = random.nextInt(45) + 1; // 1부터 45까지의 랜덤 숫자 생성
        }
        return lottoNumbers;
    }

    private void updateLabels(int[] numbers) {
        for (int i = 0; i < 6; i++) {
            labels[i].setText(Integer.toString(numbers[i])); // 레이블에 숫자 설정
        }
    }
}
