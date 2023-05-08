import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main2 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("lol");

        ventana.setVisible(true);

        int x = ThreadLocalRandom.current().nextInt(1920);
        int y = ThreadLocalRandom.current().nextInt(1080);
        ventana.setLocation(x,y);
        ventana.setSize(100,100);
        ventana.getBounds();
        ventana.setAlwaysOnTop(true);






    }
}
