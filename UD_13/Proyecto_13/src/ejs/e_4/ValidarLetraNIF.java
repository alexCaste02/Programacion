package ejs.e_4;

import ejs.e_9.InicioSesion;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

public class ValidarLetraNIF extends JFrame {
    private JPanel mainPanel;
    private JPanel topHalf;
    private JPanel botHalf;
    private JLabel infoLabel;
    private JFormattedTextField nifTextField;
    private JLabel resLabel;
    private JButton comprobarButton;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        EventQueue.invokeLater(ValidarLetraNIF::start);
    }
    static void start() {
        ValidarLetraNIF window = new ValidarLetraNIF("Validar NIF - Alex.C.D");
    }

    public ValidarLetraNIF(String titulo) throws HeadlessException {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);

        MaskFormatter mf = null;
        try {
            mf = new MaskFormatter("########-U");
            mf.setPlaceholderCharacter('X');
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        nifTextField.setFormatterFactory(new DefaultFormatterFactory(mf));

        comprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif = nifTextField.getText();
                int nifNum = Integer.parseInt(nif.substring(0, 8));
                String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

                if (letras.charAt(nifNum % 23) == nif.charAt(nif.length() - 1)) {
                    resLabel.setText("VALIDO");
                } else {
                    resLabel.setText("INVALIDO");
                }
            }
        });
    }
}