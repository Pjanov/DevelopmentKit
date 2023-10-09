package pjanov.homework.hw2.client;

import pjanov.homework.hw2.interfaceForm.InterfaceForForm;
import pjanov.homework.hw2.server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClientGUI extends JFrame implements ActionListener, InterfaceForForm {
    private final ServerGUI serverGUI;
    private final JPanel panelSouth = new JPanel(new BorderLayout());
    private final JPanel panelCenter = new JPanel(new BorderLayout());
    private final JPanel panelNorth = new JPanel(new BorderLayout());
    private final JPanel panelWithData = new JPanel(new GridLayout(2, 2));
    private final JButton buttonSend = new JButton("Send");
    private final JTextField messageField = new JTextField();
    private final JTextArea chatHistoryArea = new JTextArea();
    private final JTextField serverIpAddresses = new JTextField("127.0.0.1", 10);
    private final JTextField serverConnectionPort = new JTextField("8189");
    private final JTextField username = new JTextField("Введите своё имя");
    private final JPasswordField password = new JPasswordField("123456789");
    private final JButton buttonLogin = new JButton("Ok");
    private final String CHAT_HISTORY_FILE = "chat_history.txt";
    private boolean status;

    public ClientGUI(ServerGUI serverGUI, String title) throws HeadlessException {
        super(title);
        this.serverGUI = serverGUI;
        windowData();
        positionButtons();
        positionTextField();
        positionTextField();

        setVisible(true);
    }

    public JTextArea getChatHistoryArea() {
        return chatHistoryArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSend) {
            btSend("С начало авторизуйтесь!!!");
        } else if (e.getSource() == buttonLogin) {
            btLogin("Вы не авторизованы!!!");
            chatHistoryArea.append("");
        }
    }

    public static String readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ошибка: " + e.getMessage(),
                    "Ошибка чтения сообщения", JOptionPane.ERROR_MESSAGE);
        }

        return sb.toString();
    }

    public void saveToFile(String fileName, String text) {
        String userMessage = getUsername().getText();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write( userMessage + "\n" + text + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ошибка: " + e.getMessage(),
                    "Ошибка отправления сообщения", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btLogin(String msg) {
        String name = getUsername().getText();
        if (serverGUI.isStatus()) {
            if (name.equals("Введите своё имя")) {
                setStatus(false);
                chatHistoryArea.append(msg + "\n");
            } else {
                setStatus(true);
                setTitle(name);
                getUsername().setForeground(Color.GREEN);
                chatHistoryArea.append(name + " вы авторизованы" + "\n");
                chatHistoryArea.append(readFromFile(CHAT_HISTORY_FILE));
                serverGUI.getClientGUIList().add(this);
            }
        } else {
            chatHistoryArea.append("Необходимо запустить сервер!" + "\n");
            setStatus(false);
        }
    }

    public void btSend(String msg) {
        String name = getUsername().getText();
        if (!isStatus()) {
            chatHistoryArea.append(msg + "\n");
        } else {
            String userMessage = messageField.getText();
            saveToFile(CHAT_HISTORY_FILE, userMessage);
            for (int i = 0; i < serverGUI.getClientGUIList().size(); i++) {
                serverGUI.getClientGUIList().get(i).chatHistoryArea.append(name + "\n" + userMessage + "\n");
            }
//            serverGUI.getClientGUI().chatHistoryArea.append(name + "\n" + userMessage + "\n");
//            serverGUI.getClientGUI2().chatHistoryArea.append(name + "\n" + userMessage + "\n");
//            chatHistoryArea.append(name + "\n" + userMessage + "\n");
            serverGUI.getMessageHistory().append(name + "\n" + userMessage + "\n");
            messageField.setText("");
        }
    }

    public JTextField getUsername() {
        return username;
    }

    @Override
    public void windowData() {
        setSize(InterfaceForForm.WIDTH, InterfaceForForm.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(83, 100);
    }

    @Override
    public void positionButtons() {
        buttonLogin.addActionListener(this);
        buttonSend.addActionListener(this);
        panelSouth.add(buttonSend, BorderLayout.EAST);
    }

    @Override
    public void positionTextField() {
        messageField.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane(chatHistoryArea);
        panelCenter.add(scrollPane);
        panelSouth.add(messageField);

        panelWithData.add(serverIpAddresses);
        panelWithData.add(serverConnectionPort);
        panelWithData.add(username);
        panelWithData.add(password);

        panelNorth.add(panelWithData);
        panelNorth.add(buttonLogin, BorderLayout.EAST);

        add(panelCenter);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelNorth, BorderLayout.NORTH);
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}


