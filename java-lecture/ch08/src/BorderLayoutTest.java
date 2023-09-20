import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {

	BorderLayoutTest() {
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10,10));
		contentPane.add(new JButton("Calc"), BorderLayout.CENTER);
		contentPane.add(new JButton("add"), BorderLayout.NORTH);
		contentPane.add(new JButton("sub"), BorderLayout.SOUTH);
		contentPane.add(new JButton("mul"), BorderLayout.EAST);
		contentPane.add(new JButton("div"), BorderLayout.WEST);

		setSize(500, 500);
		setVisible(true);
	}


	public static void main(String[] args) {
		new BorderLayoutTest();
	}
}
