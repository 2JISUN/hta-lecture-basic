import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint01 extends JFrame{

	private MyPanel ;
	

	// UI띄우기
	Paint01(){
		this.setTitle("checkbox test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(MyPanel);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());




		this.setSize(800, 600);
        this.setVisible(true);
	}



	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);

			// 벽돌
			g.setColor(Color.RED);
			for(int i=0; i<5; i++){
				for(int j=0; j<10; j++){
					
				}
				g.fillRect(80*i,51*i,80,50);
			}

			// 공
			g.setColor(Color.BLACK);
			g.fillOval(400, 500, 20, 20);

			// 공-바
			g.setColor(Color.blue);
			g.fillRect(400, 520, 100, 20);

			//중간에 글자 
			g.setColor(Color.RED);
			g.setFont(new Font("맑은 고딕", Font.BOLD,64));
			g.drawString("벽!!돌!!깨!!기!!",600,400);

		}
	}

	public static void main(String[] args) {
		
	}
}
