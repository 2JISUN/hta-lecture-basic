import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("300 x 300으로 만든 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane =	this.getContentPane();

		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancle"));

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
	}
}
