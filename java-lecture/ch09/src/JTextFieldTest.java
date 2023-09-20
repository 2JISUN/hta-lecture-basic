import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldTest {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // 조금 더 높이 추가
        frame.setLayout(new BorderLayout()); // 전체 레이아웃을 BorderLayout으로 설정

        // 패널 생성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // 3행 2열의 그리드 레이아웃 설정

        // 아이디 입력창
        JLabel idLabel = new JLabel("아이디:");
        JTextField idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        // 비밀번호 입력창
        JLabel pwLabel = new JLabel("비밀번호:");
        JPasswordField pwField = new JPasswordField();
        panel.add(pwLabel);
        panel.add(pwField);

        // 로그인 버튼
        JButton loginButton = new JButton("로그인");
        panel.add(new JLabel()); // 빈 레이블 추가하여 로그인 버튼을 중앙에 정렬
        panel.add(loginButton);

        // 로그인 버튼에 ActionListener 추가
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId = idField.getText();
                String inputPw = new String(pwField.getPassword());

                // 입력된 아이디와 비밀번호를 확인하여 로그인 여부 판단
                if (inputId.equals("snm03097") && inputPw.equals("960109")) {
                    JOptionPane.showMessageDialog(null, "로그인 성공");
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패: 아이디나 비밀번호가 올바르지 않습니다.");
                }
            }
        });

        // 패널을 프레임의 중앙에 추가
        frame.add(panel, BorderLayout.CENTER);

        // 프레임 보이기
        frame.setVisible(true);
    }
}
