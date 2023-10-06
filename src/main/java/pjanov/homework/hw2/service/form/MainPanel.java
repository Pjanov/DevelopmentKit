package pjanov.homework.hw2.service.form;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final SouthPanel southPanel = new SouthPanel();
    private final CenterPanel centerPanel = new CenterPanel();

    public MainPanel() {
        setLayout(new BorderLayout());
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel);
    }

    public SouthPanel getSouthPanel() {
        return southPanel;
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }
}
