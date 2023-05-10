package Pruebas;

import javax.swing.*;
import java.awt.*;

public class Epilepsia extends JFrame {

    public Epilepsia(String cadena){
        super(cadena);
        setBounds(100,100,500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0));

        this.setContentPane(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Epilepsia frame = new Epilepsia("color");
                frame.setVisible(true);


            }
        });
    }
}
