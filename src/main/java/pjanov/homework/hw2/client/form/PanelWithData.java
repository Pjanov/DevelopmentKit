package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class PanelWithData extends JPanel {
    private final JTextField serverIpAddresses = new JTextField("127.0.0.1", 12);
    private final JTextField serverConnectionPort = new JTextField("8189");
    private JTextField username = new JTextField("Андрей");
    private final JPasswordField password = new JPasswordField("123456789");

    public PanelWithData() {
        setLayout(new GridLayout(2, 2, 1, 1));
        add(serverIpAddresses);
        add(serverConnectionPort);
        add(username);
        add(password);
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }
}
