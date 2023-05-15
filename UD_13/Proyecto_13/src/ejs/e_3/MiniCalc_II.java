package ejs.e_3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        start();
    }

    public static void start(){
        MiniCalc_II calc = new MiniCalc_II("calc v2 - Alex.C.D");
    }

    public MiniCalc_II(String titulo) throws HeadlessException {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(sumRB);
        grupo.add(prodRB);
        grupo.add(expRB);

        // NO SABIA QUE EXISTIAN LOS GRUPOS AAAAAAAAAAAAAAAA
//        sumRB.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(sumRB.isSelected()){
//                    prodRB.setSelected(false);
//                    expRB.setSelected(false);
//                }
//            }
//        });
//
//        prodRB.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(prodRB.isSelected()){
//                    sumRB.setSelected(false);
//                    expRB.setSelected(false);
//                }
//            }
//        });
//
//        expRB.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(expRB.isSelected()){
//                    prodRB.setSelected(false);
//                    sumRB.setSelected(false);
//                }
//            }
//        });

        calcBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
    }




}
