package Fisicas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class AstroImagen {

    private Point velocidad;
    private boolean fijo;

    private double masa;
    JFrame frame;



    private static int idCounter;
    private final int id;

    public AstroImagen(String cadena, double masa, boolean fijo, int posX, int posY, int sizeX, int sizeY) throws IOException {
//        super(cadena);
        
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setAlwaysOnTop(true);

        BufferedImage img= ImageIO.read(new File("UD_13/Resources/Terran1.png"));
        ImageIcon icon=new ImageIcon(img);
        this.frame=new JFrame(cadena);
        frame.setLayout(new FlowLayout());
        frame.setBounds(posX,posY,sizeX,sizeY);
//        frame.setSize(sizeX,sizeY);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



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
        return frame.getLocation();
    }

    public void setPosicion(Point posicion) {
        if(posicion.x+frame.getWidth()>1920) posicion.x=1920-frame.getWidth();
        if(posicion.x<0) posicion.x=0;
        if(posicion.y+frame.getHeight()>1080) posicion.y=1080-frame.getHeight();
        if(posicion.y<0) posicion.y=0;

        frame.setLocation(posicion);
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
}
