package ejs.e_8;

import ejs.e_9.InicioSesion;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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


        tablaMulti.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return 10;
            }

            @Override
            public int getColumnCount() {
                return 10;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return (rowIndex+1)*(columnIndex+1);
            }

        });

        setSize(350,350);

        //TODO: EXTRA


    }

}