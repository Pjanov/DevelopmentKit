package pjanov.homework.hw2.server.form;

import pjanov.homework.hw2.client.form.MyForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow implements ActionListener {
    private final MyForm myForm = new MyForm("Server");
    private final MainPanel mainPanel = new MainPanel();
    private boolean serverStatus = false;

    public ServerWindow() {
        getButtonStartService().addActionListener(this);
        getButtonStopService().addActionListener(this);

        myForm.add(mainPanel);
        myForm.setVisible(true);
    }

    public MyForm getMyForm() {
        return myForm;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getButtonStartService() && !serverStatus) {
            setServerStatus("Сервер включён ...");
            serverStatus = true;
        } else if (e.getSource() == getButtonStopService() && serverStatus) {
            setServerStatus("Сервер выключен");
            serverStatus = false;
        }
    }

    public JButton getButtonStartService() {
        return mainPanel.getSouthPanel().getButtonStartService();
    }

    public JButton getButtonStopService() {
        return mainPanel.getSouthPanel().getButtonStopService();
    }

    public void setServerStatus(String s) {
        getMainPanel().getCenterPanel().getMessageHistory().setText(s);
    }
}
