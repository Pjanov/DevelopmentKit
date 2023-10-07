package pjanov.homework.test.client.form;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final NorthPanel northPanel = new NorthPanel();
    private final SouthPanel southPanel = new SouthPanel();
    private final CenterPanel centerPanel = new CenterPanel();

    public MainPanel() {
        setLayout(new BorderLayout());

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel);
    }

    public NorthPanel getNorthPanel() {
        return northPanel;
    }

    public SouthPanel getSouthPanel() {
        return southPanel;
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }
}
