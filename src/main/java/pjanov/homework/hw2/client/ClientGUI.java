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

    /**
     * Прочитать текст из файла
     *
     * @param fileName путь к файлу
     * @return текст
     */
    public String readFromFile(String fileName) {
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

    /**
     * Сохранить текст в файл
     *
     * @param fileName путь к файлу
     * @param text     текст
     */
    public void saveToFile(String fileName, String text) {
        String userMessage = getUsername().getText();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(userMessage + "\n" + text + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ошибка: " + e.getMessage(),
                    "Ошибка отправления сообщения", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Действие при нажатии на кнопку Login
     *
     * @param msg сообщение
     */
    public void btLogin(String msg) {
        String name = getUsername().getText();
        if (serverGUI.isStatus()) {
            if (name.equals("Введите своё имя")) {
                setStatus(false);
                addMessage(msg + "\n");
            } else {
                setStatus(true);
                setTitle(name);
                getUsername().setForeground(Color.GREEN);
                addMessage(name + " вы авторизованы" + "\n");
                addMessage(readFromFile(CHAT_HISTORY_FILE));
                serverGUI.getClientGUIList().add(this);
            }
        } else {
            addMessage("Необходимо запустить сервер!" + "\n");
            setStatus(false);
        }
    }

    /**
     * Действие при нажатии на кнопку Send
     *
     * @param msg сообщение
     */
    public void btSend(String msg) {
        String name = getUsername().getText();
        if (!isStatus()) {
            addMessage(msg + "\n");
        } else {
            String userMessage = messageField.getText();
            saveToFile(CHAT_HISTORY_FILE, userMessage);
            serverGUI.sendMessageFromServerToClient(name + "\n" + userMessage + "\n");
            serverGUI.addMessage(name + "\n" + userMessage + "\n");
            messageField.setText("");
        }
    }

    public JTextField getUsername() {
        return username;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSend) {
            btSend("С начало авторизуйтесь!!!");
        } else if (e.getSource() == buttonLogin) {
            btLogin("Вы не авторизованы!!!");
            addMessage("");
        }
    }

    @Override
    public void addMessage(String msg) {
        chatHistoryArea.append(msg);
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
}
