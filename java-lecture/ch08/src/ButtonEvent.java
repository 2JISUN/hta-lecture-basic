import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent implements ActionListener {
    private JFrame frame;

    public ButtonEvent(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(
                frame,
                "나가시겠습니까?",
                "확인",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            frame.dispose(); // 프레임 종료
        }
    }

}