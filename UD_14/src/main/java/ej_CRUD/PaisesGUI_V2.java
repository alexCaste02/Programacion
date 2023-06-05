package ej_CRUD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class PaisesGUI_V2 extends JFrame{

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
    private JTextField pobField;
    private JTextField distField;
    private JTextField nameField;
    private JPanel operationsPanel;
    private JSplitPane paneSplit;

    public static void main(String[] args) {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception ignored){}
        EventQueue.invokeLater(PaisesGUI_V2::start);
    }

    public static void start(){PaisesGUI_V2 win = new PaisesGUI_V2();}

    public PaisesGUI_V2() {
        setContentPane(mainPanel);
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rellenarComboBox();
        generarTabla();
        setVisible(true);

        comboBox.addActionListener(e -> {
            botSplit.setVisible(false);
            generarTabla();
        });

        citiesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mostrarInfo();

            }
        });

    }

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
            if(ciudad.getCodigoPais().equals(paisFiltro.getCodigo()))
                ciudadesFiltradas.add(ciudad);
        }

        String[] nombresColumna = {"ID","Nombre","Distrito","Poblacion"};
        String[][] valoresTabla = new String[ciudadesFiltradas.size()][4];

        for (int fila = 0; fila < ciudadesFiltradas.size(); fila++) {
            valoresTabla[fila][0] = ciudadesFiltradas.get(fila).getId();
            valoresTabla[fila][1] = ciudadesFiltradas.get(fila).getNombre();
            valoresTabla[fila][2] = ciudadesFiltradas.get(fila).getDistrito();
            valoresTabla[fila][3] = ciudadesFiltradas.get(fila).getPoblacion()+"";
        }

        TableModel tm = new DefaultTableModel(valoresTabla,nombresColumna){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        citiesTable.setModel(tm);
    }

    private void mostrarInfo() {
        botSplit.setVisible(true);

        paneSplit.resetToPreferredSizes();
        String id = citiesTable.getValueAt(citiesTable.getSelectedRow(), 0) + "";
        Ciudad ciudad = daoCiudad.obtener(id).orElse(null);

        assert ciudad != null;
        idField.setText(ciudad.getId());
        nameField.setText(ciudad.getNombre());
        distField.setText(ciudad.getDistrito());
        pobField.setText(ciudad.getPoblacion() + "");
    }



}