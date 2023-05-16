package ejs.caso_practico;

import ejs.e_10.MiniEditor;

import javax.swing.*;
import java.awt.*;

public class BurgerMenuApp extends JFrame{

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


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        EventQueue.invokeLater(BurgerMenuApp::start);
    }

    static void start() {
        MiniEditor win = new MiniEditor("MiniEditor - Alex.C.D");
    }

    public BurgerMenuApp(String titulo) {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();


    }
}
