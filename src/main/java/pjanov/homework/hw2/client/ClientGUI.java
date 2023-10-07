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

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            chatHistoryArea.setText(username.getText() + " подсоединился к серверу ..." + "\n");
        } else if (e.getSource() == buttonSend) {
            sendMessage();
        }
    }

    /**
     * Отправить сообщение
     */
    private void sendMessage() {
        String message = username.getText() + "\n" + messageField.getText();
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

    /**
     * Получить текст из файла
     *
     * @param filePath путь к файлу
     * @return текст
     */
    public String getTextFromFile(String filePath) {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


}
