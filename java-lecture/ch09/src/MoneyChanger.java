import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyChanger {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Money Changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout()); // BorderLayout 설정

        // 입력창과 버튼을 한 행에 나란히 정렬하는 패널
        JPanel inputButtonPanel = new JPanel(new FlowLayout()); // FlowLayout으로 아이템을 나란히 정렬
        inputButtonPanel.setBackground(Color.LIGHT_GRAY); // 배경색을 하늘색으로 설정

        JLabel amountLabel = new JLabel("금액");
        JTextField amountField = new JTextField(10); // 입력창 크기 설정
        JButton calculateButton = new JButton("계산");
        inputButtonPanel.add(amountLabel);
        inputButtonPanel.add(amountField);
        inputButtonPanel.add(calculateButton);

        // 결과 출력 패널 (중앙 정렬)
        JPanel resultPanel = new JPanel(new GridLayout(9, 3));
        resultPanel.setBackground(Color.ORANGE);

        // 단위 레이블 배열, 결과 출력 텍스트 필드 배열, 체크박스 배열
        String[] unitLabels = {
            "50,000원", "10,000원", "5,000원", "1,000원",
            "500원", "100원", "50원", "10원", "1원"
        };

        JTextField[] resultFields = new JTextField[unitLabels.length];
        JCheckBox[] skipCheckboxes = new JCheckBox[unitLabels.length];
        
        for (int i = 0; i < unitLabels.length; i++) {
            JLabel unitLabel = new JLabel(unitLabels[i]);
            JTextField resultField = new JTextField("0");
            JCheckBox skipCheckbox = new JCheckBox("Skip");
            
            unitLabel.setHorizontalAlignment(JLabel.RIGHT);
            resultField.setHorizontalAlignment(JTextField.LEFT);
            resultField.setBackground(Color.WHITE);
            resultField.setEditable(false);
            resultFields[i] = resultField;
            skipCheckboxes[i] = skipCheckbox;
            
            resultPanel.add(unitLabel);
            resultPanel.add(resultField);
            resultPanel.add(skipCheckbox);
        }

        // 계산 버튼에 ActionListener 추가
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());

                int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

                for (int i = 0; i < units.length; i++) {
                    if (skipCheckboxes[i].isSelected()) {
                        resultFields[i].setText("0");
                        continue;
                    }
                    
                    int count = amount / units[i];
                    resultFields[i].setText(Integer.toString(count));
                    amount %= units[i];
                }
            }
        });

        // 패널들을 프레임에 추가
        frame.add(inputButtonPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);

        // 프레임 보이기
        frame.setVisible(true);
    }
}
