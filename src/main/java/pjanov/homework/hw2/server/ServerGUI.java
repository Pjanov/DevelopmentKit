package pjanov.homework.hw2.server;

import pjanov.homework.hw2.client.ClientGUI;
import pjanov.homework.hw2.interfaceForm.InterfaceForForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ActionListener, InterfaceForForm {
    private final JButton buttonStartService = new JButton("StartService");
    private final JButton buttonStopService = new JButton("StopService");
    private final JTextArea messageHistory = new JTextArea("Необходимо включить сервер");
    private final JPanel panelSouth = new JPanel(new GridLayout(1, 2));
    private final ClientGUI clientGUI;
    private final ClientGUI clientGUI2;
    private boolean status = false;

    public ServerGUI(String title) throws HeadlessException {
        super(title);
        windowData();
        positionButtons();
        positionTextField();
        clientGUI = new ClientGUI(this, "Клиент");
        clientGUI2 = new ClientGUI(this, "Клиент");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonStartService && !status) {
            messageFromServer("Сервер включен ..." + "\n", Color.GREEN, true);
        } else if (e.getSource() == buttonStopService && status) {
            messageFromServer("Сервер выключен", Color.RED, false);
        }
    }

    public JTextArea getMessageHistory() {
        return messageHistory;
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private void messageFromServer(String msg, Color color, boolean b) {
        messageHistory.setForeground(color);
        messageHistory.setText(msg);
        setStatus(b);
        clientGUI.getChatHistoryArea().append(msg + "\n");
        clientGUI2.getChatHistoryArea().append(msg + "\n");
    }

    public ClientGUI getClientGUI() {
        return clientGUI;
    }

    public ClientGUI getClientGUI2() {
        return clientGUI2;
    }

    @Override
    public void positionButtons() {
        buttonStartService.addActionListener(this);
        buttonStopService.addActionListener(this);
        panelSouth.add(buttonStartService);
        panelSouth.add(buttonStopService);
        add(panelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void positionTextField() {
        messageHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageHistory);
        add(scrollPane);
    }

    @Override
    public void windowData() {
        setSize(InterfaceForForm.WIDTH, InterfaceForForm.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(483, 100);
    }
}
