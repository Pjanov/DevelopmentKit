package pjanov.homework.hw2.app;

import pjanov.homework.hw2.client.form.ClientWindow;
import pjanov.homework.hw2.service.form.ServiceWindow;

public class ApplicationClientService {
    private ClientWindow[] clientWindows;
    private ServiceWindow serviceWindow;

    public ApplicationClientService() {
        serviceWindow = new ServiceWindow();
        clientWindows = new ClientWindow[2];

        for (int i = 0; i < clientWindows.length; i++) {
            clientWindows[i] = new ClientWindow();
        }

        clientWindows[0].getMyForm().setLocation(70, 250);
        clientWindows[1].getMyForm().setLocation(900, 250);
        getServiceWindow();


    }

    public ClientWindow[] getClientWindows() {
        return clientWindows;
    }

    public ServiceWindow getServiceWindow() {
        return serviceWindow;
    }
}
