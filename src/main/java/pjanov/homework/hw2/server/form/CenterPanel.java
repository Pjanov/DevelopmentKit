package pjanov.homework.hw2.server.form;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JTextArea messageHistory = new JTextArea("Необходимо включить сервер");

    public CenterPanel() {
        messageHistory.setEditable(false);

        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(messageHistory);


        add(scrollPane);
    }

    public JTextArea getMessageHistory() {
        return messageHistory;
    }

    public void setMessageHistory(JTextArea messageHistory) {
        this.messageHistory = messageHistory;
    }
}
