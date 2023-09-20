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



public class FavoriteSnack extends JFrame {
	    private int num = 2;

    FavoriteSnack() {

        String snackImgList[] = {
                "새우깡.jpg",
                "초코파이.jpg",
                "홈런볼.jpg",
                "포카칩.jpg",
                "꼬깔콘.jpg",
                "프링글스.jpg",
                "맛동산.jpg",
                "오징어땅콩.jpg",
                "에이스.jpg",
                "꼬북칩.jpg",
                "오예스.jpg",
                "몽쉘.jpg",
                "카스타드.jpg",
                "허니버터칩.jpg",
                "썬.jpg",
                "C콘칩.jpg",
        };
        String snackTitleList[] = {
                "새우깡",
                "초코파이",
                "홈런볼",
                "포카칩",
                "꼬깔콘",
                "프링글스",
                "맛동산",
                "오징어땅콩",
                "에이스",
                "꼬북칩",
                "오예스",
                "몽쉘",
                "카스타드",
                "허니버터칩",
                "썬",
                "C콘칩",
        };

        this.setTitle("최애 간식");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 모든 걸 다 가지고 있음
        Container contentPane = this.getContentPane();

        JLabel titleLabel = new JLabel("최애 간식 리스트");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.setLayout(new BorderLayout()); // 동서남북 배치...
        contentPane.add(titleLabel, BorderLayout.NORTH);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));

        JPanel mainPanel = new JPanel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        // leftPanel.setLayout(new BorderLayout());
        JLabel leftImgJLabel = new JLabel(new ImageIcon("images/snack/새우깡.jpg"));
        JLabel leftTxtLabel = new JLabel("새우깡");
        leftPanel.add(leftImgJLabel, BorderLayout.NORTH);
        leftPanel.add(leftTxtLabel, BorderLayout.SOUTH);

        JLabel rightImgJLabel = new JLabel(new ImageIcon("images/snack/초코파이.jpg"));
        JLabel rightTxtLabel = new JLabel("초코파이");
        rightPanel.add(rightImgJLabel, BorderLayout.NORTH);
        rightPanel.add(rightTxtLabel, BorderLayout.SOUTH);

        leftImgJLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                rightImgJLabel.setIcon(new ImageIcon("images/snack/" + snackImgList[num]));
                rightTxtLabel.setText(snackTitleList[num]);
                num++;
                if (num >= 16) {
                    rightPanel.setVisible(false);
                    titleLabel.setText("당신의 최애 과자는 " + leftTxtLabel.getText());
                    leftImgJLabel.removeMouseListener(this);
                }
            }
        });
        rightImgJLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                leftImgJLabel.setIcon(new ImageIcon("images/snack/" + snackImgList[num]));
                leftTxtLabel.setText(snackTitleList[num]);
                num++;
                if (num >= 16) {
                    leftPanel.setVisible(false);
                    titleLabel.setText("당신의 최애 과자는 " + rightTxtLabel.getText());
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
        new FavoriteSnack();
    }
	
}
