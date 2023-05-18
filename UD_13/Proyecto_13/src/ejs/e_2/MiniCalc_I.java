package ejs.e_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniCalc_I extends JFrame{

    private JPanel mainPanel;
    private JPanel topHalf;
    private JPanel botHalf;
    private JTextField numATextField;
    private JButton sumaBoton;
    private JButton restaBoton;
    private JButton multiBoton;
    private JButton diviBoton;
    private JPanel topMid;
    private JTextField numBTextField;
    private JLabel resultadoLabel;
    private JLabel title;

    public static void main(String[] args) {
        //Cambio del "Look and Feel"
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception ignored){}
        //Llamada a iniciador
        EventQueue.invokeLater(MiniCalc_I::start);
    }

    public static void start(){
        MiniCalc_I calc = new MiniCalc_I("calc v1 - Alex.C.D");
    }

    public MiniCalc_I(String titulo) throws HeadlessException {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        //añadimos un objeto actionlistener de nuestra clase custom a cada boton
        sumaBoton.addActionListener(new calcularListener());
        restaBoton.addActionListener(new calcularListener());
        multiBoton.addActionListener(new calcularListener());
        diviBoton.addActionListener(new calcularListener());
    }

    //Clase que implementa ActionListener
    class calcularListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textoA = numATextField.getText();
            String textoB = numBTextField.getText();

            //Comprueba que el contenido de los campos son numeros reales
            if(textoA.matches("\\d*([.]\\d*)?") && textoB.matches("\\d*([.]\\d*)?")) {
                double a = Double.parseDouble(textoA);
                double b = Double.parseDouble(textoB);
                double r;

                //A traves de 'e.getSource()' podemos ver que boton ha sido la fuente de la accion
                // y con eso podemos realizar calculos diferentes a partir del boton pulsado
                if (e.getSource() == sumaBoton) {
                    r = a + b;
                } else if (e.getSource() == restaBoton) {
                    r = a - b;
                } else if (e.getSource() == multiBoton) {
                    r = a * b;
                } else {
                    r = a / b;
                }

                resultadoLabel.setText(r + "");

            //Mensaje de error si no tiene valores valido
            } else {
                JPanel alerta = new JPanel();
                JOptionPane.showMessageDialog(alerta,"Debes introducir un numero","Valor invalido",JOptionPane.ERROR_MESSAGE);
                numATextField.setText("");
                numBTextField.setText("");
            }
        }
    }


}
