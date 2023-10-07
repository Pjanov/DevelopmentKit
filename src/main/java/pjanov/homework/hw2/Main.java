package pjanov.homework.hw2;


import pjanov.homework.hw2.client.form.ClientWindow;
import pjanov.homework.hw2.server.form.ServerWindow;

public class Main {
    public static void main(String[] args) {
        new ServerWindow();
        new ClientWindow().getMyForm().setLocation(70, 250);
        new ClientWindow().getMyForm().setLocation(900, 250);
    }
}
