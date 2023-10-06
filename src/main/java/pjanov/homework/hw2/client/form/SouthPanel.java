package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private JTextField message;
    private JButton buttonSend;

    public SouthPanel() {
        message = new JTextField(20);
        buttonSend = new JButton("send");
        setLayout(new BorderLayout());

        add(message);
        add(buttonSend, BorderLayout.EAST);
    }
}
