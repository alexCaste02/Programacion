package ejs.e_1;

import javax.swing.*;
import java.awt.*;

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
        //Con esto cambiamos el "Look and Feel" para que la ventana tenga estilo del sistema (windows 11 en este caso)
        // en vez de la de java. Cambia botones, bordes o cosas del estilo. Puramente estetico
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception ignored){}
        //Llamada al metodo iniciador a traves de una interfaz funcional
        EventQueue.invokeLater(ParImpar::start);
    }

    //Metodo iniciador por si fuera necesario reiniciar la ventana
    static void start(){
        ParImpar win = new ParImpar("Par o impar - Alex.C.D");
    }

    public ParImpar(String title) {
        super(title);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Creo que esta por default esto, pero hacemos el set igualmente
        pack();
        setLocationRelativeTo(null);//Aparece la ventana en el centro de la pantalla al colocarse relativa a "null"

        //Añadimos un listener al boton que ejecute el codigo siguiente en caso de ser pulsado
        calcButton.addActionListener(e -> {
            //Comprobamos que es un n entero
            if(numeroTextField.getText().matches("\\d*")){
                if(esPar(Integer.parseInt(numeroTextField.getText()))) {
                    resultLabel.setText("PAR");
                    resultLabel.setForeground(Color.CYAN);
                } else {
                    resultLabel.setText("IMPAR");
                    resultLabel.setForeground(Color.GREEN);
                }

            //Mostramos mensaje de error y limpiamos el campo de texto
            } else {
                JPanel alerta = new JPanel();
                JOptionPane.showMessageDialog(alerta,"Debes introducir un numero entero","Valor invalido",JOptionPane.ERROR_MESSAGE);
                resultLabel.setText("");
                numeroTextField.setText("");
            }

        });
    }

    public static boolean esPar(int n){
        return n % 2 == 0;
    }


}
