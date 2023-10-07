package pjanov.homework.hw3;

import pjanov.homework.hw3.client.ClientGUI;
import pjanov.homework.hw3.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        new ServerGUI("Server");
        new ClientGUI("Client");
        new ClientGUI("Client").setLocation(883, 164);
    }
}
