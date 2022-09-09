/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Add_pro {

    JFrame frame = new JFrame("ADD PRODUCT");

    JTable table = new JTable();
    DefaultTableModel Model1 = (DefaultTableModel) table.getModel();
    JScrollPane JScrollPane11 = new JScrollPane();
    JLabel p = new JLabel();
    JTextField Product_name_Field = new JTextField();
    JTextField quantity_field = new JTextField();
    JTextField price_field = new JTextField();
    JTextField code_field = new JTextField();

    JTextField Search_field = new JTextField();

    JLabel product = new JLabel("PRODUCT NAME:");
    JLabel Stock = new JLabel("STOCK:");
    JLabel price = new JLabel("PRICE:");
    JLabel no_product = new JLabel("NO. OF PRODUCT:");
    JLabel search_label = new JLabel("SEARCH");
////////////////////////////////////////////////
    JButton add_button = new JButton();
    JButton delete_button = new JButton();
    JButton update_button = new JButton();

    public Add_pro() throws SQLException {

        frame.setSize(1000, 560);
        frame.setLayout(null);
        frame.setLocationRelativeTo(frame);

        frame.add(Product_name_Field);
        frame.add(quantity_field);
        frame.add(price_field);
        frame.add(code_field);
        frame.add(Search_field);

        Product_name_Field.setBounds(160, 340, 200, 20);
        quantity_field.setBounds(160, 380, 200, 20);
        price_field.setBounds(160, 420, 200, 20);
        code_field.setBounds(160, 460, 200, 20);
        Search_field.setBounds(180, 10, 200, 30);

        frame.add(product);
        frame.add(Stock);
        frame.add(price);
        frame.add(no_product);
        frame.add(search_label);

        product.setBounds(20, 340, 150, 20);
        Stock.setBounds(20, 380, 150, 20);
        price.setBounds(20, 420, 150, 20);
        no_product.setBounds(20, 460, 150, 20);
        search_label.setBounds(80, 5, 100, 40);

        product.setForeground(Color.white);
        Stock.setForeground(Color.white);
        price.setForeground(Color.white);
        no_product.setForeground(Color.white);
        search_label.setForeground(Color.white);
        search_label.setFont(new java.awt.Font("Arial", 3, 18));
        /////////////////////////////////TABLE//////////////////////////////////////
        JScrollPane11.setBounds(20, 50, 940, 280);
        frame.add(JScrollPane11);
        JScrollPane11.setViewportView(table);
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        //  table.getTableHeader().setReorderingAllowed(true);
  JScrollPane11.setOpaque(false);
        JScrollPane11.getViewport().setOpaque(false);

        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);
        table.setShowGrid(false);

        table.setEnabled(true);
        table.setShowGrid(true);
        table.setGridColor(new Color(51, 51, 51, 255));

        table.setSelectionForeground(Color.white);
      //  table.setSelectionBackground(new Color(51, 51, 51, 255));

        table.getTableHeader().setBackground(new Color(51, 51, 51, 255));
        table.getTableHeader().setForeground(new Color(255, 255, 255, 255));
        table.getTableHeader().setFont(new java.awt.Font("Arial", 3, 12));
        table.setRowHeight(40);

        JScrollPane11.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        Model1.addColumn("CODE no");
        Model1.addColumn("Product Name:");
        Model1.addColumn("Stock:");
        Model1.addColumn("Price:");

//      
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(cr);
        table.getColumnModel().getColumn(1).setCellRenderer(cr);
        table.getColumnModel().getColumn(2).setCellRenderer(cr);
        table.getColumnModel().getColumn(3).setCellRenderer(cr);

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {

                String dataTable_noproduct = (String) table.getValueAt(table.getSelectedRow(), 0);
                String dataTable_name = (String) table.getValueAt(table.getSelectedRow(), 1);
                String dataTable_quantity = (String) table.getValueAt(table.getSelectedRow(), 2);
                String dataTable_price_product = (String) table.getValueAt(table.getSelectedRow(), 3);

                code_field.setText(dataTable_noproduct);
                Product_name_Field.setText(dataTable_name);
                quantity_field.setText(dataTable_quantity);
                price_field.setText(dataTable_price_product);
                add_button.setVisible(false);

            }

        });
        ////////////////////////////////END OF TABLE///////////////////////
//////////////////////////////////////////INSERT/////////////////////////////
        frame.add(add_button);
        add_button.setBounds(400, 340, 160, 35);
        add_button.setText("ADD PRODUCT");
        add_button.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_add_user_male_30px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        add_button.setForeground(new Color(0, 153, 0, 255));
        add_button.setBackground(new Color(255, 255, 255, 255));
        add_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connection con = null;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO `pro_x`(`no_product`,`product_name`,`quantity`,`price`) values(?,?,?,?)");

                    ps.setString(1, code_field.getText());
                    ps.setString(2, Product_name_Field.getText());
                    ps.setString(3, quantity_field.getText());
                    ps.setString(4, price_field.getText());
                    ps.execute();

                    refresh();
                    Display();

                    code_field.setText("");
                    Product_name_Field.setText("");
                    quantity_field.setText("");
                    price_field.setText("");

                    JOptionPane.showMessageDialog(frame, " Add Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        Display();
        ///////////////////////////////////////end of Insert/////////////////////////////

        ////////////////////////////search///////////////////////////////////////
        Search_field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    Connection con = null;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM `Pro_x`  WHERE  `no_product` LIKE ? OR  `product_name` LIKE ? OR `quantity` LIKE ? OR `price` LIKE ?");
                    pst.setString(1, Search_field.getText());
                    pst.setString(2, Search_field.getText());
                    pst.setString(3, Search_field.getText());
                    pst.setString(4, Search_field.getText());

                    pst.execute();
                    ResultSet rs = pst.executeQuery();
                    refresh();

                    code_field.setText("");
                    Product_name_Field.setText("");
                    quantity_field.setText("");
                    price_field.setText("");

                    if (rs.next() == true) {
                        String data[] = {rs.getString("no_product"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")};
                        Model1.addRow(data);

                    }

                    if (Search_field.getText().equals("")) {
                        Display();

                    }

                } catch (SQLException ex) {

                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        /////////////////////////////end of search//////////////////////

        ///////////////////////////////delete/////////////////
        frame.add(delete_button);
        delete_button.setBounds(570, 340, 200, 35);
        delete_button.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_delete_bin_32px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        delete_button.setText("REMOVE PRODUCT");
        delete_button.setForeground(new Color(255, 0, 0, 255));
        delete_button.setBackground(new Color(255, 255, 255, 255));
        delete_button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {

                try {
                    Connection con = null;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    int row = table.getSelectedRow();
                    String value = (table.getModel().getValueAt(row, 0).toString());
                    String query = "DELETE FROM `Pro_x` WHERE no_product = " + value;
                    java.sql.PreparedStatement ps = con.prepareStatement(query);
                    ps.execute();

                    refresh();
                    table_reload();

                    JOptionPane.showMessageDialog(null, "Delete Successfully", "Delete Successfully", JOptionPane.INFORMATION_MESSAGE);
//            
                } catch (SQLException ex) {
                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
///////////////////////////////////////////end of delete//////////////////////////

        frame.add(update_button);
        update_button.setBounds(780, 340, 180, 35);
        update_button.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_update_left_rotation_24px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        update_button.setText("UPDATE PRODUCT");
        update_button.setForeground(new Color(0, 0, 204, 255));
        update_button.setBackground(new Color(255, 255, 255, 255));
        update_button.addMouseListener(new MouseAdapter() {
//update
            public void mouseClicked(MouseEvent evt) {
                Connection con = null;
                try {
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    int row = table.getSelectedRow();
                    String valuex = (table.getModel().getValueAt(row, 0).toString());
                    java.sql.PreparedStatement ps = con.prepareStatement("UPDATE `Pro_x` SET `product_name`=?,`quantity`=?,`price`=? WHERE `no_product`=?");

                    ps.setString(1, Product_name_Field.getText());
                    ps.setString(2, quantity_field.getText());
                    ps.setString(3, price_field.getText());
                    ps.setString(4, code_field.getText());
                    ps.execute();
//                    for (int i = 0; i < Table.getRowCount() +1; i++) {
//                        COUNT.setText(Integer.toString(i));
//                    }
                    add_button.setVisible(true);
                    JOptionPane.showMessageDialog(frame, "Table Updated", "Table Updated", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
                    table_reload();

//                   frame.dispose();
//                    new Table();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        //////////////////////////////////////////
        frame.add(p);
        p.setBounds(0, 0, 1000, 560);
        p.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(1000, 560, Image.SCALE_SMOOTH)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();

    }

    public static void main(String[] args) throws SQLException {

        Add_pro frame = new Add_pro();

    }

    public void Display() {

//       
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("select * from pro_x");
            ps.execute();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("no_product"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")};
                Model1.addRow(data);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void table_reload() {

//        Model = (DefaultTableModel) table.getModel();
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT * from pro_x");
            ps.execute();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("no_product"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")};
                Model1.addRow(data);

                //   btn1.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refresh() {

        int rowCount = Model1.getRowCount();
        for (int x = rowCount - 1; x >= 0; x--) {
            Model1.removeRow(x);

        }

    }

}///end///

