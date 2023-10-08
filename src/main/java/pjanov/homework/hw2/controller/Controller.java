package pjanov.homework.hw2.controller;

import pjanov.homework.hw2.client.ClientGUI;
import pjanov.homework.hw2.server.ServerGUI;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ServerGUI serverGUI;
    private List<ClientGUI> clientGUIList;

    public Controller(ServerGUI serverGUI, List<ClientGUI> clientGUIList) {
        this.serverGUI = serverGUI;
        this.clientGUIList = clientGUIList;
    }



    public static void main(String[] args) {
        ServerGUI serverGUI1 = new ServerGUI("serverGUI");
        ClientGUI clientGUI1 = new ClientGUI(serverGUI1, "clientGUI1");
        ClientGUI clientGUI2 = new ClientGUI(serverGUI1, "clientGUI2");
        clientGUI2.setLocation(883, 100);
        List<ClientGUI> clientGUIList1 = new ArrayList<>();

        clientGUIList1.add(clientGUI1);
        clientGUIList1.add(clientGUI2);

        new Controller(serverGUI1, clientGUIList1);
    }
}
