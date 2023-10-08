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
    private ServerGUI serverGUI;
    private JPanel panelSouth = new JPanel(new BorderLayout());
    private JPanel panelCenter = new JPanel(new BorderLayout());
    private JPanel panelNorth = new JPanel(new BorderLayout());
    private JPanel panelWithData = new JPanel(new GridLayout(2, 2));
    private JButton buttonSend = new JButton("Send");
    private JTextField messageField = new JTextField();
    private JTextArea chatHistoryArea = new JTextArea();
    private final JTextField serverIpAddresses = new JTextField("127.0.0.1", 10);
    private final JTextField serverConnectionPort = new JTextField("8189");
    private JTextField username = new JTextField("Введите своё имя");
    private final JPasswordField password = new JPasswordField("123456789");
    private final JButton buttonLogin = new JButton("Ok");
    private final String CHAT_HISTORY_FILE = "chat_history.txt";

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

    public String getMessageFieldData() {
        return messageField.getText();
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
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text + System.lineSeparator());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ошибка: " + e.getMessage(),
                    "Ошибка отправления сообщения", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btLogin(String msg) {

        if (serverGUI.isStatus()) {
            String name = getUsername().getText();
            if (name.equals("Введите своё имя")) {
                chatHistoryArea.append(msg + "\n");
            } else {
                getUsername().setForeground(Color.GREEN);
                chatHistoryArea.append(name + " вы авторизованы" + "\n");
                chatHistoryArea.append(readFromFile(CHAT_HISTORY_FILE));
            }
        } else {
            chatHistoryArea.append("Необходимо запустить сервер!" + "\n");
        }
    }

    public void btSend(String msg) {
        String name = getUsername().getText();
        if (name.equals("Введите своё имя")) {
            chatHistoryArea.append(msg + "\n");
        } else {
            saveToFile(CHAT_HISTORY_FILE, getMessageFieldData());
            chatHistoryArea.append(messageField.getText() + "\n");
            serverGUI.getMessageHistory().append(messageField.getText() + "\n");
            messageField.setText("");
        }
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
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
}


