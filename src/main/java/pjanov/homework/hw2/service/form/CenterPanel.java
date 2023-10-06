package pjanov.homework.hw2.service.form;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JTextArea messageHistory;
    private JScrollPane scrollPane;

    public CenterPanel() {
        messageHistory = new JTextArea();
        messageHistory.setEditable(false);
        scrollPane = new JScrollPane(messageHistory);
        setLayout(new BorderLayout());

        add(scrollPane);
    }
}
