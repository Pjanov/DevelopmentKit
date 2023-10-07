package pjanov.homework.hw2.client.form;


public class ClientWindow {
    private final MainPanel mainPanel = new MainPanel();
    private final MyForm myForm = new MyForm("Client");

    public ClientWindow() {
        myForm.add(mainPanel);
        myForm.setVisible(true);
    }

    public MyForm getMyForm() {
        return myForm;
    }
}
