package pjanov.homework.test.client.form;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientWindow implements ActionListener {
    private final MainPanel mainPanel = new MainPanel();
    private final MyForm myForm = new MyForm("Client");

    public ClientWindow() {
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
        if (e.getSource() == getButtonSend()) {
            sendMessage();
        }
    }

    public JButton getButtonSend() {
        return mainPanel.getSouthPanel().getButtonSend();
    }

    /**
     * Отправить сообщение
     */
    private void sendMessage() {
        String message = mainPanel.getCenterPanel().getMessageHistory().getText();
        mainPanel.getCenterPanel().getMessageHistory().append(message + "\n");
        saveChatHistoryToFile(message + "\n");
        mainPanel.getCenterPanel().getMessageHistory().setText("");
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
                    mainPanel.getCenterPanel().getMessageHistory().append(line + "\n");
                }
                bufferedReader.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
