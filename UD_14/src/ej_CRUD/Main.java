package ej_CRUD;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = paisesGUI.start();
        EventQueue.invokeLater(paisesGUI::start);
    }
}
