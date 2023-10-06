package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class PanelWithData extends JPanel {
    private JTextField serverIpAddresses = new JTextField("127.0.0.1", 12);
    private JTextField serverConnectionPort = new JTextField("8189");
    private JTextField username = new JTextField("Андрей");
    private JPasswordField password = new JPasswordField("123456789");

    public PanelWithData() {
        setLayout(new GridLayout(2, 2, 1, 1));
        add(serverIpAddresses);
        add(serverConnectionPort);
        add(username);
        add(password);
    }
}
