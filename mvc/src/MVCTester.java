import java.io.*;
import java.awt.*;
import javax.swing.*;

public class MVCTester {
    public static void main(String[] args) {

    JFrame frame = new JFrame();

    frame.setSize(200, 200);
    JButton button = new JButton("add");
    JTextArea textArea = new JTextArea(10,25);
    JTextField text = new JTextField(20);
    
    frame.setLayout(new FlowLayout());

    frame.add(button);
    frame.add(textArea);
    frame.add(text);

    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
