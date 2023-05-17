package ejs.e_3;


import javax.swing.*;
import java.awt.*;

public class MiniCalc_II extends JFrame{

    private JPanel mainPanel;
    private JTextField numATextField;
    private JTextField numBTextField;
    private JLabel resultadoLabel;
    private JRadioButton sumRB;
    private JRadioButton prodRB;
    private JRadioButton expRB;
    private JButton calcBoton;
    private JPanel topHalf;
    private JPanel topLeft;
    private JPanel topMid;
    private JPanel topRight;
    private JPanel botHalf;

    public static void main(String[] args) {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception ignored){}
        EventQueue.invokeLater(MiniCalc_II::start);
    }

    public static void start(){
        MiniCalc_II calc = new MiniCalc_II("calc v2 - Alex.C.D");
    }

    public MiniCalc_II(String titulo) throws HeadlessException {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Agrupamos los radioButton para poder
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(sumRB);
        grupo.add(prodRB);
        grupo.add(expRB);

        calcBoton.addActionListener(e -> {
            int a = Integer.parseInt(numATextField.getText());
            int b = Integer.parseInt(numBTextField.getText());
            double r=0;

            if(sumRB.isSelected()){
                for (int i = a; i <= b; i++) {
                    r+=i;
                }
            } else if (prodRB.isSelected()) {
                r=1;
                for (int i = a; i <= b; i++) {
                    r*=i;
                }
            } else if (expRB.isSelected()) {
                r=Math.pow(a,b);
            }

            resultadoLabel.setText(r+"");
        });
    }




}
