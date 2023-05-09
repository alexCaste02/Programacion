package Fisicas;

import javax.swing.*;
import java.awt.*;



public class Astro extends JFrame{

    public Astro(String cadena){
        super(cadena);
        setBounds(100,100,500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0,0,0));

        this.setContentPane(panel);
    }


}
