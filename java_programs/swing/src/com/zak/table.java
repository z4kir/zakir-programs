package com.zak;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.BorderLayout.CENTER;

public class table extends JFrame {
    JButton Add, Update, Delete;
    JTextField add, update, delete;
    DefaultTableModel model;
    JTable table;
    int row;

    public table() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        Object[][] data = {{001, "zakir", 22}, {002, "rahul", 23}, {003, "saif", 24}};
        String[] ColumnName = {"Roll_NO", "Name", "Age"};
        model = new DefaultTableModel(data, ColumnName);

        table = new JTable(model);

        JPanel panel1 = new JPanel();
//        JPanel panel2=new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel1.add(new JScrollPane(table));
        panel3.setLayout(new GridLayout(3, 2));

        Add = new JButton("Add");
        Update = new JButton("Update");
        Delete = new JButton("Delete");

        add = new JTextField();
        update = new JTextField();
        delete = new JTextField();

        panel3.add(add);
        panel3.add(Add);

        panel3.add(update);
        panel3.add(Update);

        panel3.add(delete);
        panel3.add(Delete);


        add(panel1);
        add(new JSeparator(JSeparator.HORIZONTAL));
//        add(panel2);
//        add(new JSeparator(JSeparator.HORIZONTAL));
        add(panel3);

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("Add")) {

                    if ((!add.getText().isBlank()) && (!update.getText().isBlank()) && (!delete.getText().isBlank())) {
                        int rollno = Integer.parseInt(add.getText());
                        String name = update.getText();
                        int age = Integer.valueOf(delete.getText());
                        Object[] newRow = {rollno, name, age};

                        model.addRow(newRow);

                        add.setText(null);
                        update.setText(null);
                        delete.setText(null);
                    } else {
                        System.out.println("Please Fill all the detail");
                        add.setText(null);
                        update.setText(null);
                        delete.setText(null);
                    }

                }

            }
        });


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() == -1) {
                    System.out.println("please select row first");


                } else {
                    row = table.getSelectedRow();
                    add.setText(table.getValueAt(row, 0).toString());
                    update.setText(table.getValueAt(row, 1).toString());
                    delete.setText(table.getValueAt(row, 2).toString());
                }


            }
        });

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollno = Integer.valueOf(add.getText());
                String name = update.getText();
                int age = Integer.valueOf(delete.getText());
                Object[] updateRow = {rollno, name, age};
                model.setValueAt(rollno, row, 0);
                model.setValueAt(name, row, 1);
                model.setValueAt(age, row, 2);

                add.setText(null);
                update.setText(null);
                delete.setText(null);

            }
        });
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("Delete") && !delete.getText().isBlank()) {
                    int y = JOptionPane.showConfirmDialog(null, "are you sure", "confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (y == JOptionPane.YES_OPTION) {
                        model.removeRow(row);
                        add.setText(null);
                        update.setText(null);
                        delete.setText(null);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "please select row", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        setVisible(true);

    }

    public static void main(String[] args) {
        new table();
    }
}
