package pjanov.homework.hw1;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MessengerGUI extends JFrame {
    private JTextField messageField;
    private JTextArea chatHistoryArea;
    private int WIDTH = 400;
    private int HEIGHT = 400;

    public MessengerGUI() {
        setTitle("Месседжер");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        messageField = new JTextField();
        JButton sendButton = new JButton("Отправить");
        chatHistoryArea = new JTextArea();

        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());

        add(messageField, BorderLayout.NORTH);
        add(new JScrollPane(chatHistoryArea), BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);

        loadChatHistoryFromFile();

        setVisible(true);
    }

    /**
     * Отправить сообщение
     */
    private void sendMessage() {
        String message = messageField.getText();
        chatHistoryArea.append(message + "\n");
        saveChatHistoryToFile(message + "\n");
        messageField.setText("");
    }

    /**
     * Сохранить историю в файл
     *
     * @param message сообщение
     */
    private void saveChatHistoryToFile(String message) {
        try {
            FileWriter writer = new FileWriter("chat_history.txt", true);
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Загрузить историю из файла
     */
    private void loadChatHistoryFromFile() {
        try {
            File file = new File("chat_history.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    chatHistoryArea.append(line + "\n");
                }
                bufferedReader.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
