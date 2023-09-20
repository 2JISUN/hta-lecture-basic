import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JComboboxTest extends JFrame {
    private String fruits[] = { "apple", "peach", "strawberry" };
    private ImageIcon imageList[] = {
            new ImageIcon("images/apple-normal.png"),
            new ImageIcon("images/peach.png"),
            new ImageIcon("images/strawberry-normal.png")
    };
    private JLabel imgLabel = new JLabel(imageList[0]);

    JComboboxTest() {
        this.setTitle("text area");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JComboBox<String> strComboBox = new JComboBox<>(fruits);
        contentPane.add(strComboBox);
        contentPane.add(imgLabel);
        strComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("바꼈다");
                System.out.println(strComboBox.getSelectedIndex());
                System.out.println(strComboBox.getSelectedItem());
                imgLabel.setIcon(imageList[strComboBox.getSelectedIndex()]);
            }
        });
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JComboboxTest();
    }
}