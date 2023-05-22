package T13_Proyecto3;

import javax.swing.*;
import java.awt.*;

public class Semaforo extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Semaforo();
        });
    }

    public Semaforo() throws HeadlessException {
        setContentPane(new Lamina());
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class Lamina extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);








        }
    }

}
