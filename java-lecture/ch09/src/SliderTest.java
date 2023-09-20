import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class SliderTest extends JFrame {
	private JSlider sliderList[] = new JSlider[3];
	private JLabel lable[] = new JLabel("색상변경");


	SliderTest(){
		this.setTitle("text area");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		for(int i = 0; i<3; i++){

			JSlider slider= new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
			contentPane.add(sliderList[i]);
			slider.setPaintLabels(true);
			slider.setPaintTrack(true);
			slider.setPaintTicks(true);
			slider.setMajorTickSpacing(50);
			slider.setMinorTickSpacing(10);
		}

		sliderList[0].setForeground(Color.red);
		sliderList[1].setForeground(Color.green);
		sliderList[2].setForeground(Color.blue);
		contentPane.add(lable);
		lable.setOpa
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SliderTest();
	}
	
}
