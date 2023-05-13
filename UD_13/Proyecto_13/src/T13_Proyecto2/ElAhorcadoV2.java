package T13_Proyecto2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ElAhorcado {

    public static void main(String[] args) {
        new ElAhorcado().iniciar();
    }

    private Ventana ventana;

    private void iniciar() {
        ventana = new Ventana();
        ventana.addWindowListener(new AdaptadorVentana());
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private class Ventana extends JFrame {
        public Ventana() {
            crearVentana();
        }

        private void crearVentana() {
            add(new PanelJuego());

            setBounds(600, 300, 600, 600);
            setSize(600, 600);
            setTitle("Juego del Ahorcado");

            setVisible(true);
        }
    }

    private class PanelJuego extends JPanel {

        private JLabel imagen, respuesta;
        private JPanel panelLetras;

        private String secreta;
        private int fallos = 0;
        private final int MAX_FALLOS = 6;
        private ArrayList<Character> letrasPulsadas = new ArrayList<>();

        public PanelJuego() {

            secreta = elegirPalabraAleatoria();
//            secreta="test";
            setLayout(new BorderLayout());

            JLabel titulo = new JLabel("DAM. IES
        }

        class TeclaPulsada implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton boton = (JButton) e.getSource();
                comprobarLetra(boton.getText());
            }
        }

        class AdaptadorVentana extends WindowAdapter {
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(ventana, "¿Desea salir de la aplicación?",
                        "Confirmar salida", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
    }
}
