package pjanov.homework.hw2.init;

import pjanov.homework.hw2.client.ClientGUI;
import pjanov.homework.hw2.server.ServerGUI;

import java.util.ArrayList;
import java.util.List;

public class Init {
    private ServerGUI serverGUI;
    private List<ClientGUI> clientGUIList;
    private ClientGUI clientGUI1;
    private ClientGUI clientGUI2;

    public Init() {
        serverGUI = new ServerGUI("serverGUI");
        clientGUI1 = new ClientGUI(serverGUI, "clientGUI1");
        clientGUI2 = new ClientGUI(serverGUI, "clientGUI2");
        clientGUI2.setLocation(883, 100);
        clientGUIList = new ArrayList<>();

        clientGUIList.add(clientGUI1);
        clientGUIList.add(clientGUI2);
    }
}
