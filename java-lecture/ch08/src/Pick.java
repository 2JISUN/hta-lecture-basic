import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

import java.util.Random;

public class Pick {
	public static void main(String[] args) {
		// JFrame 객체 생성 - 윈도우 창
        JFrame frame = new JFrame("Random Label Game");
		
        frame.setSize(800, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
		panel.setBackground(Color.PINK); // 행 전체 색상이 변경됨
		panel.setSize(50, 50);
        panel.setLayout(new GridLayout(1, 1,10,10)); // 1x1 그리드 레이아웃 설정

        Random random = new Random();

        // 6개의 레이블 생성
        JLabel[] labels = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            labels[i] = new JLabel(Integer.toString(i + 1));
            labels[i].setForeground(Color.BLACK); // 숫자 색상 설정
            labels[i].setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬

			// 글자 크기 조정
            Font labelFont = labels[i].getFont();
            labels[i].setFont(labelFont.deriveFont(Font.BOLD, 24)); // 글꼴 크기 24

			labels[i].setBorder(new LineBorder(Color.CYAN, 5)); // 진한 핑크색 테두리 설정
            panel.add(labels[i]);
        }

        JLabel resultLabel = new JLabel("엔터를 입력하세요"); // 결과를 보여줄 레이블 생성
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬


        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        // 키보드 리스너 추가
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int[] values = new int[6];
                    boolean allSame = true;

                    // 레이블 값 랜덤으로 변경
                    for (int i = 0; i < 6; i++) {
                        values[i] = random.nextInt(6) + 1;
                        labels[i].setText(Integer.toString(values[i]));
                        if (values[i] != values[0]) {
                            allSame = false;
                        }
                    }

                    // 결과 레이블에 출력
                    if (allSame) {
                        resultLabel.setText("축하합니다");
                    } else {
                        resultLabel.setText("다시 도전해보세요");
                    }
                }
            }
        });

        panel.setFocusable(true); // 패널에 포커스 설정
        panel.requestFocus(); // 패널에 포커스 설정

        frame.setVisible(true);
    }
	
}
