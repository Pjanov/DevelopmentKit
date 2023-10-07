package pjanov.homework.test.client.form;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private JTextField message = new JTextField(20);
    private JButton buttonSend = new JButton("send");

    public SouthPanel() {
        setLayout(new BorderLayout());

        add(message);
        add(buttonSend, BorderLayout.EAST);
    }

    public JTextField getMessage() {
        return message;
    }

    public void setMessage(JTextField message) {
        this.message = message;
    }

    public JButton getButtonSend() {
        return buttonSend;
    }

    public void setButtonSend(JButton buttonSend) {
        this.buttonSend = buttonSend;
    }
}
