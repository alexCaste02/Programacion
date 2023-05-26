package testMultiVentanas;

import javax.swing.*;

public class VentanA {
    JPanel panel1;
    private JButton cambiarButton;
    JFrame ventana;

    public VentanA(JFrame parentWindow) {
        ventana=parentWindow;
        cambiarButton.addActionListener(e -> {
            ventana.setContentPane(new VentanB().panel1);
//            ventana.pack();
            ventana.setVisible(true);
        });

    }

}
