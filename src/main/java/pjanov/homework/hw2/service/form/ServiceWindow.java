package pjanov.homework.hw2.service.form;

import pjanov.homework.hw2.client.form.MyForm;

public class ServiceWindow {
    private final MyForm myForm = new MyForm("Serves");
    private final MainPanel mainPanel = new MainPanel();

    public ServiceWindow() {
        myForm.add(mainPanel);
        myForm.setVisible(true);
    }

    public MyForm getMyForm() {
        return myForm;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
