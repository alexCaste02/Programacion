import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Prueba {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("lol");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setAlwaysOnTop(true);
        ventana.setLocation(10, 10);
        ventana.setSize(100, 100);
        ventana.setVisible(true);

        int m = 1;

        final Point[] velocidad = {new Point(1, 1)};
        Point pos = ventana.getLocation();

        BufferedImage offscreen = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = offscreen.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g2d.clearRect(0, 0, 1920, 1080);
                g2d.fillOval(pos.x, pos.y, 100, 100);
                ventana.getGraphics().drawImage(offscreen, 0, 0, null);

                pos.translate(velocidad[0].x, velocidad[0].y);
                ventana.setLocation(pos);

                if (pos.getY() + 100 >= 1080 || pos.getY() <= 0) {
                    velocidad[0] = new Point(velocidad[0].x, -velocidad[0].y);
                }

                if (pos.getX() + 100 >= 1920 || pos.getX() <= 0) {
                    velocidad[0] = new Point(-velocidad[0].x, velocidad[0].y);
                }

                if (velocidad[0].x < 0) {
                    velocidad[0] = new Point(velocidad[0].x - m, velocidad[0].y);
                } else {
                    velocidad[0] = new Point(velocidad[0].x + m, velocidad[0].y);
                }

                if (velocidad[0].y < 0) {
                    velocidad[0] = new Point(velocidad[0].x, velocidad[0].y - m);
                } else {
                    velocidad[0] = new Point(velocidad[0].x, velocidad[0].y + m);
                }
            }
        });

        timer.start();
    }
}