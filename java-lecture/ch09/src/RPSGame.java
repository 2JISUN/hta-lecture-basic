import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RPSGame extends JFrame {
	// [이미지 배열 정의]
	// 이미지 배열은 가위, 바위, 보 이미지들을 순서대로 담고 있습니다. 각 이미지는 파일 경로를 통해 생성됩니다.
    private ImageIcon[] imageList = {
            new ImageIcon("images/rsp/scissors.png"),
            new ImageIcon("images/rsp/rock.png"),
            new ImageIcon("images/rsp/paper.png")
    };

	// [컴퓨터 선택과 결과 표시를 위한 레이블 정의]
    private JLabel userChoiceLabel = new JLabel("컴퓨터의 선택 : "); // 컴퓨터의 선택을 나타내는 문자열을 가진 레이블
    private JLabel computerChoiceLabel = new JLabel();  // 컴퓨터가 선택한 이미지를 출력하기 위한 레이블
    private JLabel resultLabel = new JLabel("결과 표시될 곳"); //게임 결과를 표시할 레이블


	// [html]
    RPSGame() {
        this.setTitle("가위바위보 Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// [화면 구성]
		// [화면 구성] > 상단
        JPanel topPanel = new JPanel(); 
        topPanel.setBackground(Color.BLACK);
        for (ImageIcon image : imageList) { 
            JLabel imageLabel = new JLabel(image); // 각 이미지를 나타내는 레이블을 생성
            imageLabel.addMouseListener(new MouseClickListener(image)); // MouseListener를 연결하여 클릭 이벤트를 처리
            topPanel.add(imageLabel);
        }
        add(topPanel, BorderLayout.NORTH);


        // [화면 구성] > 하단
        JPanel bottomPanel = new JPanel(); // 컨테이너 역할
        bottomPanel.setBackground(Color.YELLOW); // 배경색 설정
        bottomPanel.setLayout(new GridBagLayout());  // GridBagLayout을 사용하여 각 레이블을 가운데로 정렬하고 여백, GridBagLayout은 복잡한 레이아웃을 생성할 수 있는 강력한 레이아웃 매니저로, 다양한 컴포넌트를 유연하게 배치할 수 있습니다.
        GridBagConstraints gbc = new GridBagConstraints(); //GridBagConstraints 객체를 생성하고, 컴포넌트 배치에 대한 제약사항을 설정
        gbc.insets = new Insets(10, 10, 10, 10); // insets 속성은 컴포넌트 주변에 여백을 설정하는 것으로, 위 코드에서는 10px의 여백을 설정
        bottomPanel.add(userChoiceLabel, gbc);
        bottomPanel.add(computerChoiceLabel, gbc);
        bottomPanel.add(resultLabel, gbc);
        add(bottomPanel, BorderLayout.CENTER);
		// 이렇게 하단 영역을 GridBagLayout을 사용하여 여러 레이블을 가운데로 정렬하고 여백을 설정하여 구성한 이유는, 레이블들을 균등하게 배치하고 가독성을 높이기 위함입니다. GridBagLayout은 유연한 배치를 지원하며, 여러 개의 컴포넌트를 다양한 크기와 위치로 배치할 수 있어 다양한 레이아웃 요구 사항을 처리하기에 적합한 레이아웃 매니저입니다.

        this.setSize(900, 300);
        this.setVisible(true);
    }

	// [이벤트 처리] > 이미지 클릭 했을 때
    private class MouseClickListener extends MouseAdapter {
        private ImageIcon choiceImage;

        public MouseClickListener(ImageIcon image) {
            choiceImage = image;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

			// 컴퓨터 선택 > 랜덤
            int computerChoiceIndex = (int) (Math.random() * 3); // 0,1,2
            ImageIcon computerChoiceImage = imageList[computerChoiceIndex];
			computerChoiceLabel.setIcon(new ImageIcon(computerChoiceImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));// 이미지를 폭 50, 높이 50으로 축소하여 설정

			 // 유저 선택
            int userChoiceIndex = -1;
            for (int i = 0; i < imageList.length; i++) {
                if (imageList[i] == choiceImage) {
                    userChoiceIndex = i;
                    break;
                }
            }

			// 승패 결정
            String result;
            if (userChoiceIndex == computerChoiceIndex) {
                result = "무승부";
            } else if ((userChoiceIndex == 0 && computerChoiceIndex == 2) ||
                    (userChoiceIndex == 1 && computerChoiceIndex == 0) ||
                    (userChoiceIndex == 2 && computerChoiceIndex == 1)) {
                result = "유저의 승리";
            } else {
                result = "컴퓨터의 승리";
            }

            resultLabel.setText(result);
        }
    }

	// 메인 메소드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RPSGame()); //SwingUtilities.invokeLater를 사용하여 GUI 스레드에서 프레임을 생성하고 실행
    }
}
