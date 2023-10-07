package pjanov.homework.hw2.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientGUI extends JFrame implements ActionListener {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private JPanel panelSouth = new JPanel(new BorderLayout());
    private JPanel panelCenter = new JPanel(new BorderLayout());
    private JPanel panelNorth = new JPanel(new BorderLayout());
    private JPanel panelWithData = new JPanel(new GridLayout(2, 2));
    private JButton buttonSend = new JButton("Send");
    private JTextField messageField = new JTextField();
    private JTextArea chatHistoryArea = new JTextArea();
    private final JTextField serverIpAddresses = new JTextField("127.0.0.1", 10);
    private final JTextField serverConnectionPort = new JTextField("8189");
    private final JTextField username = new JTextField("Введите своё имя");
    private final JPasswordField password = new JPasswordField("123456789");
    private final JButton buttonLogin = new JButton("Ok");
    private final String chatHistoryFile = "chat_history.txt"; // Имя файла истории чата

    public ClientGUI(String title) throws HeadlessException {
        super(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(83, 100);

        buttonLogin.addActionListener(this);
        buttonSend.addActionListener(this);
        messageField.addActionListener(this);

        panelSouth.add(buttonSend, BorderLayout.EAST);
        panelSouth.add(messageField);

        JScrollPane scrollPane = new JScrollPane(chatHistoryArea);
        panelCenter.add(scrollPane);

        panelWithData.add(serverIpAddresses);
        panelWithData.add(serverConnectionPort);
        panelWithData.add(username);
        panelWithData.add(password);

        panelNorth.add(panelWithData);
        panelNorth.add(buttonLogin, BorderLayout.EAST);

        add(panelCenter);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelNorth, BorderLayout.NORTH);

        restoreChatHistory(); // Восстановление истории чата при запуске клиента

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSend || e.getSource() == messageField) {
            String message = messageField.getText();
            addToChatHistory(message); // Добавление сообщения в историю чата

            // Отправка сообщения на сервер
            sendMessageToServer(message);

            messageField.setText(""); // Очистка поля ввода сообщения
        } else if (e.getSource() == buttonLogin) {
            // Логика для подключения к серверу
            // ...
        }
    }

    private void addToChatHistory(String message) {
        chatHistoryArea.append(message + "\n");
        saveChatHistory(); // Сохранение истории чата в файл
    }

    private void saveChatHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(chatHistoryFile))) {
            writer.write(chatHistoryArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void restoreChatHistory() {
        if (Files.exists(Paths.get(chatHistoryFile))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chatHistoryFile))) {
                String line;
                StringBuilder chatHistory = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    chatHistory.append(line).append("\n");
                }
                chatHistoryArea.setText(chatHistory.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessageToServer(String message) {
        // Логика отправки сообщения на сервер
        // ...
    }
}


