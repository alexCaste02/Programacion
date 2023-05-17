package ejs.e_8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class TablasMultiplicar extends JFrame {

    private JPanel mainPanel;
    private JTable tablaMulti;
    private JLabel titleLabel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        EventQueue.invokeLater(TablasMultiplicar::start);
    }

    static void start(){
        TablasMultiplicar win = new TablasMultiplicar();
    }

    public TablasMultiplicar() throws HeadlessException {
        setVisible(true);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Integer[][] array10 = new Integer[10][10];
        String[] a = new String[10];
        for (int i = 0; i < 10; i++) {
            a[i] = ""+i+1;
            for (int j = 0; j < 10; j++) {
                array10[i][j] = (i+1) * (j+1);
            }
        }

        TableModel tm = new DefaultTableModel(array10,a);
        tablaMulti.setModel(tm);

        setSize(350,350);

        //TODO: EXTRA
    }

}