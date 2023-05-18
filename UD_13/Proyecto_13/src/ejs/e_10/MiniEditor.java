package ejs.e_10;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MiniEditor extends JFrame {
    private JPanel mainPanel;
    private JButton abrirButton;
    private JButton guardarButton;
    private JTextArea textArea;
    private JSlider fontSlider;
    private File archivoEnEdicion;

    public static void main(String[] args) {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception ignored) {}
        EventQueue.invokeLater(MiniEditor::start);
    }

    static void start() {
        MiniEditor win = new MiniEditor("MiniEditor - Alex.C.D");
    }

    public MiniEditor(String titulo) {
        super(titulo);
        setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        pack();

        //TODO: Usar JScrollPane

        archivoEnEdicion = (new File("UD_13/Resources")).getAbsoluteFile();

        abrirButton.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser(archivoEnEdicion);
            int r = jfc.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                archivoEnEdicion = jfc.getSelectedFile().getAbsoluteFile();
                textArea.setText("");

                try (Scanner scf = new Scanner(archivoEnEdicion)) {
                    while (scf.hasNextLine()) textArea.append(scf.nextLine() + "\n");
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        });

        guardarButton.addActionListener(e -> {
            JFileChooser jfc = new JFileChooser(archivoEnEdicion);
            int r = jfc.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                archivoEnEdicion = jfc.getSelectedFile().getAbsoluteFile();

                try (PrintWriter pw = new PrintWriter(archivoEnEdicion)) {
                    pw.print(textArea.getText());
                    JOptionPane.showMessageDialog(null, "Archivo guardado", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {System.out.println(ex.getMessage());}
            }
        });
    }


}
