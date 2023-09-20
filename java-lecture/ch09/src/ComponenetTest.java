import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponenetTest extends JFrame {

	ComponenetTest() {
		// 창 타이틀
		this.setTitle("컴퍼넌트 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// container는 기본적으로 layout을 가지고 있다. > 레이아웃 바꿔주기
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		JButton btn01 = new JButton("Red/Yellow");
		JButton btn02 = new JButton("disable");
		JButton btn03 = new JButton("x,y");
		btn01.setForeground(new Color(255, 0, 0));
		btn01.setBackground(new Color(255, 255, 0));
		btn02.setEnabled(false);
		// 익명 클래스로 처리
		btn03.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				ComponenetTest frame = (ComponenetTest) btn.getTopLevelAncestor();
				frame.setTitle(btn03.getX()+"/"+btn03.getY());
			}

		});
		contentPane.add(btn01);
		contentPane.add(btn02);
		contentPane.add(btn03);

		// 시각화
		this.setSize(300, 300);
		this.setVisible(true);


	}


	public static void main(String[] args) {
		new ComponenetTest();
	

	}
}
