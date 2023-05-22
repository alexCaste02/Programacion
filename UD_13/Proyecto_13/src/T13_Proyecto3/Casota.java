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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    static class Lamina extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(new Color(174, 226, 255));
            Rectangle2D fondo = new Rectangle2D.Double(0,0,500,500);
            g2.fill(fondo);

            g2.setColor(new Color(255, 229, 105));
            Ellipse2D sol = new Ellipse2D.Double(-100,-100,200,200);
            g2.fill(sol);

            g2.setColor(new Color(39, 55, 77));
            Rectangle2D cuadCasa = new Rectangle2D.Double(100,300,300,200);
            g2.fill(cuadCasa);

            g2.setColor(new Color(155, 164, 181));
            Rectangle2D chimenea = new Rectangle2D.Double(340,220,40,80);
            g2.fill(chimenea);

            //TODO: humo?

            g2.setColor(new Color(82, 109, 130));
            int[] pointsX = {100,400,250};
            int[] pointsY = {300,300,200};

            Polygon p = new Polygon(pointsX,pointsY,3);
            g2.fill(p);

            


        }
    }
}
