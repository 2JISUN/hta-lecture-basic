package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

// 다중 채팅...
// 이름을 입력받아서 window열리면서 
public class Client extends JFrame implements Runnable {
    String chattingName = null;
    JLabel nickLabel = new JLabel();
    JTextArea textArea = null;
    JTextField textField = null;
    JButton btn = null;
    Socket socket = null;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;

    Client() {
        // Thread 만들어서...
        // 서버에서 받아보기...
        chattingName = JOptionPane.showInputDialog(this, "닉네임을 쓰세요.", "닉네임", JOptionPane.YES_NO_OPTION);
        // System.out.println(chattingName);
        if (chattingName.length() == 0 || chattingName == null) {
            System.exit(0);
        }
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        nickLabel.setText(chattingName);
        contentPane.add(nickLabel, BorderLayout.NORTH);
        textArea = new JTextArea(20, 30);
        textArea.setBackground(Color.GREEN);
        textArea.setEditable(false);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        textField = new JTextField(30);
        inputPanel.add(textField, BorderLayout.WEST);
        btn = new JButton("나가기");
        inputPanel.add(btn, BorderLayout.EAST);
        contentPane.add(inputPanel, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 뭘 보내야지 잘했다고 소문이 날까요?
                // bufferedWriter.write();
                try {
                    bufferedWriter.write(chattingName + "#exit\n");
                    bufferedWriter.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        });
        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // textArea.append(chattingName + " : " + textField.getText() + "\n");
                // 누가 글을 썻는지 와 내용
                try {
                    bufferedWriter.write(chattingName + "#" + textField.getText() +
                            "\n");
                    bufferedWriter.flush();
                    // 이걸 서버에서 받는다.
                    // 받아서 접속된 클라이언트에 싹다 뿌려준다.
                    textField.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        this.setTitle("멀티 채팅");
        this.pack();
        this.setResizable(false);
        this.setVisible(true);

        try {
            socket = new Socket("localhost", 9995);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Thread thread = new Thread(this);
            thread.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    @Override
    public void run() {
        String message = null;
        String receiveMsg[] = null;
        boolean isStop = false;
        while (!isStop) {
            try {
                message = bufferedReader.readLine();
                System.out.println("서버에서 클라이언트 전부에게 뿌린 메세지 ==" + message);
                receiveMsg = message.split("#");
                System.out.println(receiveMsg[0]);
                System.out.println(receiveMsg[1]);
                textArea.append(receiveMsg[0] + " : " + receiveMsg[1] + "\n");
                if (receiveMsg[1].equals("exit") || receiveMsg[1].equals("그만")) {
                    if (receiveMsg[0].equals(chattingName)) {
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                isStop = true;
            }
        }
    }
}