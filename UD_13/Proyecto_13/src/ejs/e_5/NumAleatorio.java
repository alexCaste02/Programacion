package ejs.e_5;

import javax.swing.*;
import java.awt.*;
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
        generarButton.addActionListener(e -> resLabel.setText(ThreadLocalRandom.current().nextInt(maxSlider.getValue()+1)+""));
        maxSlider.addChangeListener(e -> sliderLabel.setText(maxSlider.getValue()+""));
    }
}
