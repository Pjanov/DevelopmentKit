package pjanov.homework.hw2.service.form;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private JButton buttonStartService;
    private JButton buttonStopService;

    public SouthPanel() {
        buttonStartService = new JButton("StartService");
        buttonStopService = new JButton("StopService");

        setLayout(new GridLayout(1, 2));
        add(buttonStartService);
        add(buttonStopService);
    }
}
