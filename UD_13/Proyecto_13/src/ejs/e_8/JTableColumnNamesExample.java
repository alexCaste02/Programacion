package ejs.e_8;

import javax.swing.*;
import javax.swing.table.*;

public class JTableColumnNamesExample {
    public static void main(String[] args) {
        // Sample data
        Object[][] data = {
                {1, "John", "Doe"},
                {2, "Jane", "Smith"},
                {3, "Bob", "Johnson"}
        };

        // Column names
        String[] columnNames = {"ID", "First Name", "Last Name"};

        // Create a DefaultTableModel with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Get the column model of the table
        TableColumnModel columnModel = table.getColumnModel();

        // Set the column names
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }

        // Refresh the table to display the updated column names
        table.getTableHeader().repaint();

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame and add the JScrollPane to it
        JFrame frame = new JFrame();
        frame.add(scrollPane);

        // Set other frame properties and display it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
