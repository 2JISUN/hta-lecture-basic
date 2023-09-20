package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame {
    private JTextArea log = new JTextArea(20, 30);
    private JLabel userLabel = new JLabel();
    private ArrayList<ClientSocketThread> clientSocketList = null;
    private Socket socket = null;
    private ServerSocket serverSocket = null;

    public Server() {
        super("멀티 채팅");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 버튼(X)을 클릭하면 프로그램 종료
        Container c = getContentPane();
        log.setBackground(Color.GREEN);
        c.add(new JScrollPane(log), BorderLayout.CENTER);
        userLabel.setText("현재 접속자수는 0명 입니다.");
        c.add(userLabel, BorderLayout.SOUTH);
        this.pack();
        this.setResizable(false);
        setVisible(true);
        clientSocketList = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(9995);
            userLabel.setText("서버 동작중입니다.");
            ClientSocketThread clientSocketThread = null;
            while (true) {
                socket = serverSocket.accept();
                log.append("클라이언트 접속 \n");
                clientSocketThread = new ClientSocketThread();
                clientSocketList.add(clientSocketThread);
                clientSocketThread.start();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    class ClientSocketThread extends Thread {
        private BufferedReader bufferedReader = null;
        private BufferedWriter bufferedWriter = null;
        private String message = null;

        @Override
        public void run() {
            boolean isStop = false;
            String splitMsg[] = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                while (!isStop) {
                    message = bufferedReader.readLine();
                    // System.out.println("client에서 넘어온 message = " + message);
                    splitMsg = message.split("#");
                    if (splitMsg[1].equals("exit") || splitMsg[1].equals("그만")) {
                        isStop = true;
                    }
                    broadCasting(message);
                }
                clientSocketList.remove(this);
                log.append(splitMsg[0] + "님이 빠져 나갔습니다.");
                userLabel.setText("남은 사람은 : " + clientSocketList.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(String message) {
            try {
                bufferedWriter.write(message + "\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void broadCasting(String message) {
            // clientSocketList에 있는 곳에다가 전부 전송해주기...
            for (int i = 0; i < clientSocketList.size(); i++) {
                ClientSocketThread client = clientSocketList.get(i);
                client.send(message);
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}