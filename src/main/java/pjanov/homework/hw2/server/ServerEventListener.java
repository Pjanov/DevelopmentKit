package pjanov.homework.hw2.server;

public interface ServerEventListener {
    void onServerStarted();
    void onServerStopped();
    void onClientConnected(String clientName);
    void onClientDisconnected(String clientName);
    void onMessageReceived(String clientName, String message);
    // Другие методы для обработки событий от сервера
}

