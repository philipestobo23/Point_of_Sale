package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading {

    JFrame frame = new JFrame("Loading....");
    JProgressBar pb = new JProgressBar(0, 3000);

    JLabel background = new JLabel();

    JLabel book = new JLabel();
    JLabel txt = new JLabel("LOADING");
    JLabel wait = new JLabel("WAIT");
    //    Container c=f5.getContentPane();
    Font fnt = new Font("Arial", Font.BOLD, 20);

    public Loading() {
        book.setBounds(120, 180, 100, 100);
        frame.add(book);

        // c.setBackground(new Color(100,200,10,109));
        pb.setBounds(70, 110, 200, 30);//progress bar
        pb.setStringPainted(true);
        pb.setBackground(Color.white);
        pb.setForeground(Color.black);
        pb.setValue(0);
        frame.add(pb);

        txt.setBounds(140, 30, 200, 50);
        frame.add(txt);
        txt.setForeground(Color.red);
        txt.setFont(fnt);

        wait.setBounds(100, 150, 200, 20);
        frame.add(wait);

        frame.setBounds(420, 140, 350, 400);
        //  f5.setIconImage(loadImg.getImage());

        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(background);
        background.setBounds(0, 0, 350, 600);
        background.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/PROJECT/si.jpg")).getImage().getScaledInstance(350, 600, Image.SCALE_SMOOTH)));

        int i = 0;
        while (i <= 3000) {
            pb.setValue(i);
            i += 10;
            try {
                Thread.sleep(50);
                if (i == 3000) {
                    frame.dispose();
                    new Buttons();
                }
            } catch (Exception e) {
            }
        }

    }

    public static void main(String[] args) {

        Loading frame = new Loading();

    }

}
