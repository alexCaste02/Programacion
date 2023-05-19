package T13_Proyecto3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Casota extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(Casota::new);
    }

    public Casota() throws HeadlessException {
        setSize(500,500);
        setContentPane(new Lamina());
        setVisible(true);
        setTitle("AlexTest");
        setLocationRelativeTo(null);
    }

    static class Lamina extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

//            g2.setColor(Color.BLACK);
//            Rectangle2D r1 = new Rectangle2D.Double(0,0,100,100);
//            g2.fill(r1);
//
//            g2.setColor(Color.BLUE);
//            Rectangle2D r2 = new Rectangle2D.Double(100,0,100,100);
//            g2.fill(r2);
//
//            g2.setColor(Color.GREEN);
//            Rectangle2D r3 = new Rectangle2D.Double(200,0,100,100);
//            g2.fill(r3);
//
//
//            g2.setColor(Color.RED);
//            Rectangle2D r4 = new Rectangle2D.Double(300,0,100,100);
//            g2.fill(r4);
//
//
//            g2.setColor(Color.YELLOW);
//            Rectangle2D r5 = new Rectangle2D.Double(400,0,100,100);
//            g2.fill(r5);
            g2.setColor(new Color(121, 224, 238));
            Rectangle2D fondo = new Rectangle2D.Double(0,0,500,500);
            g2.fill(fondo);

            g2.setColor(Color.ORANGE);
            Ellipse2D sol = new Ellipse2D.Double(-50,-50,100,100);
            g2.fill(sol);


        }
    }
}
