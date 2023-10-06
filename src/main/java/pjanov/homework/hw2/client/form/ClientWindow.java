package pjanov.homework.hw2.client.form;


public class ClientWindow {
    private MainPanel mainPanel;
    private MyForm myForm;

    public ClientWindow() {
        mainPanel = new MainPanel();
        myForm = new MyForm("Client");

        myForm.add(mainPanel);

        myForm.setVisible(true);
    }
}
