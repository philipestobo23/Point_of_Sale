package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Buttons {

    JFrame frame = new JFrame();
    JInternalFrame frame1 = new JInternalFrame("LOG IN");

    ////////////////////MENU//////////////////
    JMenuBar main_menu_bar = new JMenuBar();
    JMenu main_menu = new JMenu("ACCOUNT");
    JMenuItem menu_account = new JMenuItem("CREATE ACCOUNT");
    JMenu menu_add = new JMenu("VIEW PRODUCTS");
    JMenu menu_sold = new JMenu("VIEW SOLD PRODUCTs");
    JMenu menu_out = new JMenu("LOGOUT");

    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JLabel add = new JLabel("ADD PRODUCT");
    JLabel pos = new JLabel("POINT OF SALE");
    JLabel sold = new JLabel("SOLD PRODUCT");
    JLabel cashier = new JLabel("CASHIER ATTENDANT");
    JLabel admin = new JLabel("ADMIN");
    JLabel out = new JLabel("LOGOUT");
    JLabel panel = new JLabel();
    JButton panel1 = new JButton();
    
   

    
    
    public Buttons() {

        frame.setSize(1200, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(frame);
 
      
        frame.add(add);
        add.setBounds(200, 600, 200, 30);
        add.setForeground(Color.white);
        add.setFont(new java.awt.Font("Century", 2, 17));

        frame.add(sold);
        sold.setBounds(860, 600, 200, 30);
        sold.setForeground(Color.white);
        sold.setFont(new java.awt.Font("Century", 2, 17));

        frame.add(pos);
        pos.setBounds(550, 600, 200, 30);
        pos.setForeground(Color.white);
        pos.setFont(new java.awt.Font("Century", 2, 17));

        frame.add(cashier);
        cashier.setBounds(550, 300, 200, 30);
        cashier.setForeground(Color.white);
        cashier.setFont(new java.awt.Font("Century", 2, 17));

        frame.add(admin);
        admin.setBounds(200, 300, 200, 30);
        admin.setForeground(Color.white);
        admin.setFont(new java.awt.Font("Century", 2, 17));

        frame.add(out);
        out.setBounds(880, 300, 200, 30);
        out.setForeground(Color.white);
        out.setFont(new java.awt.Font("Century", 2, 17));

//        frame.setJMenuBar(main_menu_bar);
//        main_menu_bar.add(main_menu);
//        main_menu_bar.add(menu_add);
//        main_menu_bar.add(menu_sold);
//        main_menu_bar.add(menu_out); 
        frame.add(button1);
        button1.setBounds(150, 380, 200, 200);
        //  button1.setText("ADD PRODUCT");
        button1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/add.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//        button1.setBackground(new Color(51, 51, 51, 255));
//        button1.setForeground(new Color(255, 0, 0, 255));
        button1.setOpaque(false);
        button1.setFont(new java.awt.Font("Century", 2, 17));

        button1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                frame.dispose();
                try {
                    new Add_pro();
                } catch (SQLException ex) {
                    Logger.getLogger(PROJECT.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        frame.add(button2);
        button2.setBounds(500, 380, 200, 200);
        //     button2.setText("POINT OF SALE");
        button2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/images.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//        button2.setBackground(new Color(51, 51, 51, 255));
//        button2.setForeground(new Color(255, 0, 0, 255));
        button2.setOpaque(false);
        button2.setFont(new java.awt.Font("Century", 2, 17));

        button2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                frame.dispose();
                new Main_frame();

            }

        });

        frame.add(button3);
        button3.setBounds(850, 380, 200, 200);
        // button3.setText("\n" +"PRODUCT SOLD");
        button3.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/sold.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//        button3.setBackground(new Color(51, 51, 51, 255));
//        button3.setForeground(new Color(255, 0, 0, 255));
        button3.setOpaque(false);
        button3.setFont(new java.awt.Font("Century", 2, 17));
        button3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
               
          
            
              frame.dispose();
                new Product_Sold();

            }

        });
        frame.add(button4);
        button4.setBounds(500, 80, 200, 200);
        // button3.setText("\n" +"PRODUCT SOLD");
        button4.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/cashh.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//        button3.setBackground(new Color(51, 51, 51, 255));
//        button3.setForeground(new Color(255, 0, 0, 255));
        button4.setOpaque(false);
        button4.setFont(new java.awt.Font("Century", 2, 17));
        button4.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {

                frame.dispose();
                new Product_Sold();

            }

        });
        frame.add(button5);
        button5.setBounds(150, 80, 200, 200);
        // button3.setText("\n" +"PRODUCT SOLD");
        button5.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/admin.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//        button3.setBackground(new Color(51, 51, 51, 255));
//        button3.setForeground(new Color(255, 0, 0, 255));
        button5.setOpaque(false);
        button5.setFont(new java.awt.Font("Century", 2, 17));
        button5.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {

                frame.dispose();
                new admin();

            }

        });
        frame.add(button6);
        button6.setBounds(850, 80, 200, 200);
        // button3.setText("\n" +"PRODUCT SOLD");
        button6.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/out.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
//        button3.setBackground(new Color(51, 51, 51, 255));
//        button3.setForeground(new Color(255, 0, 0, 255));
        button6.setOpaque(false);
        button6.setFont(new java.awt.Font("Century", 2, 17));
        button6.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                String path = "/PROJECT/icons8_shutdown_24px_3.png";
                URL url = this.getClass().getResource(path);

                System.out.println(url);
                javax.swing.ImageIcon icon = new javax.swing.ImageIcon(url);
                int x = JOptionPane.showConfirmDialog(frame, "Are you Sure you Want to Log Out?", "LOGOUT", JOptionPane.OK_OPTION);
                if (x == 0) {
                    frame.dispose();
                    new PROJECT();

                }
                if (x == 1) {
                    frame.show();
//               
                }

            }

        });
        
      
        
        
        frame.add(panel);
        panel.setBounds(0, 0, 1200, 800);
        panel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH)));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.show();
    }

    public static void main(String[] args) {
        Buttons frame = new Buttons();
    }
 
//    public void refresh() {
//          frame.add(frame1);
//         frame1.setLocation(400,200);
//          frame1.setSize(800, 500);
//       frame1.setLayout(null);
//       frame1.setVisible(true);
//       
//         frame1.add(panel1);
//        panel1.setBounds(0, 0, 100, 800);
//        panel1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH)));
// frame1.moveToFront();
//       
//       frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
//        
//    }
}
