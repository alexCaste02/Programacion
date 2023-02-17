package e_Ajedrez;

import java.awt.*;
import java.util.Objects;

public abstract class Pieza {

    protected ColorPieza color;
    protected Point posicion = new Point();
    protected boolean comida;

    public Pieza(ColorPieza color, int posicionX, int posicionY) {
        this.color = color;
        posicion.setLocation(posicionX,posicionY);

        if(comprobarPosicion(posicionX) && comprobarPosicion(posicionY))
            this.comida = false;
        else
            this.comida = true;
    }

    public Pieza() {
        this(ColorPieza.BLANCO,10,10);
    }

    public Pieza(Pieza pieza) {
        this(pieza.color,pieza.posicion.x,pieza.posicion.y);
    }


    public ColorPieza getColor() {
        return color;
    }
    public void setColor(ColorPieza color) {
        this.color = color;
    }
    public Point getPosicion() {
        return posicion;
    }
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }
    public boolean isComida() {
        return comida;
    }
    public void setComida(boolean comida) {
        this.comida = comida;
    }


    public abstract void mover(int x, int y);


    @Override
    public int hashCode() {
        return Objects.hash(color, posicion, comida);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pieza pieza)) return false;
        return color == pieza.color && Objects.equals(posicion, pieza.posicion);
    }

    protected static boolean comprobarPosicion(int p){
        return p >= 0 && p <= 7;
    }


}
