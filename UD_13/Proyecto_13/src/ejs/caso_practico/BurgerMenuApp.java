package ejs.caso_practico;

import ejs.e_10.MiniEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BurgerMenuApp extends JFrame {

    private JPanel mainPanel;
    private JLabel Titulo;
    private JPanel topPanel;
    private JRadioButton cervezaRadioButton;
    private JRadioButton aguaRadioButton;
    private JRadioButton colaRadioButton;
    private JRadioButton limonRadioButton;
    private JRadioButton naranjaRadioButton;
    private JRadioButton polloRadioButton;
    private JPanel midSupPanel;
    private JPanel midInfPanel;
    private JPanel botPanel;
    private JPanel bebidaPanel;
    private JPanel hamPanel;
    private JCheckBox hamburgesaDobleCheckBox;
    private JCheckBox extraDePatatasCheckBox;
    private JPanel extraPanel;
    private JPanel panPanel;
    private JPanel patatasPanel;
    private JRadioButton repartoADomicilioRadioButton;
    private JButton calcButton;
    private JTextField precioTextF;
    private JRadioButton cerdoRadioButton;
    private JRadioButton terneraRadioButton;
    private JRadioButton veganaRadioButton;
    private JRadioButton normalRadioButton;
    private JRadioButton integralRadioButton;
    private JSpinner ketchupSpinner;
    private JSpinner mostazaSpinner;
    private JRadioButton centenoRadioButton;
    private JRadioButton fritasRadioButton;
    private JRadioButton caserasRadioButton;
    private JRadioButton gajoRadioButton;
    private JCheckBox extraDeQuesoCheckBox;
    private JSpinner bbqSpinner;
    private JPanel salsasPanel;
    private JSpinner thaiSpinner;
    private JRadioButton recogidaEnLocalRadioButton;
    private JTextField ivaTextF;
    private JTextField pvpTextF;
    private JPanel resPanel;
    private ButtonGroup hamGroup = new ButtonGroup();
    private ButtonGroup panGroup = new ButtonGroup();
    private ButtonGroup patGroup = new ButtonGroup();
    private ButtonGroup bebGroup = new ButtonGroup();
    private ButtonGroup reGroup = new ButtonGroup();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        EventQueue.invokeLater(BurgerMenuApp::start);
    }

    static void start() {
        BurgerMenuApp win = new BurgerMenuApp("MiniEditor - Alex.C.D");
    }

    public BurgerMenuApp(String titulo) {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();


        hamGroup.add(polloRadioButton);
        hamGroup.add(cerdoRadioButton);
        hamGroup.add(terneraRadioButton);
        hamGroup.add(veganaRadioButton);

        panGroup.add(normalRadioButton);
        panGroup.add(integralRadioButton);
        panGroup.add(centenoRadioButton);


        patGroup.add(fritasRadioButton);
        patGroup.add(gajoRadioButton);
        patGroup.add(caserasRadioButton);


        bebGroup.add(colaRadioButton);
        bebGroup.add(naranjaRadioButton);
        bebGroup.add(limonRadioButton);
        bebGroup.add(aguaRadioButton);
        bebGroup.add(cervezaRadioButton);


        reGroup.add(repartoADomicilioRadioButton);
        reGroup.add(recogidaEnLocalRadioButton);

        calcButton.addActionListener(e -> {
            precioTextF.setText(String.format("%.2f €", calcularPrecio()));
            ivaTextF.setText(String.format("%.2f €", calcularIVA()));
            pvpTextF.setText(String.format("%.2f €", calcularPVP()));
        });
    }

    private double calcularPrecio() {
        double t = 8;
        if (terneraRadioButton.isSelected() || veganaRadioButton.isSelected()) t += 1;
        if (caserasRadioButton.isSelected()) t += 1;
        if (hamburgesaDobleCheckBox.isSelected()) t += 2;
        if (extraDeQuesoCheckBox.isSelected()) t += 0.5;
        if (extraDePatatasCheckBox.isSelected()) t += 1;
        t += (((int) ketchupSpinner.getValue())
                + ((int) mostazaSpinner.getValue())
                + ((int) bbqSpinner.getValue())
                + ((int) thaiSpinner.getValue())
        ) * 0.5;

        if (recogidaEnLocalRadioButton.isSelected()) t -= t * 0.2;

        return t;
    }

    private double calcularIVA() {
        double p = calcularPrecio();
        return p * 0.21;
    }

    private double calcularPVP() {
        double p = calcularPrecio();
        double iva = calcularIVA();
        return p + iva;
    }


}
