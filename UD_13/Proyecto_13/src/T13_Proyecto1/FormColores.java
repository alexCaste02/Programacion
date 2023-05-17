package T13_Proyecto1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormColores extends JFrame{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FormColores ventana = new FormColores("Alejandro Castellanos - Selector de colores");
//                    ventana.setBounds(100,100,500,400);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public FormColores(String title) throws HeadlessException {
        super(title);

        setContentPane(panelPrincipal);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        colorPanel.setBackground(Color.BLACK);
        pack();
        setVisible(true);



        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redTF.setText(""+redSlider.getValue());
                setHex();
                colorPanel.setBackground(new Color(
                        redSlider.getValue(),
                        greenSlider.getValue(),
                        blueSlider.getValue()
                        ));
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenTF.setText(""+greenSlider.getValue());
                setHex();
                colorPanel.setBackground(new Color(
                        redSlider.getValue(),
                        greenSlider.getValue(),
                        blueSlider.getValue()
                ));
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueTF.setText(""+blueSlider.getValue());
                setHex();
                colorPanel.setBackground(new Color(
                        redSlider.getValue(),
                        greenSlider.getValue(),
                        blueSlider.getValue()
                ));
            }
        });


        redTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                try{
                    redSlider.setValue(Integer.parseInt(redTF.getText()));
                } catch (NumberFormatException ex){
                    redSlider.setValue(255);
                }

            }
        });
    }

    private void setHex(){
        hexLabel.setText(String.format(
                "#%02X%02X%02X",
                redSlider.getValue(),
                greenSlider.getValue(),
                blueSlider.getValue())
        );

    }

    private JPanel panelPrincipal;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    private JLabel hexLabel;
    private JPanel colorPanel;
    private JTextField redTF;
    private JTextField greenTF;
    private JTextField blueTF;


}
