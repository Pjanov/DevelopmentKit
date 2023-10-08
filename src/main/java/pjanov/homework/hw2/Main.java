package pjanov.homework.hw2;

import pjanov.homework.hw2.client.ClientGUI;
import pjanov.homework.hw2.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI("Server");
        new ClientGUI(serverGUI, "Client");
        new ClientGUI(serverGUI, "Client").setLocation(883, 100);
    }
}
