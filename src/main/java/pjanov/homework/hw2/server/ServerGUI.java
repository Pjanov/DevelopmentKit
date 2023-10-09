package pjanov.homework.hw2.server;

import pjanov.homework.hw2.client.ClientGUI;
import pjanov.homework.hw2.interfaceForm.InterfaceForForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerGUI extends JFrame implements ActionListener, InterfaceForForm {
    private final JButton buttonStartService = new JButton("StartService");
    private final JButton buttonStopService = new JButton("StopService");
    private final JTextArea messageHistory = new JTextArea("Необходимо включить сервер");
    private final JPanel panelSouth = new JPanel(new GridLayout(1, 2));
    private final List<ClientGUI> clientGUIList;
    private boolean status = false;

    public ServerGUI(String title) throws HeadlessException {
        super(title);
        windowData();
        positionButtons();
        positionTextField();
        clientGUIList = new ArrayList<>();
        setVisible(true);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Сообщение от сервера
     *
     * @param msg   сообщение
     * @param color цвет сообщения
     * @param b     статус сервера
     */
    private void messageFromServer(String msg, Color color, boolean b) {
        messageHistory.setForeground(color);
        messageHistory.setText(msg);
        setStatus(b);
        sendMessageFromServerToClient(msg + "\n");
        setClientStatus(b);
    }

    /**
     * Отправить сообщение от сервера клиенту
     *
     * @param msg сообщение
     */
    public void sendMessageFromServerToClient(String msg) {
        for (ClientGUI clientGUI : clientGUIList) {
            clientGUI.addMessage(msg);
        }
    }

    /**
     * Установить статус клиента
     *
     * @param b статус клиента
     */
    public void setClientStatus(boolean b) {
        for (ClientGUI clientGUI : clientGUIList) {
            clientGUI.setStatus(b);
            if (!b) {
                clientGUI.getUsername().setForeground(Color.RED);
            } else {
                clientGUI.getUsername().setForeground(Color.GREEN);
            }
        }
    }

    public List<ClientGUI> getClientGUIList() {
        return clientGUIList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonStartService && !status) {
            messageFromServer("Сервер включен ...\n", Color.GREEN, true);
        } else if (e.getSource() == buttonStopService && status) {
            messageFromServer("Сервер выключен\n", Color.RED, false);
        }
    }

    @Override
    public void addMessage(String msg) {
        messageHistory.append(msg);
    }

    @Override
    public boolean isStatus() {
        return status;
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
