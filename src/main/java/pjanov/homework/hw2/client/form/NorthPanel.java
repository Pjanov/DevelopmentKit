package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    private JButton buttonLogin = new JButton("Login");
    private final PanelWithData panelWithData = new PanelWithData();

    public NorthPanel() {
        buttonLogin.setPreferredSize(new Dimension(80, 40));
        setLayout(new BorderLayout());

        add(panelWithData);
        add(buttonLogin, BorderLayout.EAST);
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(JButton buttonLogin) {
        this.buttonLogin = buttonLogin;
    }

    public PanelWithData getPanelWithData() {
        return panelWithData;
    }
}
