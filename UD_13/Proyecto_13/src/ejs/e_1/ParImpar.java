package ejs.e_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParImpar extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel botPanel;
    private JLabel title;
    private JLabel introLabel;
    private JLabel resultLabel;
    private JLabel infoLabel;
    private JTextField numeroTextField;
    private JButton calcButton;

    public static void main(String[] args) {
        start();
    }

    static void start(){
        ParImpar window = new ParImpar("Par o impar");
    }

    public ParImpar(String title) {
        super(title);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450,300);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);


        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numeroTextField.getText().matches("[1-9]*")){
                    if(esPar(Integer.parseInt(numeroTextField.getText()))) {
                        resultLabel.setText("PAR");
                        resultLabel.setForeground(Color.CYAN);
                    } else {
                        resultLabel.setText("IMPAR");
                        resultLabel.setForeground(Color.GREEN);
                    }
                } else {
                    JPanel alerta = new JPanel();
                    JOptionPane.showMessageDialog(alerta,"Debes introducir un numero","Valor invalido",JOptionPane.ERROR_MESSAGE);
                    resultLabel.setText("");
                    numeroTextField.setText("");
                }


            }
        });
    }

    public static boolean esPar(int n){
        return n % 2 == 0;
    }


}
