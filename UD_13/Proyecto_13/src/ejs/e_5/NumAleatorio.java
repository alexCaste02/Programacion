package ejs.e_5;

import ejs.e_9.InicioSesion;

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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        EventQueue.invokeLater(NumAleatorio::start);
    }

    static void start(){
        NumAleatorio win = new NumAleatorio("");
    }

    public NumAleatorio(String titulo) throws HeadlessException {
        super(titulo);
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        generarButton.addActionListener(e -> resLabel.setText(ThreadLocalRandom.current().nextInt(maxSlider.getValue())+""));
        maxSlider.addChangeListener(e -> sliderLabel.setText(maxSlider.getValue()+""));
    }
}