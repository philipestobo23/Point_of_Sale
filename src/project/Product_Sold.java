/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Product_Sold {

    JFrame frame = new JFrame();
    JTable Table_Of_Sold_Product = new JTable();
    DefaultTableModel FirstModel_legacy = (DefaultTableModel) Table_Of_Sold_Product.getModel();
    JScrollPane JScroll = new JScrollPane();
       JLabel background = new JLabel();
 JLabel TotalAmount_Field = new JLabel();
    public Product_Sold() {

        frame.setSize(1500, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(frame);

        JScroll.setBounds(20, 150, 1300, 500);
        frame.add(JScroll);
        JScroll.setViewportView(Table_Of_Sold_Product);
        Table_Of_Sold_Product.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table_Of_Sold_Product.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Table_Of_Sold_Product.getTableHeader().setReorderingAllowed(true);

        Table_Of_Sold_Product.setEnabled(true);
        Table_Of_Sold_Product.setShowGrid(true);
        Table_Of_Sold_Product.setGridColor(new Color(51, 51, 51, 255));

        Table_Of_Sold_Product.setSelectionForeground(Color.white);
        Table_Of_Sold_Product.setSelectionBackground(new Color(51, 51, 51, 255));

        Table_Of_Sold_Product.getTableHeader().setBackground(new Color(51, 51, 51, 255));
        Table_Of_Sold_Product.getTableHeader().setForeground(new Color(255, 255, 255, 255));
        Table_Of_Sold_Product.getTableHeader().setFont(new java.awt.Font("Arial", 3, 12));
        Table_Of_Sold_Product.setRowHeight(20);

        JScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        FirstModel_legacy.addColumn("Product_code:");
        FirstModel_legacy.addColumn("Date of Sold");
        FirstModel_legacy.addColumn("Item Name");
        FirstModel_legacy.addColumn("Quantity");
        FirstModel_legacy.addColumn("Price");
        FirstModel_legacy.addColumn("Total");

        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        Table_Of_Sold_Product.getColumnModel().getColumn(0).setCellRenderer(cr);
        Table_Of_Sold_Product.getColumnModel().getColumn(1).setCellRenderer(cr);
        Table_Of_Sold_Product.getColumnModel().getColumn(2).setCellRenderer(cr);
        Table_Of_Sold_Product.getColumnModel().getColumn(3).setCellRenderer(cr);
        Table_Of_Sold_Product.getColumnModel().getColumn(4).setCellRenderer(cr);
        Table_Of_Sold_Product.getColumnModel().getColumn(5).setCellRenderer(cr);
        
//        
//          Table_Of_Sold_Product.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                int sum2 = 0;
//                for (int i = 0; i < Table_Of_Sold_Product.getRowCount(); i++) {
//                    sum2 = sum2 + Integer.parseInt(Table_Of_Sold_Product.getValueAt(i, 5).toString());
//
//                }
//                TotalAmount_Field.setText("TOTAL AMOUNT = "+"₱  "+sum2+"");
//             //   TotalAmount_Field.setText(Double.toString(""+""+sum2+""));
//                TotalAmount_Field.setFont(new java.awt.Font("Arial", 3, 30));
//                TotalAmount_Field.setForeground(Color.white);
//
//            }
//
//        });
 
         frame.add(TotalAmount_Field);
        TotalAmount_Field.setBounds(50, 20, 700, 60);
        Display();
         frame.add(background);
        background.setBounds(0, 0, 1500, 800);
        background.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(1500, 800, Image.SCALE_SMOOTH)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();

    }

    public static void main(String[] args) {
        Product_Sold frame = new Product_Sold();

    }

    public void Display() {

//       
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("select * from view_sold_product");
            ps.execute();

            ResultSet rs = ps.executeQuery();
            
            
            
            while (rs.next()) {
                String data[] = {rs.getString("product_code"), rs.getString("date2"), rs.getString("item_name"), rs.getString("item_Quantity"), rs.getString("item_Price"), rs.getString("Item_Total")};
                FirstModel_legacy.addRow(data);

            }
   int sum2 = 0;
                for (int i = 0; i < Table_Of_Sold_Product.getRowCount(); i++) {
                    sum2 = sum2 + Integer.parseInt(Table_Of_Sold_Product.getValueAt(i, 5).toString());

                }
                TotalAmount_Field.setText("TOTAL AMOUNT = "+"₱  "+sum2+"");
             //   TotalAmount_Field.setText(Double.toString(""+""+sum2+""));
                TotalAmount_Field.setFont(new java.awt.Font("Arial", 3, 30));
                TotalAmount_Field.setForeground(Color.white);
        } catch (SQLException ex) {
            Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
