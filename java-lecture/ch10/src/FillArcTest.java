import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class FillArcTest extends JFrame {
    MyPanel myPanel = new MyPanel();
    FillArcTest() {
        this.setTitle("graphics 연습");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(myPanel);

        this.setSize(800, 600);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {

        MyPanel() {
            // MyPanel 클래스 생성자 추가
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            g.drawRect(100, 100, 100, 100);
        }
    }

    public static void main(String[] args) {
        new FillArcTest();
    }
}
