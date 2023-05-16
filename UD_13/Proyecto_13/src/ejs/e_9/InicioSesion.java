package ejs.e_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
        InicioSesion win = new InicioSesion("Inicio de sesion - Alex.C.D");
    }

    public InicioSesion(String titulo) throws HeadlessException {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//hace falta?
        pack();
        loadSavedUsers();

        entrarButton.addActionListener(e -> {
            boolean valido = false;

            if (userPassMap.containsKey(userTextF.getText())) {
                char[] passInput = passField.getPassword();
                char[] passCheck = userPassMap.get(userTextF.getText()).toCharArray();

                if (Arrays.equals(passInput, passCheck)) valido = true;
            }

            if (valido) {
                JOptionPane.showMessageDialog(null, "Acceso concedido", "Validado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado", "Usuario o contraseña no es válido", JOptionPane.ERROR_MESSAGE);
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passCharArray = passField.getPassword();
                StringBuilder passSB = new StringBuilder();
                for (char c : passCharArray) {
                    passSB.append(c);
                }

                createUser(userTextF.getText(), passSB.toString());
            }
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

    private void createUser(String user, String pass){
        File users = new File("UD_13/Resources/users.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(users,true))) {

            bw.newLine();
            bw.write(user+";"+pass);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
