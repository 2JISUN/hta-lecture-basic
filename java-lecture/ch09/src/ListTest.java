import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListTest extends JFrame {
	private String fruits[] = {"사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓","사과", "바나나", "샤인머스켓"};
	private Vector<String> vector = new Vector<>();

	


	ListTest() {
		this.setTitle("text area");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		JList<String> strList = new JList<>(fruits);
		JList<String> vecList = new JList<>(vector);
			vector.add("곰");
			vector.add("호랑이");
			vector.add("사자");
			vector.add("고양이");
		contentPane.add(new JScrollPane(strList));
		contentPane.add(new JScrollPane(vecList));
		strList.setVisibleRowCount(3);
		strList.setFixedCellWidth(150);

		this.setSize(300, 300);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		new ListTest();
	}
	
}
