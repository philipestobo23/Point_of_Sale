    package project;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author Tito Orquina Mante
 */
public class PROJECT implements ActionListener {

    JFrame frame = new JFrame("LOG IN");

    JTextField txt1 = new JTextField();
    JTextField txt3 = new JTextField();
    JPasswordField txt2 = new JPasswordField();
    ImageIcon img = new ImageIcon("/JavaApplication2/Windows-10-user-icon-big.png");
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel lbl3 = new JLabel();
    JLabel lbl4 = new JLabel();
    JLabel logo = new JLabel();
    JLabel iconx = new JLabel();
    JLabel iconz = new JLabel();
    JButton btn1 = new JButton();
    JLabel btn2 = new JLabel();
    JPanel panel = new JPanel();
    JPanel p = new JPanel();
    JLabel icony = new JLabel();
     JProgressBar pb = new JProgressBar(0, 3000);

    JTextField m1 = new JTextField();
    JTextField m2 = new JTextField();

    //JProgressBar b = new JProgressBar();
    public PROJECT() {

        frame.setLayout(null);
        frame.setSize(700, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
        frame.setUndecorated(true);
        frame.getContentPane().setLayout(null);
        //Image icon = Toolkit.getDefaultToolkit().getImage("/frame1/giphy.gif");
        // frame.setIconImage(icon);
//frame.setLayout(null);
//        frame.add(p);
//        p.setSize(150, 150);
//        p.setLocation(80, 20);
//        p.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/frame1/giphy.gif")).getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
        frame.add(logo);
        logo.setSize(130, 130);
        logo.setLocation(460, 20);
        logo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/Windows-10-user-icon-big.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));

        
//         pb.setBounds(450, 400, 200, 30);//progress bar
//        pb.setStringPainted(true);
//        pb.setBackground(Color.white);
//        pb.setForeground(Color.black);
//        pb.setValue(0);
//        frame.add(pb);

 

//        
        frame.add(txt1);
        txt1.setBounds(420, 200, 200, 25);
        txt1.setOpaque(false);
        //  txt1.getHorizontalVisibility();
        txt1.setHorizontalAlignment(JTextField.CENTER);
        txt1.setBackground(new Color(153, 153, 153, 255));

        // txt1.setBackground(new Color(0,0,0,0));
        // txt1.setForeground(new Color(0, 153, 0, 255));
        frame.add(txt2);
        txt2.setBounds(420, 260, 200, 25);
        txt2.setHorizontalAlignment(JTextField.CENTER);
        txt2.setOpaque(false);
        txt2.setBackground(new Color(153, 153, 153, 255));
        // txt2.setBackground(new Color(0,0,0,0));
        // txt2.setForeground(new Color(0, 153, 0, 255));

        frame.add(lbl3);
        lbl3.setBounds(480, 150, 200, 25);
        lbl3.setText("LOG IN");
        lbl3.setFont(new java.awt.Font("Arial", 1, 20));
        //lbl3.setForeground(new Color(0, 153, 0, 255));
        //  lbl3.setBackground(new Color(22, 120, 2, 255));

        ///////////////////////////////
//        frame.add(m1);
//       m1.setBounds(630, 200, 20, 20);
//      m1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/frame1/icons8_error_24px_1.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
//   frame.getContentPane().add(m1);
//        frame.add(m2);
//        m2.setBounds(630, 255, 20, 40);
//        m2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/frame1/icons8_error_24px_1.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
//frame.getContentPane().add(m2);
        ///////////////////////////////
        frame.add(lbl1);
        lbl1.setBounds(378, 190, 40, 40);
        lbl1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_contacts_32px.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        lbl1.setFont(new java.awt.Font("Arial", 2, 12));

        frame.add(lbl2);
        lbl2.setBounds(380, 250, 40, 40);
        lbl2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_padlock_26px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        lbl2.setFont(new java.awt.Font("Arial", 2, 12));

        frame.add(btn1);
        btn1.setBounds(470, 315, 100, 30);
        btn1.setText("Login");
        btn1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/icons8_key_30px_1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        btn1.setBackground(new Color(51, 51, 51, 255));
        btn1.addActionListener(this);
        btn1.setFont(new java.awt.Font("Century", 1, 9));

//        frame.add(btn2);
//        btn2.setBounds(450, 390, 200, 30);
//        btn2.setText("Create Account");
//     //   btn2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/frame1/icons8_plus_32px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
//        btn2.setForeground(new Color(255, 255, 255, 255));
//        btn2.setFont(new java.awt.Font("Century", 2, 12));
//        btn2.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent evt) {
//                frame.hide();
//                new CreateAcc();
//
//            }
//
//        });
        frame.add(icony);
        icony.setBounds(672, 0, 200, 30);
        //    icony.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/frame1/icons8_close_window_26px.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        icony.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();

            }

        });

        frame.add(iconz);
        iconz.setBounds(40, 100, 300, 300);
        iconz.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/la.jpg")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

        frame.add(iconx);
        iconx.setBounds(0, 0, 700, 500);
        iconx.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(700, 510, Image.SCALE_SMOOTH)));
//
        
//        lbl1.setForeground(new Color(0, 153, 0, 255));
//        lbl2.setForeground(new Color(0, 153, 0, 255));
        btn1.setForeground(new Color(255, 255, 255, 255));
//        btn2.setForeground(new Color(0, 153, 0, 255));
        frame.setIconImage(img.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();

    }

    public static void main(String[] args) {

        PROJECT frame = new PROJECT();
    }

//    public void jPasswordFieldKeyPressed(KeyEvent ev) {
//        if (ev.getKeyCode() == KeyEvent.VK_ENTER) {
//
//            if (txt1.getText().equals("")) {
//                JOptionPane.showMessageDialog(frame, "PLEASE COMPLETE THE MANDATORY FIELDS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
//
//            }
//            if (txt2.getText().equals("")) {
//                JOptionPane.showMessageDialog(frame, "PLEASE COMPLETE THE MANDATORY FIELDS", "ERROR!!", JOptionPane.ERROR_MESSAGE);
//
//            } else {
//                try {
//
//                    Connection conn = null;
//                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_exo?zeroDateTimeBehavior=convertToNull", "root", "");
//                    java.sql.PreparedStatement pst = conn.prepareStatement("SELECT * FROM `acc` WHERE `Username` = ? and `Password` = ?");
//                    pst.setString(1, txt1.getText());
//                    pst.setString(2, txt2.getText());
//                    ResultSet rs = pst.executeQuery();
//                    if (rs.next() == true) {
//
//                        // JOptionPane.showMessageDialog(null, "Succesfully Log in");
//                        frame.dispose();
//                        new optionpane();
//                        conn.close();
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Wrong Credentials Invalid username or password", "ERROR!!", JOptionPane.ERROR_MESSAGE);
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(Frame1.class.getName()).log(Level.SEVERE, null, ex);
//
//                }
//
//            }
//
//        }
//
//    }
    @Override

    public void actionPerformed(ActionEvent e) {

//        if (e.getSource() == btn2) {
//            frame.dispose();
//            new CreateAcc();
//        }
        if (e.getSource() == btn1) {

            if (txt1.getText().equals("") || txt2.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "PLEASE COMPLETE THE MANDATORY FIELDS", "ERROR!!", JOptionPane.ERROR_MESSAGE);

            } else {
                try {

                    Connection conn = null;
                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_management?zeroDateTimeBehavior=convertToNull", "root", "");
                    java.sql.PreparedStatement pst = conn.prepareStatement("SELECT * FROM `acc` WHERE `Username` = ? and `Password` = ?");
                    pst.setString(1, txt1.getText());
                    pst.setString(2, txt2.getText());
                    ResultSet rs = pst.executeQuery();
                    if (rs.next() == true) {

                      
                     frame.dispose();
                    new Buttons();
                        conn.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Credentials Invalid username or password", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PROJECT.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

        }

        if (e.getSource() == btn2) {

            frame.dispose();

        }
        
    }
//    
}
