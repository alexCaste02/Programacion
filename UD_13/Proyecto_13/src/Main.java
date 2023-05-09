import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("lol");

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocation(10,10);
        ventana.setSize(100,100);
        ventana.setAlwaysOnTop(true);

        int m = 1;

        Point velocidad = new Point(1,1);
        Point pos = ventana.getLocation();

        for (int t = 0; t < 10000; t++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pos.translate(velocidad.x,velocidad.y);

            ventana.setLocation(pos);

            if(pos.getY()+100>=1080 || pos.getY()<=0)
                velocidad= new Point(velocidad.x,-velocidad.y);

            if(pos.getX()+100>=1920 || pos.getX()<=0)
                velocidad = new Point(-velocidad.x,velocidad.y);

            if(velocidad.x < 0)
                velocidad = new Point(velocidad.x-m, velocidad.y);
            else
                velocidad = new Point(velocidad.x+m, velocidad.y);

            if (velocidad.y<0)
                velocidad = new Point(velocidad.x, velocidad.y-m);
            else
                velocidad = new Point(velocidad.x, velocidad.y+m);

            for (int i = 0; i < 255; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ventana.setBackground(new Color(i,0,0));
            }
        }



    }
}
