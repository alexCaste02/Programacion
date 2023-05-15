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

    Ventana ventana;
    private void iniciar() {
        ventana = new Ventana();
        ventana.addWindowListener(new AdaptadorVentana());
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    class Ventana extends JFrame {
        public Ventana() {
            add(new LaminaPrincipal());

            setBounds(600, 300, 600, 600);
            setSize(600, 600);
            setTitle("Juego del Ahorcado - Alejandro Castellanos");

            setVisible(true);
        }
    }

    class LaminaPrincipal extends JPanel {

        private JLabel imagen, respuesta;
        private JPanel panelLetras;

        private String secreta;
        private int fallos = 0;
        private final int MAX_FALLOS = 6;
        private ArrayList<Character> letrasPulsadas = new ArrayList<>();

        public LaminaPrincipal() {

            secreta = elegirPalabraAleatoria();
            setLayout(new BorderLayout());

            JLabel titulo = new JLabel("DAM. IES Thiar");
            titulo.setFont(new Font("Ubuntu", Font.BOLD, 24));
            titulo.setForeground(new Color(255, 255, 200));
            titulo.setIcon(new ImageIcon("UD_13/Resources/archivos/ahorcado.png"));

            JPanel panelTitulo = new JPanel();
            panelTitulo.add(titulo);
            panelTitulo.setBackground(Color.GRAY);
            add(panelTitulo, BorderLayout.PAGE_START);


            imagen = new JLabel();
            imagen.setIcon(new ImageIcon("UD_13/Resources/archivos/Hangman-0.png"));

            panelLetras = new JPanel();
            ponerBotones();

            JPanel panelCentro = new JPanel();
            panelCentro.setLayout(new BorderLayout());
            panelCentro.add(imagen, BorderLayout.PAGE_START);
            panelCentro.add(panelLetras);
            add(panelCentro, BorderLayout.CENTER);

            JPanel panelRespuesta = new JPanel();
            panelRespuesta.setBackground(new Color(150, 150, 150));
            respuesta = new JLabel("PALABRA");
            respuesta.setFont(new Font("Ubuntu", Font.BOLD, 48));
            respuesta.setForeground(new Color(255, 0, 0));
            panelRespuesta.add(respuesta);
            add(panelRespuesta, BorderLayout.PAGE_END);

            formaLetrasSecretas();
        }

        private String elegirPalabraAleatoria() {
            ArrayList<String> palabras = new ArrayList<>();
            try (Scanner scf = new Scanner(new File("UD_13/Resources/archivos/diccionario.txt"))) {
                while (scf.hasNext()) {
                    String p = scf.next();
                    if (p.length() >= 4) palabras.add(scf.next().toUpperCase());
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            return palabras.get(ThreadLocalRandom.current().nextInt(palabras.size()));
        }

        public void ponerBotones() {
            String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
            TeclaPulsada gestor = new TeclaPulsada();
            for (int i = 0; i < letras.length(); i++) {
                JButton boton = new JButton("" + letras.charAt(i));
                boton.addActionListener(gestor);
                panelLetras.add(boton);
            }
        }

        public void formaLetrasSecretas() {
            String formaSecreto = "";
            for (int i = 0; i < secreta.length(); i++) {
                formaSecreto += "_ ";
            }
            respuesta.setText(formaSecreto.trim());
        }

        public void comprobarLetra(String c) {
            boolean acertada = true; // Para saber si la palabra está completa
            letrasPulsadas.add(c.charAt(0)); // Añadimos la letra a la lista
            if (secreta.contains(c)) { // La letra pulsada está en la palabra
                // Ponemos el texto de la etiqueta ocultando las letras
                // que todavía no se han pulsado
                String formaSecreto = "";
                for (int i = 0; i < secreta.length(); i++) {
                    if (letrasPulsadas.contains(secreta.charAt(i))) {
                        formaSecreto = formaSecreto + secreta.charAt(i) + " ";
                    } else {
                        // Si alguna no está, no está completa la palabra
                        acertada = false;
                        formaSecreto += "_ ";
                    }
                }
                respuesta.setText(formaSecreto.trim());
            } else {
                // La letra pulsada no está en la palabra
                fallos++;
                acertada = false;
                // Usamos el número de fallos para cambiar la imagen
                imagen.setIcon(new ImageIcon("UD_13/Resources/archivos/Hangman-" + fallos + ".png"));
            }
            if (acertada || fallos == MAX_FALLOS) {

                Component[] botonesLetras = panelLetras.getComponents();
                for (Component boton : botonesLetras) {
                    boton.setEnabled(false);
                }
                JPanel panel = new JPanel();

                if (acertada) {
                    // Se ha acertado la palabra
                    System.out.println("Has ganado");
                } else {
                    // Ahorcado
                    System.out.println("AHORCADO");

                    JOptionPane.showMessageDialog(panel,
                            "Lo siento, has perdido",
                            "AHORCADO",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                }
                int opcion = JOptionPane.showConfirmDialog(panel, "¿Desea Continuar?");
                ventana.dispose();
                if (opcion == JOptionPane.YES_OPTION) {
                    iniciar();
                }
            }
        }

        class TeclaPulsada implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botonPulsado = (JButton) e.getSource();
                botonPulsado.setEnabled(false);
                comprobarLetra(e.getActionCommand());
            }
        }
    }

    class AdaptadorVentana extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            System.out.println("Cerrando la ventana");
            JPanel panel = new JPanel();

            int opcion = JOptionPane.showConfirmDialog(panel, "¿Realmente deseas salir?","Confirmacion",JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) ventana.dispose();
        }
    }

}
