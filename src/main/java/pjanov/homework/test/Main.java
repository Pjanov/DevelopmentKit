package pjanov.homework.test;


import pjanov.homework.test.client.form.ClientWindow;
import pjanov.homework.test.server.window.ServerWindow;

public class Main {
    public static void main(String[] args) {
        new ServerWindow();
        new ClientWindow().getMyForm().setLocation(70, 250);
        new ClientWindow().getMyForm().setLocation(900, 250);
    }
}
