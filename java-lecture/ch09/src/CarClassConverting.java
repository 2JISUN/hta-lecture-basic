import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Car {
    private String img;
    private String title;

    public Car(String img, String title) {
        this.img = img;
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

class CarPanel extends JPanel {
    private JLabel imgLabel = new JLabel();
    private JLabel txtLabel = new JLabel();

    CarPanel() {

    }

    CarPanel(String img, String title) {
        imgLabel.setIcon(new ImageIcon("images/car/" + img));
        txtLabel.setText(title);
        setLayout(new BorderLayout(10, 10));
        add(imgLabel, BorderLayout.NORTH);
        add(txtLabel, BorderLayout.SOUTH);
    }

    public void change(String img, String title) {
        imgLabel.setIcon(new ImageIcon("images/car/" + img));
        txtLabel.setText(title);
    }

}

public class CarClassConverting extends JFrame {
    private int num = 2;

    CarClassConverting() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("car01.png", "벤츠"));
        carList.add(new Car("car02.png", "벤츠"));
        carList.add(new Car("car03.png", "벤츠"));
        carList.add(new Car("car04.png", "벤츠"));
        carList.add(new Car("car05.png", "벤츠"));
        carList.add(new Car("car06.png", "벤츠"));
        carList.add(new Car("car07.png", "벤츠"));
        carList.add(new Car("car08.png", "벤츠"));
        carList.add(new Car("car09.png", "벤츠"));
        carList.add(new Car("car10.png", "벤츠"));
        carList.add(new Car("car11.png", "벤츠"));
        carList.add(new Car("car12.png", "벤츠"));
        carList.add(new Car("car13.png", "벤츠"));
        carList.add(new Car("car14.png", "벤츠"));
        carList.add(new Car("car15.png", "벤츠"));
        carList.add(new Car("car16.png", "벤츠"));
        // String carImgList[] = {
        // "car01.png",
        // "car02.png",
        // "car03.png",
        // "car04.png",
        // "car05.png",
        // "car06.png",
        // "car07.png",
        // "car08.png",
        // "car09.png",
        // "car10.png",
        // "car11.png",
        // "car12.png",
        // "car13.png",
        // "car14.png",
        // "car15.png",
        // "car16.png",
        // };
        // String carTitleList[] = {
        // "벤츠",
        // "람보르기니",
        // "부가티",
        // "소나타",
        // "모닝",
        // "팰리세이드",
        // "bmw",
        // "그랜져",
        // "아우디",
        // "소나타3",
        // "k7",
        // "k9",
        // "렉서스",
        // "gv80",
        // "똥차",
        // "고물차",
        // };

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
        CarPanel leftPanel = new CarPanel("car01.png", "aaaa");
        CarPanel rightPanel = new CarPanel("car02.png", "bbbb");

        leftPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                rightPanel.change(carList.get(num).getImg(), carList.get(num).getTitle());
                num++;
                if (num >= 16) {

                }
            }
        });
        rightPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                leftPanel.change(carList.get(num).getImg(), carList.get(num).getTitle());
                num++;
                if (num >= 16) {

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
        new CarClassConverting();
    }
}