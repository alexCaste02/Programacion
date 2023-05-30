package ej_CRUD;

import javax.swing.*;

public class paisesGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel topSplit;
    private JPanel paisPanel;
    private JTable table;
    private JScrollPane tableScroll;

    public static paisesGUI start(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}
        return new paisesGUI();
    }

    public paisesGUI() {
        setContentPane(mainPanel);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        pack();
    }
}
