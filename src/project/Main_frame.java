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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Main_frame {

    JFrame frame = new JFrame();

    ////////////////////MENU//////////////////
    JMenuBar main_menu_bar = new JMenuBar();
    JMenu main_menu = new JMenu();
//    JMenuItem menu_account = new JMenuItem("CREATE ACCOUNT");
//    JMenu menu_add = new JMenu("VIEW PRODUCTS");
//    JMenu menu_sold = new JMenu("VIEW SOLD PRODUCTs");
//    JMenu menu_out = new JMenu("LOGOUT");

//////////////////////END OF MENU////////////////////////////
    ///////////////calendar////////////////////
//     int day, month, year;
//
//    int second, minutes, hour;
//    GregorianCalendar date = new GregorianCalendar();
    ////////////end of calendar////////////////
    //////////////////TABLE///////////////
    JTable Table_0f_Cart = new JTable();
    DefaultTableModel Model = (DefaultTableModel) Table_0f_Cart.getModel();
    JScrollPane JScrollPane1 = new JScrollPane();

    ////////////////////END OF TABLE/////////////////////////
////////////////////////TEXTFIELDS//////////////////
    JTextField Search_Field = new JTextField();
    JTextField Search1_Field = new JTextField();
    JTextField ItemCode_Field = new JTextField();
    JTextField Item_Field = new JTextField();
    JTextField Price_Field = new JTextField();
    JTextField Stock_Field = new JTextField();

    JTextField Quantity_Field = new JTextField();
    JTextField Total_Field = new JTextField();

    JTextField TotalAmount_Field = new JTextField();
    JTextField Cash_Field = new JTextField();
    JTextField Change_Field = new JTextField();
    JTextField update_field = new JTextField();
/////////////////////////////END OF TEXTFILEDS//////////////////////////

//////////////////////LABEL///////////////////
    JLabel search_label = new JLabel("SEARCH ITEM");
    JLabel Quantity_label = new JLabel("QUANTITY");
    JLabel Total_label = new JLabel("TOTAL");

    JLabel ItemCode = new JLabel("ITEM CODE");
    JLabel ItemName = new JLabel("ITEM NAME");
    JLabel Price = new JLabel("PRICE");
    JLabel Stock = new JLabel("STOCK");

    JLabel TotalAmount_label = new JLabel("Total Amount:");
    JLabel Cash_label = new JLabel("CASH:");
    JLabel Change_label = new JLabel("CHANGE:");

    JLabel Time_Date = new JLabel();
    JLabel Time_Date1 = new JLabel();
    //////////////////END OF LABEL///////////////////////////////////////////
    //////////////////////////////////
    ////////////////////////
    JTable Table_Of_Product = new JTable();
    DefaultTableModel FirstModel = (DefaultTableModel) Table_Of_Product.getModel();
    JScrollPane JScrollPane11 = new JScrollPane();

//////////////////////////////TEXTAREA ////
    JTextArea Area = new JTextArea();
    JScrollPane AreaPane12 = new JScrollPane();

    JLabel p = new JLabel();

    ////////////////////////////////////////////////
    /////////////////button/////////
    JButton Add_Button = new JButton("ADD TO CART");
    JButton Remove_Button = new JButton("REMOVE TO CART");
    JButton Process_Button = new JButton("PROCESS");
    JButton Print_Button = new JButton("PRINT");
    JButton Receipt_Button = new JButton("GET RECEIPT");
    /////////////////button//////////////////

    public Main_frame() {

        frame.setSize(1500, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(frame);

        frame.setJMenuBar(main_menu_bar);
        main_menu_bar.add(main_menu);
//        main_menu_bar.add(menu_add);
//        main_menu_bar.add(menu_sold);
//        main_menu_bar.add(menu_out);
        main_menu.setText("BACK");

        main_menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Buttons();
            }
        });

        ////////////////////////////
/////////////////////fields///////////////s
        frame.add(Search_Field);
        frame.add(Search1_Field);
        frame.add(ItemCode_Field);
        frame.add(Item_Field);
        frame.add(Price_Field);
        frame.add(Stock_Field);
        frame.add(Quantity_Field);
        frame.add(Total_Field);
        frame.add(Cash_Field);
        frame.add(Change_Field);
        frame.add(TotalAmount_Field);
        frame.add(update_field);

        Search_Field.setHorizontalAlignment(JTextField.CENTER);
        ItemCode_Field.setHorizontalAlignment(JTextField.CENTER);
        Item_Field.setHorizontalAlignment(JTextField.CENTER);
        Price_Field.setHorizontalAlignment(JTextField.CENTER);
        Stock_Field.setHorizontalAlignment(JTextField.CENTER);
        Quantity_Field.setHorizontalAlignment(JTextField.CENTER);
        Total_Field.setHorizontalAlignment(JTextField.CENTER);
        Cash_Field.setHorizontalAlignment(JTextField.CENTER);
        Change_Field.setHorizontalAlignment(JTextField.CENTER);
        TotalAmount_Field.setHorizontalAlignment(JTextField.CENTER);
        update_field.setHorizontalAlignment(JTextField.CENTER);
        update_field.hide();
        Search_Field.setBounds(20, 10, 300, 30);
        Search1_Field.setBounds(910, 0, 5, 800);
        ItemCode_Field.setBounds(20, 220, 150, 30);
        Item_Field.setBounds(180, 220, 200, 30);
        Price_Field.setBounds(400, 220, 100, 30);
        Stock_Field.setBounds(520, 220, 100, 30);
        Quantity_Field.setBounds(650, 220, 100, 30);
        Total_Field.setBounds(770, 220, 100, 30);
        update_field.setBounds(70, 610, 100, 30);

        Cash_Field.setBounds(1100, 80, 200, 30);
        Change_Field.setBounds(1100, 130, 200, 30);

        TotalAmount_Field.setBounds(1100, 20, 200, 40);

        Search1_Field.disable();
        // TotalAmount_Field.setFont(new java.awt.Font("Arial", 3, 18));
//////////////////////////end of fields/////////////

////////////////label/////////////////////////
        frame.add(ItemCode);
        ItemCode.setBounds(30, 250, 150, 30);
        ItemCode.setForeground(Color.white);

        frame.add(ItemName);
        ItemName.setBounds(210, 250, 200, 30);
        ItemName.setForeground(Color.white);

        frame.add(Price);
        Price.setBounds(420, 250, 100, 30);
        Price.setForeground(Color.white);

        frame.add(Stock);
        Stock.setBounds(540, 250, 100, 30);
        Stock.setForeground(Color.white);

        frame.add(search_label);
        search_label.setBounds(120, 30, 200, 40);
        search_label.setForeground(Color.white);

        frame.add(Time_Date);
        Time_Date.setBounds(400, 10, 200, 40);
        Time_Date.setFont(new java.awt.Font("Arial", 3, 18));
        Time_Date.setForeground(Color.white);

        frame.add(Time_Date1);
        Time_Date1.setBounds(550, 10, 300, 40);
        Time_Date1.setFont(new java.awt.Font("Arial", 3, 18));
        Time_Date1.setForeground(Color.white);

        frame.add(Quantity_label);
        Quantity_label.setBounds(670, 250, 100, 30);
        Quantity_label.setForeground(Color.white);

        frame.add(Total_label);

        Total_label.setBounds(790, 250, 100, 30);
        Total_label.setForeground(Color.white);

        frame.add(TotalAmount_label);
        TotalAmount_label.setBounds(950, 30, 200, 30);
        TotalAmount_label.setFont(new java.awt.Font("Arial", 3, 18));
        TotalAmount_label.setForeground(Color.white);

        frame.add(Cash_label);
        Cash_label.setBounds(1000, 80, 200, 30);
        Cash_label.setFont(new java.awt.Font("Arial", 3, 18));
        Cash_label.setForeground(Color.white);

        frame.add(Change_label);
        Change_label.setBounds(1000, 130, 200, 30);
        Change_label.setFont(new java.awt.Font("Arial", 3, 18));
        Change_label.setForeground(Color.white);
//////////////end of label////////////////////////
/////////////////////////button//////////
        frame.add(Add_Button);
        Add_Button.setBounds(60, 300, 300, 40);

        frame.add(Remove_Button);
        Remove_Button.setBounds(400, 300, 300, 40);

        frame.add(Process_Button);
        Process_Button.setBounds(300, 610, 300, 50);

        frame.add(Print_Button);
        Print_Button.setBounds(1000, 610, 300, 40);
         Print_Button.hide();

        frame.add(Receipt_Button);
        Receipt_Button.setBounds(1000, 180, 300, 40);
////////////////////////////end of button////////////////////////
        AreaPane12.setBounds(950, 250, 400, 350);
        frame.add(AreaPane12);
        AreaPane12.setViewportView(Area);
        AreaPane12.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

//        Area.setText("-- RECEIPT --\n\n"
//                + "CUSTOMER NAME: " + "\n\n"
//                + "-- THANK YOU! --");
////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
        JScrollPane11.setBounds(20, 60, 850, 150);
        frame.add(JScrollPane11);
        JScrollPane11.setViewportView(Table_Of_Product);
        Table_Of_Product.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table_Of_Product.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JScrollPane11.setOpaque(false);
        JScrollPane11.getViewport().setOpaque(false);
        //  table.getTableHeader().setReorderingAllowed(true);
        Table_Of_Product.setOpaque(false);
        ((DefaultTableCellRenderer) Table_Of_Product.getDefaultRenderer(Object.class)).setOpaque(false);
        Table_Of_Product.setShowGrid(false);
        Table_Of_Product.setEnabled(true);
        Table_Of_Product.setShowGrid(true);
        Table_Of_Product.setGridColor(new Color(51, 51, 51, 255));

        Table_Of_Product.setSelectionForeground(Color.white);
        Table_Of_Product.setSelectionBackground(new Color(51, 51, 51, 255));

        Table_Of_Product.getTableHeader().setBackground(new Color(51, 51, 51, 255));
        Table_Of_Product.getTableHeader().setForeground(new Color(255, 255, 255, 255));
        Table_Of_Product.getTableHeader().setFont(new java.awt.Font("Arial", 3, 12));
        Table_Of_Product.setRowHeight(20);

        JScrollPane11.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        FirstModel.addColumn("CODE no");
        FirstModel.addColumn("Product Name:");
        FirstModel.addColumn("Stock:");
        FirstModel.addColumn("Price:");

//      
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);

        Table_Of_Product.getColumnModel().getColumn(0).setCellRenderer(cr);
        Table_Of_Product.getColumnModel().getColumn(1).setCellRenderer(cr);
        Table_Of_Product.getColumnModel().getColumn(2).setCellRenderer(cr);
        Table_Of_Product.getColumnModel().getColumn(3).setCellRenderer(cr);

        Display();

        Table_Of_Product.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {

                String dataTable_noproduct = (String) Table_Of_Product.getValueAt(Table_Of_Product.getSelectedRow(), 0);
                String dataTable_name = (String) Table_Of_Product.getValueAt(Table_Of_Product.getSelectedRow(), 1);
                String dataTable_Stock = (String) Table_Of_Product.getValueAt(Table_Of_Product.getSelectedRow(), 2);
                String dataTable_price_product = (String) Table_Of_Product.getValueAt(Table_Of_Product.getSelectedRow(), 3);
                //    String dataTable_Total_product = (String) table.getValueAt(table.getSelectedRow(), 3);

                ItemCode_Field.setText(dataTable_noproduct);
                Item_Field.setText(dataTable_name);
                Stock_Field.setText(dataTable_Stock);
                Price_Field.setText(dataTable_price_product);
                //  Total_Field.setText(dataTable_Total_product);
                Total_Field.setText("");
                Quantity_Field.setText("");
            }

        });
/////////////////////////////////////////
//////////////////////////////////////////
        Receipt_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                 Area.setColumns(50);
//        Area.setRows(50);

                Area.setFont(new java.awt.Font("Arial Black", 8, 6));

                String cash = Cash_Field.getText().toString();
                String amount = TotalAmount_Field.getText().toString();
                String change = Change_Field.getText().toString();
                Area.append("*******************************************************" + "\n");
                Area.append("OLYMPUS GROCERY STORE");
                Area.append("\n");
                Area.append("NARCISO STREET< SURIGAO CITY");
                Area.append("\n");
                Area.append("\n");
                Area.append("----------------------------------------------*" + "\n");
                int nrow = Model.getRowCount(), ncol = Model.getColumnCount();
                Object[][] tableData = new Object[nrow][ncol];
                for (int i = 0; i < nrow; i++) {
                    for (int j = 0; j < ncol; j++) {
                        tableData[i][j] = Model.getValueAt(i, j);

                        Area.append((String) tableData[i][j] + "\t");
                    }
                    Area.append("\n");
                    Area.append("\n");
                    Area.append("\n");
                    Area.append("\n");

                }

                Area.append("*******Cash = " + cash + "\n");
                Area.append("*******Total Amount = " + amount + "\n");
                Area.append("*******Change" + change + "\n");
                Area.append("----------------------------------------------*" + "\n");
                 Print_Button.show();
            }

        });

        Process_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                double sum2 = 0;
                for (int i = 0; i < Table_0f_Cart.getRowCount(); i++) {
                    sum2 = sum2 + Integer.parseInt(Table_0f_Cart.getValueAt(i, 5).toString());

                }
                //  TotalAmount_Field.setText(sum2);
                TotalAmount_Field.setText(Double.toString(sum2));
                TotalAmount_Field.setFont(new java.awt.Font("Arial", 3, 20));
                TotalAmount_Field.setForeground(Color.red);

            }

        });

        Quantity_Field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                double number_of_quantity = Double.parseDouble(Quantity_Field.getText());
                double number_of_prize = Double.parseDouble(Price_Field.getText());

                double sum = number_of_quantity * number_of_prize;

                Total_Field.setText("₱ " + sum);
                Total_Field.setFont(new java.awt.Font("Arial", 3, 16));
                Total_Field.setForeground(Color.red);
                Search_Field.setText("");
            }

        });

        Cash_Field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                double number_of_TotalAmount = Double.parseDouble(TotalAmount_Field.getText());
                double number_of_Cash = Double.parseDouble(Cash_Field.getText());

                //  double sum1 = number_of_TotalAmount - number_of_Cash;
                double sum1 = number_of_Cash - number_of_TotalAmount;

                Change_Field.setText("₱ " + sum1);
                Change_Field.setFont(new java.awt.Font("Arial", 3, 16));
                Cash_Field.setFont(new java.awt.Font("Arial", 3, 16));
                Change_Field.setForeground(Color.red);
                //   Change_Field.setText("");
            }

        });
//////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
        //////////////////////////firsttable////////////
        JScrollPane1.setBounds(20, 350, 850, 250);
        frame.add(JScrollPane1);
        JScrollPane1.setViewportView(Table_0f_Cart);
        Table_0f_Cart.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Table_0f_Cart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        //  table.getTableHeader().setReorderingAllowed(true);
        //  table.getTableHeader().setReorderingAllowed(true);
        JScrollPane1.setOpaque(false);
        JScrollPane1.getViewport().setOpaque(false);

        Table_0f_Cart.setOpaque(false);
        ((DefaultTableCellRenderer) Table_0f_Cart.getDefaultRenderer(Object.class)).setOpaque(false);
        Table_0f_Cart.setShowGrid(false);

        Table_0f_Cart.setEnabled(true);
        Table_0f_Cart.setShowGrid(true);
        Table_0f_Cart.setGridColor(new Color(51, 51, 51, 255));

        Table_0f_Cart.setForeground(Color.white);
        Table_0f_Cart.setSelectionForeground(Color.white);
        Table_0f_Cart.setSelectionBackground(new Color(51, 51, 51, 255));

        Table_0f_Cart.getTableHeader().setBackground(new Color(51, 51, 51, 255));
        Table_0f_Cart.getTableHeader().setForeground(new Color(255, 255, 255, 255));
        Table_0f_Cart.getTableHeader().setFont(new java.awt.Font("Arial", 3, 12));
        Table_0f_Cart.setRowHeight(40);

        JScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        Model.addColumn("Product_code:");
        Model.addColumn("Date:");
        Model.addColumn("Item Name");
        Model.addColumn("Quantity");
        Model.addColumn("Price");
        Model.addColumn("Total");

        Table_0f_Cart.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {

                String dataTable_noproduct = (String) Table_0f_Cart.getValueAt(Table_0f_Cart.getSelectedRow(), 0);
                String dataTable_name = (String) Table_0f_Cart.getValueAt(Table_0f_Cart.getSelectedRow(), 2);
                String dataTable_Stock = (String) Table_0f_Cart.getValueAt(Table_0f_Cart.getSelectedRow(), 3);
                String dataTable_price_product = (String) Table_0f_Cart.getValueAt(Table_0f_Cart.getSelectedRow(), 4);
                String dataTable_Total_product = (String) Table_0f_Cart.getValueAt(Table_0f_Cart.getSelectedRow(), 5);
                
                 
                ItemCode_Field.setText(dataTable_noproduct);
                Item_Field.setText(dataTable_name);
                Search_Field.setText(dataTable_name);
                Quantity_Field.setText(dataTable_Stock);
                // Stock_Field.setText(dataTable_Stock);
                Price_Field.setText(dataTable_price_product);
                Total_Field.setText(dataTable_Total_product);
//                Total_Field.setText("");
//                Quantity_Field.setText("");
            }

        });
  Table_0f_Cart.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {

               
                
            }

        });
        ////////////////////////////////
        /////////////////////////////////INSERT
        /////////////////////////////////
        Quantity_Field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int number_of_stock = Integer.parseInt(Stock_Field.getText());
                int number_of_quantity = Integer.parseInt(Quantity_Field.getText());

                int sum = number_of_stock - number_of_quantity;

                update_field.setText("" + sum);
                update_field.setFont(new java.awt.Font("Arial", 3, 16));
                update_field.setForeground(Color.red);
                Search_Field.setText("");
            }

        });
        Add_Button.addMouseListener(new MouseAdapter() {
//update
            public void mouseClicked(MouseEvent evt) {
                Connection con = null;
                try {
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    int row = Table_Of_Product.getSelectedRow();
                    String valuex = (Table_Of_Product.getModel().getValueAt(row, 0).toString());
                    java.sql.PreparedStatement ps = con.prepareStatement("UPDATE `Pro_x` SET `product_name`=?,`quantity`=?,`price`=? WHERE `no_product`=?");

                    ps.setString(1, Item_Field.getText());
                    ps.setString(2, update_field.getText());
                    ps.setString(3, Price_Field.getText());
                    ps.setString(4, ItemCode_Field.getText());
                    ps.execute();
//                    for (int i = 0; i < Table.getRowCount() +1; i++) {
//                        COUNT.setText(Integer.toString(i));
//                    }

                    JOptionPane.showMessageDialog(frame, "Table Updated", "Table Updated", JOptionPane.INFORMATION_MESSAGE);
                    refresh22();
                    table_reload22();

//                   frame.dispose();
//                    new Table();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        Add_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double number_of_quantity = Double.parseDouble(Quantity_Field.getText());
                double number_of_prize = Double.parseDouble(Price_Field.getText());

                double sum = number_of_quantity * number_of_prize;
                Total_Field.setText(Double.toString(sum));

                try {
                    Connection con = null;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO `sold_product`(`item_code`,`date`,`item_name`,`item_quantity`,`item_price`,`item_total`) values(?,?,?,?,?,?)");

                    ps.setString(1, ItemCode_Field.getText());
                    ps.setString(2, Time_Date.getText() + Time_Date1.getText());
                    ps.setString(3, Item_Field.getText());
                    ps.setString(4, Quantity_Field.getText());
                    ps.setString(5, Price_Field.getText());
                    ps.setString(6, Total_Field.getText());
                    ps.execute();

                    refresh1();
                    Display1();

                    ItemCode_Field.setText("");
                    Item_Field.setText("");
                    Quantity_Field.setText("");
                    Price_Field.setText("");
                    Total_Field.setText("");
                    Stock_Field.setText("");
                    Search_Field.setText("");

                    JOptionPane.showMessageDialog(frame, " Add Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        /////////////////////end firsttable//////////////////

        Display1();

        //////////////////////////////////////////INSERT @32
        //////////////////////////////
        Print_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

//                
                try {

                    Connection con = null;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO view_sold_product SELECT * FROM sold_product");

                    ps.execute();

                    ItemCode_Field.setText("");
                    Item_Field.setText("");
                    Quantity_Field.setText("");
                    Price_Field.setText("");
                    Total_Field.setText("");

                    JOptionPane.showMessageDialog(frame, " Add another table", "Information", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        /////////////////////////////////////end of insert view _sold _product//////////////////
        /////////////////////
        /////////////////////

        Print_Button.addMouseListener(new MouseAdapter() {
//delete 

            public void mouseClicked(MouseEvent evt) {

                Connection con = null;
                try {
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");

                    String query = "DELETE FROM sold_product";
                    java.sql.PreparedStatement pst = con.prepareStatement(query);
                    pst.execute();

                    refresh1();
                    table_reload1();

                    Cash_Field.setText("");
                    Change_Field.setText("");
                    TotalAmount_Field.setText("");

                } catch (SQLException ex) {
                    Logger.getLogger(Main_frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                // frame1.show();
            }

        });

        Remove_Button.addMouseListener(new MouseAdapter() {
//delete 

            public void mouseClicked(MouseEvent evt) {

                Connection con = null;
                try {

                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    int row = Table_0f_Cart.getSelectedRow();
                    String value = (Table_0f_Cart.getModel().getValueAt(row, 0).toString());
                    String query = "DELETE FROM sold_product WHERE item_code = " + value;
                    java.sql.PreparedStatement ps = con.prepareStatement(query);
                    ps.execute();

                    JOptionPane.showMessageDialog(null, "Delete Successfully", "Delete Successfully", JOptionPane.INFORMATION_MESSAGE);
//            
                    refresh1();
                    table_reload1();

//                    Cash_Field.setText("");
//                    Change_Field.setText("");
//                    TotalAmount_Field.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(Main_frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                // frame1.show();
            }

        });
        ///////////////////////SECOND TABLE/////////////////////////////////
        ///////////////////////END OF SECOND TABLE/////////////////////////////
        /////////////////////////////////////,search/////////////////////
        Search_Field.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    Connection con = null;
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM `Pro_x`  WHERE  `no_product` LIKE ? OR`product_name` LIKE ? OR `quantity` LIKE ? OR `price` LIKE ?");
                    pst.setString(1, Search_Field.getText());
                    pst.setString(2, Search_Field.getText());
                    pst.setString(3, Search_Field.getText());
                    pst.setString(4, Search_Field.getText());

                    pst.execute();
                    ResultSet rs = pst.executeQuery();
                    refresh();

                    ItemCode_Field.setText("");
                    Item_Field.setText("");
                    Stock_Field.setText("");
                    Price_Field.setText("");

                    if (rs.next() == true) {
                        String data[] = {rs.getString("no_product"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")};
                        FirstModel.addRow(data);

                    }

                    if (Search_Field.getText().equals("")) {
                        Display();

                    }

                } catch (SQLException ex) {

                    Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        ////////////////////second logic of search///
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat fo = new SimpleDateFormat("hh:mm:ss a");

                Time_Date.setText(fo.format(d));
            }

        }).start();

        Date d = new Date();

        SimpleDateFormat fo = new SimpleDateFormat(" EEEEEEEEEE  MMMMMMMMM: dd :yyyy");

        Time_Date1.setText(fo.format(d));

        //////////////////////////////end of search/./////////////////////////
        frame.add(p);
        p.setBounds(0, 0, 1500, 700);
        p.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(1500, 700, Image.SCALE_SMOOTH)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.show();

    }

    public static void main(String[] args) {

        Main_frame frame = new Main_frame();
    }

//    void showtime() {
//
//    }
//
//    void showdate() {
//
//    }
    /////////////////////////////////////////////////////////////////
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
                FirstModel.addRow(data);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////////////////////////
    public void Display1() {

//       
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("select * from sold_product");
            ps.execute();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("item_code"), rs.getString("date"), rs.getString("item_name"), rs.getString("item_quantity"), rs.getString("item_price"), rs.getString("item_total")};
                Model.addRow(data);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ////////////////////////////////////////////

    public void refresh() {

        int rowCount = FirstModel.getRowCount();
        for (int x = rowCount - 1; x >= 0; x--) {
            FirstModel.removeRow(x);

        }

    }
    //////////////////////////////////////////

    public void refresh1() {

        int rowCount = Model.getRowCount();
        for (int x = rowCount - 1; x >= 0; x--) {
            Model.removeRow(x);

        }

    }
/////////////////////////////

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
                FirstModel.addRow(data);

                //   btn1.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main_frame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ////////////////////////////////////////////////

    public void table_reload1() {

//      
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT * from sold_product");
            ps.execute();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("item_code"), rs.getString("date"), rs.getString("item_name"), rs.getString("item_quantity"), rs.getString("item_price"), rs.getString("item_total")};
                Model.addRow(data);

                //   btn1.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main_frame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    ////////////////////////////////////////////////

    public void table_reload22() {

//        Model = (DefaultTableModel) table.getModel();
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT * from pro_x");
            ps.execute();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String data[] = {rs.getString("no_product"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")};
                FirstModel.addRow(data);

                //   btn1.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Add_pro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refresh22() {

        int rowCount = FirstModel.getRowCount();
        for (int x = rowCount - 1; x >= 0; x--) {
            FirstModel.removeRow(x);

        }

    }

}
