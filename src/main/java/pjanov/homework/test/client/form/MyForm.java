package pjanov.homework.test.client.form;

import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    public MyForm(String title) throws HeadlessException {
        super(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(false);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
