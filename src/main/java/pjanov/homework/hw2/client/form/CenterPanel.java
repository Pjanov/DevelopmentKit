package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JTextArea messageHistory = new JTextArea("История");

    public CenterPanel() {
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(messageHistory);

        add(scrollPane);
    }

    public void setMessageHistory(JTextArea messageHistory) {
        this.messageHistory = messageHistory;
    }

    public JTextArea getMessageHistory() {
        return messageHistory;
    }
}
