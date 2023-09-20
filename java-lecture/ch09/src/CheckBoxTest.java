import java.awt.Checkbox;

import javax.swing.JFrame;

public class CheckBoxTest extends JFrame{
	CheckBoxTest(){
		this.setTitle("checkbox test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Checkbox("사과");

		this.setSize(300,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
	}
	
}
