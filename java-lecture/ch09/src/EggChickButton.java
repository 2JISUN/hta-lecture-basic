import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EggChickButton extends JFrame {
	private ImageIcon eggIcon; // 달걀 이미지
    private ImageIcon chickIcon; // 병아리 이미지
    private JCheckBox toggleCheckbox; // 이미지 토글 체크박스

    public EggChickButton() {
        // 이미지 아이콘 생성
        eggIcon = new ImageIcon("C:\\Users\\user\\Desktop\\2JISUN\\java-lecture\\ch09\\images\\egg.png");
        chickIcon = new ImageIcon("C:\\Users\\user\\Desktop\\2JISUN\\java-lecture\\ch09\\images\\chick.png");

        // 프레임 설정
        setTitle("Image Toggle Checkbox Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 이미지 토글 체크박스 초기화
        toggleCheckbox = new JCheckBox("", eggIcon); // 초기 이미지로 설정
        toggleCheckbox.setSelectedIcon(chickIcon); // 선택 시 이미지 설정
        toggleCheckbox.setHorizontalAlignment(JCheckBox.CENTER); // 이미지 중앙 정렬
        toggleCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleImage();
            }
        });
        add(toggleCheckbox, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // 화면 중앙에 위치
        setSize(800, 600);
        setVisible(true);
    }

    // 이미지 토글 메서드
    private void toggleImage() {
        if (toggleCheckbox.isSelected()) {
            System.out.println("병아리");
        } else {
            System.out.println("계란");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EggChickButton();
            }
        });
    }
}
