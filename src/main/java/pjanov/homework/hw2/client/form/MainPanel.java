package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private NorthPanel northPanel;
    private SouthPanel southPanel;
    private CenterPanel centerPanel;

    public MainPanel() {
        northPanel = new NorthPanel();
        southPanel = new SouthPanel();
        centerPanel = new CenterPanel();

        setLayout(new BorderLayout());

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel);
    }
}
