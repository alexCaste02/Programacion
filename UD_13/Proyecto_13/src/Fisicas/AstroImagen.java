package Fisicas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class AstroImagen extends  JFrame{

    private Point velocidad;
    private boolean fijo;

    private double masa;




    private static int idCounter;
    private final int id;

    public AstroImagen(String cadena, double masa, boolean fijo, int posX, int posY, int sizeX, int sizeY) {
        super(cadena);

        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("UD_13/Resources/Terran1.png"));
        } catch (IOException e) {
            System.out.println("puto cagaste");
        }

        if(!fijo) {
            img = resize(img, 100, 100);
            ImageIcon icon = new ImageIcon(img);

            setUndecorated(true);
            setBackground(new Color(0, 0, 0, 0));
            setLayout(new FlowLayout());

            JLabel lbl = new JLabel();
            lbl.setIcon(icon);
            add(lbl);
        }
        setBounds(posX, posY, sizeX, sizeY);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);




        this.fijo=fijo;
        this.masa=masa;
        this.velocidad= new Point();

        this.id=idCounter++;
    }

    public Point getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Point fuerza) {
        this.velocidad.translate((int) (fuerza.x/this.masa), (int) (fuerza.y/this.masa));
    }

    public boolean isFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }

    public Point getPosicion() {
        return getLocation();
    }

    public void setPosicion(Point posicion) {
        if(posicion.x+this.getWidth()>1920) posicion.x=1920-this.getWidth();
        if(posicion.x<0) posicion.x=0;
        if(posicion.y+this.getHeight()>1080) posicion.y=1080-this.getHeight();
        if(posicion.y<0) posicion.y=0;

        this.setLocation(posicion);
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AstroImagen astro = (AstroImagen) o;
        return id == astro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Astro{" +
                "velocidad=" + velocidad +
                ", fijo=" + fijo +
                ", posicion=" + getPosicion() +
                ", masa=" + masa +
                ", id=" + id +
                '}';
    }


    // [StackOverflow] cambia tamaño del bufferedimage
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
