package pjanov.homework.hw2.service.form;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private JButton buttonStartService = new JButton("StartService");;
    private JButton buttonStopService = new JButton("StopService");

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

    public void setButtonStartService(JButton buttonStartService) {
        this.buttonStartService = buttonStartService;
    }

    public void setButtonStopService(JButton buttonStopService) {
        this.buttonStopService = buttonStopService;
    }
}
