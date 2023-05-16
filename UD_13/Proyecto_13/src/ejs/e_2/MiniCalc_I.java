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
    private JPanel topLeft;
    private JPanel topMid;
    private JTextField numBTextField;
    private JPanel topRight;
    private JLabel resultadoLabel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        EventQueue.invokeLater(MiniCalc_I::start);
    }

    public static void start(){
        MiniCalc_I calc = new MiniCalc_I("calc v1 - Alex.C.D");
    }

    public MiniCalc_I(String titulo) throws HeadlessException {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sumaBoton.addActionListener(new calcularListener());
        restaBoton.addActionListener(new calcularListener());
        multiBoton.addActionListener(new calcularListener());
        diviBoton.addActionListener(new calcularListener());

        //podemos hacer lo mismo 4 veces y ya
//        sumaBoton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                double a = Integer.parseInt(numATextField.getText());
//                double b = Integer.parseInt(numBTextField.getText());
//                resultadoLabel.setText(String.valueOf(a + b));
//            }
//        });
    }

    class calcularListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            double a = Double.parseDouble(numATextField.getText());
            double b = Double.parseDouble(numBTextField.getText());
            double r;

            if (e.getSource() == sumaBoton) {
                r = a + b;
            } else if (e.getSource() == restaBoton) {
                r = a - b;
            } else if (e.getSource() == multiBoton) {
                r = a * b;
            } else {
                r = a / b;
            }

            resultadoLabel.setText(r+"");
        }
    }


}
