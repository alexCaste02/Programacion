package T13_Proyecto1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FormColores extends JFrame{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FormColores ventana = new FormColores();
//                    ventana.setBounds(100,100,500,400);
                    ventana.setContentPane(ventana.panelPrincipal);
                    ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                    ventana.pack();
                    ventana.setVisible(true);



                    ventana.redSlider.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            String hex = Integer.toHexString(ventana.redSlider.getValue());
                            if(hex.length()<2) hex="0"+hex;
                            
                            ventana.redLabel.setText(""+ Math.round(ventana.redSlider.getValue()*2.55));

                            ventana.hexLabel.setText("#"+hex+ventana.hexLabel.getText().substring(3));
                        }
                    });

                    ventana.greenSlider.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            ventana.greenLabel.setText(""+ Math.round(ventana.greenSlider.getValue()*2.55));
                        }
                    });

                    ventana.blueSlider.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            ventana.blueLabel.setText(""+ Math.round(ventana.blueSlider.getValue()*2.55));
                        }
                    });




                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    private JPanel panelPrincipal;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;
    private JLabel redLabel;
    private JLabel greenLabel;
    private JLabel blueLabel;
    private JLabel hexLabel;
    private JTextPane RedValue;
}
