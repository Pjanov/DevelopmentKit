package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private JTextArea messageHistory;
    private JScrollPane scrollPane;

    public CenterPanel() {
        setLayout(new BorderLayout());
        messageHistory = new JTextArea();
        scrollPane = new JScrollPane(messageHistory);

        add(scrollPane);
    }
}
