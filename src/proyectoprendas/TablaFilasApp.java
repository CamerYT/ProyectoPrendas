/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprendas;

/**
 *
 * @author Atlai Camero
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaFilasApp extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;
    private JButton agregarFilasButton;

    public TablaFilasApp() {
        setTitle("Agregar Filas a la Tabla");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        agregarFilasButton = new JButton("Agregar Filas");
        agregarFilasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoFilas();
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(agregarFilasButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarDialogoFilas() {
        String numeroFilasStr = JOptionPane.showInputDialog(this, "Ingrese el número de filas:", "Número de Filas", JOptionPane.QUESTION_MESSAGE);

        try {
            int numeroFilas = Integer.parseInt(numeroFilasStr);
            agregarFilas(numeroFilas);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarFilas(int numeroFilas) {
        // Agregar filas a la tabla
        for (int i = 1; i <= numeroFilas; i++) {
            tableModel.addRow(new Object[]{"Dato " + i});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TablaFilasApp();
            }
        });
    }
}
