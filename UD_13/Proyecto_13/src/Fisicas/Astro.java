package Fisicas;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class Astro extends JFrame{

    private Point velocidad;
    private boolean fijo;

    private int masa=2;



    private static int idCounter;
    private final int id;

    public Astro(String cadena, boolean fijo, int x, int y){
        super(cadena);
        setBounds(x,y,200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        this.fijo=fijo;

        this.velocidad= new Point();

        this.id=idCounter++;
    }

    public Point getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Point velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }

    public Point getPosicion() {
        return this.getLocation();
    }

    public void setPosicion(Point posicion) {
        if(posicion.x+this.getWidth()>1920) posicion.x=1920-this.getWidth();
        if(posicion.x<0) posicion.x=0;
        if(posicion.y+this.getHeight()>1080) posicion.y=1080-this.getHeight();
        if(posicion.y<0) posicion.y=0;

        this.setLocation(posicion);
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Astro astro = (Astro) o;
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
