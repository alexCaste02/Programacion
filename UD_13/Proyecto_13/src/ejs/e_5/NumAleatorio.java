package ejs.e_5;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class NumAleatorio extends JFrame{
    private JPanel mainPanel;
    private JSlider maxSlider;
    private JButton generarButton;
    private JLabel resLabel;
    private JLabel sliderLabel;

    public static void main(String[] args) {
        start();
    }

    static void start(){
        NumAleatorio window = new NumAleatorio("Random - Alex.C.D");
    }

    public NumAleatorio(String titulo) throws HeadlessException {
        super(titulo);
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resLabel.setText(ThreadLocalRandom.current().nextInt(maxSlider.getValue())+"");
            }
        });
        maxSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderLabel.setText(maxSlider.getValue()+"");
            }
        });
    }
}
