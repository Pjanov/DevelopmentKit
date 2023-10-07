package pjanov.homework.hw2.server;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ActionListener {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final JButton buttonStartService = new JButton("StartService");
    private final JButton buttonStopService = new JButton("StopService");
    private final JTextArea messageHistory = new JTextArea("Необходимо включить сервер");
    private final JPanel panelSouth = new JPanel(new GridLayout(1, 2));
    private boolean status = false;

    public ServerGUI(String title) throws HeadlessException {
        super(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(483, 100);

        buttonStartService.addActionListener(this);
        buttonStopService.addActionListener(this);

        messageHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageHistory);
        panelSouth.add(buttonStartService);
        panelSouth.add(buttonStopService);
        add(panelSouth, BorderLayout.SOUTH);
        add(scrollPane);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonStartService && !status) {
            serverInformation("Сервер Включён ...", Color.GREEN, true);
        } else if (e.getSource() == buttonStopService && status) {
            serverInformation("Сервер Выключен", Color.RED, false);
        }
    }

    public void serverInformation(String text, Color color, boolean b) {
        messageHistory.setForeground(color);
        messageHistory.setText(text);
        status = b;
    }
}
