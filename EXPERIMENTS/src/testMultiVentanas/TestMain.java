package testMultiVentanas;

import javax.swing.*;
import java.awt.*;

public class TestMain extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(TestMain::start);
    }

    private static void start(){
        new TestMain();
    }

    public TestMain() throws HeadlessException {
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new VentanA(this).panel1;
        setContentPane(panel);
    }


}

