import java.awt.*;
import javax.swing.*;

public class JLableTest extends JFrame {

	JLableTest() {
		this.setTitle("JLable");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon imageIcon = new ImageIcon("images/airplane.png");

		JLabel label01 = new JLabel("gloomy monday");
		JLabel label02 = new JLabel(imageIcon);
		JLabel label03 = new JLabel("apple label", imageIcon, SwingConstants.BOTTOM);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(label01);
		contentPane.add(label02);
		contentPane.add(label03);

		this.setSize(300, 300);
		this.setVisible(true);
	}


	public static void main(String[] args) {
		new JLableTest();
	}
}
