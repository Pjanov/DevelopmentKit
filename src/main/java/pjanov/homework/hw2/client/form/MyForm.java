package pjanov.homework.hw2.client.form;

import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {
    private int WIDTH = 400;
    private int HEIGHT = 400;

    public MyForm(String title) throws HeadlessException {
        super(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(false);
    }
}
