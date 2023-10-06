package pjanov.homework.hw2.service.form;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private SouthPanel southPanel;
    private CenterPanel centerPanel;

    public MainPanel() {
        southPanel = new SouthPanel();
        centerPanel = new CenterPanel();

        setLayout(new BorderLayout());

        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel);
    }
}
