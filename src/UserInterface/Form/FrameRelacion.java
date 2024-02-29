package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameRelacion extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private JButton btnCreate, btnRead, btnUpdate, btnDelete;

    public FrameRelacion() {
        setTitle("CRUD Operations");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Create table
        // String[] columnNames = {"ID", "Name", "Email"};
        // Object[][] data = {
                // {1, "John Doe", "john.doe@example.com"},
                // {2, "Jane Doe", "jane.doe@example.com"},
        // };
        // model = new DefaultTableModel(data, columnNames);
        // table = new JTable(model);

        // Create buttons
        btnCreate = new JButton("Create");
        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        // Add action listeners to buttons
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to create a new record
            }
        });
        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to read a record
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to update a record
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to delete a record
            }
        });

        // Add buttons to a panel
        JPanel panel = new JPanel();
        panel.add(btnCreate);
        panel.add(btnRead);
        panel.add(btnUpdate);
        panel.add(btnDelete);

        // Add table and buttons to the frame
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
