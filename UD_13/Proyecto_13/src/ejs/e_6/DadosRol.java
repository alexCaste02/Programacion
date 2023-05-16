package ejs.e_6;

import ejs.e_9.InicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class DadosRol extends JFrame {

    private JPanel mainPanel;
    private JPanel botHalf;
    private JPanel topHalf;
    private JButton d6Button;
    private JButton d8Button;
    private JButton d10Button;
    private JButton d12Button;
    private JButton d20Button;
    private JLabel resLabel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        EventQueue.invokeLater(DadosRol::start);
    }

    static void start(){
        DadosRol win = new DadosRol("Dados de Rol - Alex.C.D");
    }

    public DadosRol(String titulo) {
        super(titulo);
        setVisible(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DadosListener dl = new DadosListener();
        d6Button.addActionListener(dl);
        d8Button.addActionListener(dl);
        d10Button.addActionListener(dl);
        d12Button.addActionListener(dl);
        d20Button.addActionListener(dl);
    }

    class DadosListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int max = Integer.parseInt( ((JButton) e.getSource()).getName() )+1;
            resLabel.setText(""+ThreadLocalRandom.current().nextInt(1,max));
        }
    }
    
}
