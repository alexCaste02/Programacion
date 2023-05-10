package Fisicas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class DisplayImage {


    public static void main(String avg[]) throws IOException
    {
        DisplayImage abc=new DisplayImage();

//        for (int i = 0; i < 1000; i++) {
//            Thread.sleep(100);
//            abc.
//        }

    }

    public DisplayImage() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("UD_13/Resources/Terran1.png"));
        img=resize(img,50,50);
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        frame.setLayout(new FlowLayout());
        frame.setBounds(100,100,100,100);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}