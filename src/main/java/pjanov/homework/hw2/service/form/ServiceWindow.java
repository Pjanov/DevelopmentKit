package pjanov.homework.hw2.service.form;

import pjanov.homework.hw2.client.form.MyForm;

public class ServiceWindow {
    private MyForm myForm;
    private MainPanel mainPanel;

    public ServiceWindow() {
        myForm = new MyForm("Servis");
        mainPanel = new MainPanel();

        myForm.add(mainPanel);

        myForm.setVisible(true);
    }
}
