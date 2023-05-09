package Fisicas;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class Astro extends JFrame{

    private Point velocidad;
    private boolean fijo;

    private int masa=1;



    private static int idCounter;
    private final int id;

    public Astro(String cadena, boolean fijo){
        super(cadena);
        setBounds(25,25,500,500);
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
