import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DreamCar extends JFrame {
    private int num = 2;

    DreamCar() {

        String carImgList[] = {
                "car01.png",
                "car02.png",
                "car03.png",
                "car04.png",
                "car05.png",
                "car06.png",
                "car07.png",
                "car08.png",
                "car09.png",
                "car10.png",
                "car11.png",
                "car12.png",
                "car13.png",
                "car14.png",
                "car15.png",
                "car16.png",
        };
        String carTitleList[] = {
                "벤츠",
                "람보르기니",
                "부가티",
                "소나타",
                "모닝",
                "팰리세이드",
                "bmw",
                "그랜져",
                "아우디",
                "소나타3",
                "k7",
                "k9",
                "렉서스",
                "gv80",
                "똥차",
                "고물차",
        };

        this.setTitle("dream car");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 모든 걸 다 가지고 있음
        Container contentPane = this.getContentPane();

        JLabel titleLabel = new JLabel("당신이 꿈꾸는 드림카!! 원하는 차를 클릭해 주세요.");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.setLayout(new BorderLayout()); // 동서남북 배치...
        contentPane.add(titleLabel, BorderLayout.NORTH);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));

        JPanel mainPanel = new JPanel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        // leftPanel.setLayout(new BorderLayout());
        JLabel leftImgJLabel = new JLabel(new ImageIcon("images/car/car01.png"));
        JLabel leftTxtLabel = new JLabel("람보르기니");
        leftPanel.add(leftImgJLabel, BorderLayout.NORTH);
        leftPanel.add(leftTxtLabel, BorderLayout.SOUTH);

        JLabel rightImgJLabel = new JLabel(new ImageIcon("images/car/car02.png"));
        JLabel rightTxtLabel = new JLabel("페라리");
        rightPanel.add(rightImgJLabel, BorderLayout.NORTH);
        rightPanel.add(rightTxtLabel, BorderLayout.SOUTH);

        leftImgJLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                rightImgJLabel.setIcon(new ImageIcon("images/car/" + carImgList[num]));
                rightTxtLabel.setText(carTitleList[num]);
                num++;
                if (num >= 16) {
                    rightPanel.setVisible(false);
                    titleLabel.setText("당신의 드림카는" + leftTxtLabel.getText());
                    leftImgJLabel.removeMouseListener(this);
                }
            }
        });
        rightImgJLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                leftImgJLabel.setIcon(new ImageIcon("images/car/" + carImgList[num]));
                leftTxtLabel.setText(carTitleList[num]);
                num++;
                if (num >= 16) {
                    leftPanel.setVisible(false);
                    titleLabel.setText("당신의 드림카는" + rightTxtLabel.getText());
                    rightImgJLabel.removeMouseListener(this);
                }
            }
        });

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        contentPane.add(mainPanel, BorderLayout.CENTER);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DreamCar();
    }
}