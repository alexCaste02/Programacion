package otros;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Drawing extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Drawing();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);



    }

//    public void paint(Graphics g) {
//        g.fillOval(x, y, 200, 200);
//
//        while(true){
//
//        }
//    }
//    public void moveBall(Graphics g) {
//
//        x++;
//        y++
//    }




}
