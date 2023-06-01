package ej_CRUD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class PaisesGUI extends JFrame {

    static Dao<Ciudad> daoCiudad = new CiudadDaoMySQL();
    static Dao<Pais> daoPais = new PaisDaoMySQL();

    private JPanel mainPanel;
    private JPanel topSplit;
    private JPanel paisPanel;
    private JTable citiesTable;
    private JScrollPane tableScroll;
    private JComboBox<Pais> comboBox;
    private JPanel botSplit;
    private JButton crearButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JPanel datosPanel;
    private JTextField idField;
    private JTextField popField;
    private JTextField distField;
    private JTextField nameField;
    private JPanel operationsPanel;
    private JSplitPane paneSplit;
    private JButton aplicarButton;
    private JButton cancelarButton;
    private JPanel confirmPanel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        EventQueue.invokeLater(PaisesGUI::start);
    }

    public static void start() {
        PaisesGUI win = new PaisesGUI();
    }

    public PaisesGUI() {
        setContentPane(mainPanel);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rellenarComboBox();
        generarTabla();

        //Editamos visibilidad aqui para poder editar el form con mas facilidad
        showOnlyCrear();


        setVisible(true);

        comboBox.addActionListener(e -> {
            showOnlyCrear();
            generarTabla();
        });

        citiesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (citiesTable.getSelectedRow() == -1) {
                    showOnlyCrear();
                } else {

                    String id = String.valueOf(citiesTable.getValueAt(citiesTable.getSelectedRow(), 0));
                    Ciudad ciudad = daoCiudad.obtener(id).orElse(null);

                    assert ciudad != null;
                    idField.setText(ciudad.getId());
                    nameField.setText(ciudad.getNombre());
                    distField.setText(ciudad.getDistrito());
                    popField.setText(String.valueOf(ciudad.getPoblacion()));
                }
            }
        });

        crearButton.addActionListener(e -> {
            moverBotones();
            clearFields();
            datosPanel.setVisible(true);

            idField.setEnabled(false);
            idField.setText("AUTOGENERADO");

            refreshSizes();

            aplicarButton.addActionListener(e1 -> {

                String name = nameField.getText();
                String district = distField.getText();
                int population = Integer.parseInt(popField.getText());
                String countrycode = ( (Pais) comboBox.getSelectedItem()).getCodigo();

                daoCiudad.guardar(new Ciudad(name,district,population,countrycode));
            });

        });


        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverBotones();
            }
        });

        eliminarButton.addActionListener(e -> {
            int r = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere eliminar esta ciudad?", "Confirmar operacion", JOptionPane.YES_NO_OPTION);

            if(r == JOptionPane.YES_OPTION){
                String id = idField.getText();
                daoCiudad.borrar(new Ciudad(id));
            } else {

            }
            generarTabla();
        });

    }

    private void refreshSizes() {
        setSize(400, 610);
        setSize(400, 600);
        botSplit.setPreferredSize(new Dimension(320,1));
        paneSplit.resetToPreferredSizes();
    }

    private void showOnlyCrear(){
        datosPanel.setVisible(false);
        operationsPanel.setVisible(false);
        confirmPanel.setVisible(false);
        crearButton.setVisible(true);
        refreshSizes();
    }

    private void showCityOperations(){
        datosPanel.setVisible(true);
        operationsPanel.setVisible(true);
        confirmPanel.setVisible(false);
        crearButton.setVisible(true);
        refreshSizes();
    }

    private void showCityConfirm(){
        datosPanel.setVisible(true);
        operationsPanel.setVisible(false);
        confirmPanel.setVisible(true);
        crearButton.setVisible(false);
        refreshSizes();
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        distField.setText("");
        popField.setText("");
    }

    /**
     *
     */


    private void rellenarComboBox() {
        List<Pais> listaPaises = daoPais.obtenerTodos();

        for (Pais p : listaPaises) {
            comboBox.addItem(p);
        }
    }

    private void generarTabla() {

        List<Ciudad> listaCiudades = daoCiudad.obtenerTodos();
        Pais paisFiltro = (Pais) comboBox.getSelectedItem();
        if (paisFiltro == null) {
            return;
        }

        List<Ciudad> ciudadesFiltradas = new ArrayList<>();
        for (Ciudad ciudad : listaCiudades) {
            if (ciudad.getCodigoPais().equals(paisFiltro.getCodigo()))
                ciudadesFiltradas.add(ciudad);
        }

        String[] nombresColumna = {"ID", "Nombre", "Distrito", "Poblacion"};
        String[][] valoresTabla = new String[ciudadesFiltradas.size()][4];

        for (int fila = 0; fila < ciudadesFiltradas.size(); fila++) {
            valoresTabla[fila][0] = ciudadesFiltradas.get(fila).getId();
            valoresTabla[fila][1] = ciudadesFiltradas.get(fila).getNombre();
            valoresTabla[fila][2] = ciudadesFiltradas.get(fila).getDistrito();
            valoresTabla[fila][3] = String.valueOf(ciudadesFiltradas.get(fila).getPoblacion());
        }

        TableModel tm = new DefaultTableModel(valoresTabla, nombresColumna) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        citiesTable.setModel(tm);
    }


}
