package pjanov.homework.hw2.interfaceForm;

public interface InterfaceForForm {
    int WIDTH = 400, HEIGHT = 400;

    void windowData();

    void positionButtons();

    void positionTextField();

    boolean isStatus();

    void addMessage(String msg);
}
