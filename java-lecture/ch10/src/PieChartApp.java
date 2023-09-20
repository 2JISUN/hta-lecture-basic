import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PieChartApp extends JFrame {

    private JTextField[] inputFields; // 상단 > 입력창
    private JPanel chartPanel; // 하단 > 차트
    private boolean valuesEntered = false; // 입력 값이 있는지 여부
	String[] labels = {"Apple:", "Banana:", "Plum:", "Peach:"}; //레이블 저장소(멤버변수로 변경)

    public PieChartApp() {
        this.setTitle("Pie Chart");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 상단 화면 구성
		JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setPreferredSize(new Dimension(800, 50));
		

        // 레이블과 입력창을 배열로 만들어 반복문으로 처리
        inputFields = new JTextField[labels.length]; //입력창 저장소
        for (int i = 0; i < labels.length; i++) {
            topPanel.add(new JLabel(labels[i]));
            inputFields[i] = new JTextField(5);
            topPanel.add(inputFields[i]);
        }



        // 하단 화면 구성
        chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (valuesEntered) {
                    drawPieChart(g);
                }
            }
        };
        chartPanel.setBackground(Color.WHITE);

        // 상단 화면의 입력창이 모두 입력된 후에 파이차트 생성
        for (JTextField field : inputFields) {
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    valuesEntered = true;
                    chartPanel.repaint();
                }
            });
        }


        // 전체 프레임에 상단과 하단 패널 추가
        this.add(topPanel, BorderLayout.NORTH);
        this.add(chartPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

	// 메소드 > 파이차트 계산기
    private void drawPieChart(Graphics g) {
		// 입력값 저장소
        int[] values = new int[inputFields.length];
        int totalValue = 0;
        for (int i = 0; i < inputFields.length; i++) {
            values[i] = getValueFromTextField(inputFields[i]);
            totalValue += values[i];
        }


        // 입력값이 100을 초과하는 경우 에러 메시지 표시
        if (totalValue > 100) {
            String errorMessage = "100%를 초과할 수 없습니다.";
            g.setColor(Color.RED);
            g.drawString(errorMessage, getWidth() / 2 - 50, getHeight() / 2);
            return;
        }

		// 입력값 -> 앵글값 변환 저장소
        int startAngle = 0;
        int[] angles = new int[values.length];
        Color[] colors = {Color.RED, Color.YELLOW, new Color(128, 0, 128), Color.PINK}; // 고정된 색상
        for (int i = 0; i < values.length; i++) {
            angles[i] = (int) ((values[i] / (double) totalValue) * 360);
            g.setColor(colors[i]);
    
            // 중심 위치 계산 (화면 가로/세로 길이의 중간으로 설정)
            double centerX = getWidth() / 2.0;
            double centerY = getHeight() / 2.0;


            // 파이차트 그리기 > double
            // g.fillArc(centerX - 150, centerY - 200, 300, 300, startAngle, angles[i]);
            double arcX = centerX - 150;
            double arcY = centerY - 200;
            double arcWidth = 300.0;
            double arcHeight = 300.0;
            double startAngleRadians = Math.toRadians(startAngle);
            double arcAngleRadians = Math.toRadians(angles[i]);
            g.fillArc((int) arcX, (int) arcY, (int) arcWidth, (int) arcHeight, (int) startAngle, angles[i]);


			// 레이블 값 표시
            int labelAngle = startAngle + angles[i] / 2;
            double labelAngleRadians = Math.toRadians(labelAngle);
            double labelRadius = 80.0;  // 조금 안으로 이동하여 파이 안에 위치하도록 변경
            int x = (int) (centerX + Math.cos(labelAngleRadians) * labelRadius);
            int y = (int) (centerY - Math.sin(labelAngleRadians) * labelRadius);
            String label = labels[i] + " " + ((values[i] * 100) / totalValue) + "%";
            g.setColor(Color.BLACK);
            g.drawString(label, x, y);
            startAngle += angles[i];
        }
    }


	// 메소드 > 입력창
	// 입력창이 문자열로 리턴되기 때문에 형변환처리를 해준다.
    private int getValueFromTextField(JTextField textField) {
        try {
            return Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }


	// 메인 메소드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PieChartApp();
            }
        });
    }
}
