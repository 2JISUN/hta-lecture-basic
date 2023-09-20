import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame {

    // 전역변수
    private JTextField sender = null; // 텍스트 필드 (메시지 입력)
    private Receiver receiver = null; // 메시지를 표시할 영역
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;
    private Socket socket = null;
    private ServerSocket serverSocket = null;

    // 생성자 : 서버 프로그램을 구현한 클래스의 생성자
    ChatServer() {
        // UI(제목,닫기)
        this.setTitle("[Server] 써니's Secret Diary 🍀"); // 프레임 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 설정
        


        // 요소 생성 > 컨테이너, 레이블 등등..
        // 컨테이너
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // 메시지 입력 필드
        sender = new JTextField(); // 메시지 입력 필드 생성
        contentPane.add(sender, BorderLayout.SOUTH); // 아래쪽에 배치
        // sender 텍스트 필드에 ActionListener를 추가하여 사용자가 텍스트를 입력하고 엔터 키를 누르면 메시지가 클라이언트로 전송되고, 입력 필드가 초기화됩니다.
        sender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = sender.getText(); // 입력한 메시지 가져오기
                try {
                    bufferedWriter.write(msg + "\n"); // 메시지 전송
                    bufferedWriter.flush(); // 버퍼 비우기
                    receiver.append("\nClient: " + msg); // 메시지를 표시 영역에 추가
                    sender.setText(""); // 입력 필드 초기화
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // 메시지 로그창
        receiver = new Receiver(); // 메시지를 표시할 JTextArea 생성
        contentPane.add(new JScrollPane(receiver), BorderLayout.CENTER); // 중앙에 배치

        
        // 서버 연결
        try {
            // 클라이언트 클래스를 accept를 추가로 설정해주어야한다.
            serverSocket = new ServerSocket(9998); // *서버* 소켓 생성
            socket = serverSocket.accept(); // 클라이언트의 연결을 대기하고 수락
            receiver.append("Client connected."); // 클라이언트 연결 메시지 표시

            // 입출력 스트림 생성
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력 스트림 생성
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 출력 스트림 생성
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

         // UI(크기, 가시화)
        this.setSize(400, 500); // 프레임 크기 설정
        this.setVisible(true); // 프레임 표시


        // 스레드(동시성)
        Thread thread = new Thread(receiver); // 메시지 수신을 위한 스레드 생성
        thread.start(); // 스레드 시작
    }

    // 내부 클래스 : JTextArea를 확장하며, Runnable 인터페이스를 구현한 내부 클래스입니다.
    class Receiver extends JTextArea implements Runnable {
        // run 메서드를 오버라이드하여 스레드가 실행될 내용을 정의합니다.
        @Override
        public void run() {
            String msg;
            while (true) { //무한 루프를 통해 *클라이언트*로부터 메시지를 지속적으로 수신하고, 수신한 메시지를 화면에 추가합니다.
                try {
                    msg = bufferedReader.readLine(); // 클라이언트로부터 메시지 받기
                    if (msg != null) {
                        this.append("\nClient: " + msg); // 받은 메시지를 표시 영역에 추가
                        int scrollPosition = this.getText().length();
                        this.setCaretPosition(scrollPosition); // 스크롤 이동
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    // 메인 메소드 : Java 프로그램의 진입점(entry point)입니다.
    public static void main(String[] args) {
        new ChatServer(); // ChatServer 객체 생성하여 프로그램 시작
    }
}
