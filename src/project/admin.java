/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class admin implements ActionListener {
   JFrame frame = new JFrame("Add Student Information:");
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JTextField txt3 = new JTextField();
    JTextField txt4 = new JTextField();

    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel lbl3 = new JLabel();
    JLabel lbl4 = new JLabel();
    JLabel lbl5 = new JLabel();
    JButton btn2 = new JButton();
    JLabel btn3 = new JLabel();
    JLabel icony = new JLabel();
    JLabel iconx = new JLabel();
    JButton btn4 = new JButton();
    JLabel logo = new JLabel();
    JLabel panel = new JLabel();

    JTable table = new JTable();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    JScrollPane JScrollPane1 = new JScrollPane(); 
    
    public admin() {

        frame.setLayout(null);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(0, 0, 0, 255));
        frame.setUndecorated(true);
//        frame.setShape(new RoundRectangle2D.Float(0,0, 0,500, 210,210));
//        frame.setShape(new RoundRectangle2D.Float(0,0, 500,0, 210,210));

        frame.add(icony);
        icony.setBounds(870, 0, 200, 30);
        icony.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_close_window_24px_2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        icony.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();

            }

        });
        frame.add(iconx);
        iconx.setBounds(0, 10, 200, 50);
        iconx.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_exit_26px.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        iconx.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                frame.dispose();
               new Buttons();
            }

        });

        frame.add(btn3);
        btn3.setBounds(120, 390, 200, 30);
        btn3.setText("Create Account");
        btn3.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_plus_32px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        btn3.setForeground(new Color(255, 255, 255, 255));
        btn3.setFont(new java.awt.Font("Century", 2, 12));
        btn3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                frame.hide();
            //    new Another_one();

            }

        });

        JScrollPane1.setBounds(360, 60, 500, 340);
        frame.add(JScrollPane1);
        JScrollPane1.setViewportView(table);
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(true);
        // JScrollPane1.setForeground(new Color(0, 0, 0, 255));
        table.setEnabled(true);
        table.setShowGrid(true);
        table.setGridColor(Color.black);

        table.setSelectionForeground(Color.white);
        table.setSelectionBackground(new Color(51, 51, 51, 255));
        table.getTableHeader().setBackground(new Color(51, 51, 51, 255));
        table.getTableHeader().setForeground(new Color(255, 255, 255, 255));
        table.getTableHeader().setFont(new java.awt.Font("Arial", 3, 12));
        table.setRowHeight(40);
        // table.setBackground(new Color(0,0,0,0));

        DefaultTableModel Model = (DefaultTableModel) table.getModel();
        JScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        Model.addColumn("#");
        Model.addColumn("Fullname");
        Model.addColumn("Username");
        Model.addColumn("Password");

        table.setBackground(new Color(255, 255, 255, 255));
        table.setForeground(new Color(0, 0, 0, 255));
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(20);

        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(cr);
        table.getColumnModel().getColumn(1).setCellRenderer(cr);
        table.getColumnModel().getColumn(2).setCellRenderer(cr);
        table.getColumnModel().getColumn(3).setCellRenderer(cr);

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

                String dataTable_Id = (String) table.getValueAt(table.getSelectedRow(), 0);
                String dataTable_Fname = (String) table.getValueAt(table.getSelectedRow(), 1);
                String dataTable_user = (String) table.getValueAt(table.getSelectedRow(), 2);
                String dataTable_pass = (String) table.getValueAt(table.getSelectedRow(), 3);

                txt3.setText(dataTable_Id);
                txt1.setText(dataTable_Fname);
                txt2.setText(dataTable_user);
                txt4.setText(dataTable_pass);
//               
//                 btn1.setVisible(false);
//                
            }

        });

        btn2.addMouseListener(new MouseAdapter() {
//delete 

            public void mouseClicked(MouseEvent evt) {

                Connection conn = null;
                try {
                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    int row = table.getSelectedRow();
                    String value = (table.getModel().getValueAt(row, 0).toString());
                    String query = "DELETE FROM `acc` WHERE plate = " + value;
                    java.sql.PreparedStatement pst = conn.prepareStatement(query);
                    pst.execute();

                    refresh();
                    table_reload();
                    String path = "/PROJECT/icons8_delete_bin_32px.png";
                    URL url = this.getClass().getResource(path);
                    System.out.println(url);
                    javax.swing.ImageIcon icon = new javax.swing.ImageIcon(url);
                    JOptionPane.showMessageDialog(frame, " Delete Succesfully", "Information", JOptionPane.INFORMATION_MESSAGE, icon);
//              frame.dispose();
//                    new Table();

                } catch (SQLException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                // frame1.show();
            }

        });

        btn4.addMouseListener(new MouseAdapter() {
//update
            public void mouseClicked(MouseEvent evt) {
                Connection conn = null;
                try {
                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    int row = table.getSelectedRow();
                    String valuex = (table.getModel().getValueAt(row, 0).toString());
                    java.sql.PreparedStatement pst = conn.prepareStatement("UPDATE `acc` SET `Fname`=?,`Username`=?,`Password`=? WHERE `plate`=?");

                    pst.setString(1, txt1.getText());
                    pst.setString(2, txt2.getText());
                    pst.setString(3, txt4.getText());
                    pst.setString(4, txt3.getText());

                    pst.execute();

                    refresh();
                    table_reload();
                    String path = "/PROJECT/icons8_verified_account_32px_1.png";
                    URL url = this.getClass().getResource(path);
                    System.out.println(url);
                    javax.swing.ImageIcon icon = new javax.swing.ImageIcon(url);
                    JOptionPane.showMessageDialog(frame, "Account Updated", "Information", JOptionPane.INFORMATION_MESSAGE, icon);


//                 frame.dispose();
//                    new Table();
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        Display();
        frame.add(logo);
        logo.setSize(70, 70);
        logo.setLocation(200, 20);
        logo.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/Windows-10-user-icon-big.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));

        frame.add(txt1);
        txt1.setBounds(140, 140, 200, 25);
        txt1.setBackground(new Color(153, 153, 153, 255));
        txt1.setOpaque(false);
        //    txt1.setForeground(new Color(0, 153, 0, 255));
        txt1.setHorizontalAlignment(JTextField.CENTER);

        frame.add(txt2);
        txt2.setBounds(140, 180, 200, 25);
        txt2.setBackground(new Color(153, 153, 153, 255));
        txt2.setOpaque(false);
        //   txt2.setForeground(new Color(0, 153, 0, 255));
        txt2.setHorizontalAlignment(JTextField.CENTER);
//
        frame.add(txt3);
        txt3.setBounds(140, 250, 200, 25);
        txt3.setBackground(new Color(153, 153, 153, 255));
        txt3.setOpaque(false);
        txt3.hide();
        // txt3.setForeground(new Color(0, 153, 0, 255));
        txt3.setHorizontalAlignment(JTextField.CENTER);

        frame.add(txt4);
        txt4.setBounds(140, 220, 200, 25);
        txt4.setBackground(new Color(153, 153, 153, 255));
        txt4.setOpaque(false);
//        txt4.setForeground(new Color(0, 153, 0, 255));
        txt4.setHorizontalAlignment(JTextField.CENTER);

        frame.add(lbl1);
        lbl1.setBounds(30, 140, 100, 25);
        lbl1.setText("Fullname:");

        frame.add(lbl2);
        lbl2.setBounds(30, 180, 100, 25);
        lbl2.setText("Username: ");

        frame.add(lbl3);
        lbl3.setBounds(30, 220, 100, 25);
        lbl3.setText("Password:");

//         frame.add(lbl4);
//      lbl4.setBounds(30, 260, 100, 25);
//      lbl4.setText("Retype:");
        frame.add(lbl5);
        lbl5.setBounds(140, 100, 200, 25);
        lbl5.setText("     View Accounts");
        lbl5.setForeground(new Color(255, 255, 255, 255));
        lbl5.setFont(new java.awt.Font("Century", 2, 18));

//        frame.add(lbl4);
//        lbl4.setBounds(30, 260, 100, 25);
//        lbl4.setText("Retype:");
        lbl1.setForeground(new Color(255, 255, 255, 255));
        lbl2.setForeground(new Color(255, 255, 255, 255));
        lbl3.setForeground(new Color(255, 255, 255, 255));
        lbl4.setForeground(new Color(255, 255, 255, 255));

        frame.add(btn2);
        btn2.setBounds(20, 320, 150, 35);
        btn2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_delete_bin_32px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

        btn2.setText("DELETE");
        btn2.setForeground(new Color(255, 0, 0, 255));
        btn2.setBackground(new Color(255, 255, 255, 255));
        btn2.addActionListener(this);

        frame.add(btn4);
        btn4.setBounds(200, 320, 150, 35);
        btn4.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_update_left_rotation_24px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        btn4.setText("UPDATE");
        btn4.setForeground(new Color(0, 0, 204, 255));
        btn4.setBackground(new Color(255, 255, 255, 255));
        btn4.addActionListener(this);

        frame.add(panel);
        panel.setBounds(0, 0, 900, 500);
        panel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(900, 500, Image.SCALE_SMOOTH)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();

    }

    public static void main(String[] args) {

        admin frame = new admin();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public void Display() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement pst = conn.prepareStatement("select * from acc");
            pst.execute();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("plate"), rs.getString("Fname"), rs.getString("Username"), rs.getString("Password")};
                model.addRow(data);

            }

        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void table_reload() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement pst = conn.prepareStatement("SELECT * from acc");
            pst.execute();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("plate"), rs.getString("Fname"), rs.getString("Username"), rs.getString("Password")};
                model.addRow(data);

            }

        } catch (SQLException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refresh() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);

        }
    }
}

