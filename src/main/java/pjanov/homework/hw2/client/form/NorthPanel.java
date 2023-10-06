package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    private JButton buttonLogin;
    private PanelWithData panelWithData;

    public NorthPanel() {
        panelWithData = new PanelWithData();
        buttonLogin = new JButton("Login");
        buttonLogin.setPreferredSize(new Dimension(80, 40));
        setLayout(new BorderLayout());

        add(panelWithData);
        add(buttonLogin, BorderLayout.EAST);
    }
}
