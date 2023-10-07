package pjanov.homework.hw2.server.form;


import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private final JButton buttonStartService = new JButton("StartService");
    private final JButton buttonStopService = new JButton("StopService");

    public SouthPanel() {
        setLayout(new GridLayout(1, 2));
        add(buttonStartService);
        add(buttonStopService);
    }

    public JButton getButtonStartService() {
        return buttonStartService;
    }

    public JButton getButtonStopService() {
        return buttonStopService;
    }
}
