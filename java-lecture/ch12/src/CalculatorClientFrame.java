import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CalculatorClientFrame extends JFrame {
    private JTextField firstTextField = new JTextField(5);
    private JTextField operatorTextField = new JTextField(3);
    private JTextField secondTextField = new JTextField(5);
    private JTextField resultTextField = new JTextField(5);
    private JButton btn = new JButton("계산");

    private Socket socket = null;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;

    CalculatorClientFrame() {
        this.setTitle("계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(firstTextField);
        contentPane.add(operatorTextField);
        contentPane.add(secondTextField);
        contentPane.add(new JLabel("="));
        contentPane.add(resultTextField);
        contentPane.add(btn);
        this.setSize(400, 200);
        this.setVisible(true);

        try {
            socket = new Socket("localhost", 9997);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("계산");
            }
        });

    }

    public static void main(String[] args) {
        new CalculatorClientFrame();
    }
}