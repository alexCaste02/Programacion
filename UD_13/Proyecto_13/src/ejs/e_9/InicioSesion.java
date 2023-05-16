package ejs.e_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InicioSesion extends JFrame{
    private JPanel mainPanel;
    private JTextField userTextF;
    private JLabel userLabel;
    private JLabel passJlabel;
    private JPanel leftHalf;
    private JPanel rightHalf;
    private JPasswordField passField;
    private JButton entrarButton;
    private JButton crearButton;

    private Map<String,String> userPassMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        EventQueue.invokeLater(InicioSesion::start);
    }

    static void start(){
        InicioSesion win = new InicioSesion();
    }

    public InicioSesion() throws HeadlessException {
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//hace falta?
        pack();
        loadSavedUsers();

        entrarButton.addActionListener(e -> {
            boolean valido = false;

            for (Map.Entry<String, String> entry : userPassMap.entrySet()) {
                if(userTextF.getText().equals(entry.getKey())){
                    //se podria pasar el passField a String pero zzzz
                    char[] passInput = passField.getPassword();
                    char[] passCheck = entry.getValue().toCharArray();
                    for (int i = 0; i < passInput.length; i++) {
                        if(passInput[i]!=passCheck[i]) break;
                        valido=true;
                    }
                }
            }

            if(valido)
                JOptionPane.showMessageDialog(new JPanel(),
                        "Acceso concedido",
                        "Validado",
                        JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(new JPanel(),
                        "Acceso denegado",
                        "Usuario o contraseña no es valido",
                        JOptionPane.ERROR_MESSAGE);

        });
    }

    private void loadSavedUsers(){
        File users = new File("UD_13/Resources/users.txt");
        try(Scanner scf = new Scanner(users)){

            while (scf.hasNextLine()) {
                String[] linea = scf.nextLine().split(";");
                userPassMap.put(linea[0],linea[1]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
