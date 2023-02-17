package e_Ajedrez;

import java.awt.*;

public class Torre extends Pieza implements JuegoTablero{

    public Torre(ColorPieza color, int posicionX, int posicionY) {
        super(color, posicionX, posicionY);
    }

    @Override
    public void mover(int x, int y) {
        //TODO: podria usar un .translate para realizar lo mismo
        Point nuevaPos = new Point(posicion.x+x,posicion.y+y); //nuevo punto para mayor claridad

        if(comprobarPosicion(nuevaPos.x) && comprobarPosicion(nuevaPos.y))//comprobamos si esta en el tablero
            if(nuevaPos.x == posicion.x || nuevaPos.y == posicion.y) //comprobamos que uno de los dos ejes se mantenga igual, ya que es una torre
                posicion.setLocation(nuevaPos);
            else
                System.err.println("Movimiento no puede ser realizado por una torre");
        else
            System.err.println("Movimiento sale del tablero");
    }

    @Override
    public char indiceAPosicion(int indice) {
        String letrasPos = "ABCDEFGH"; // podria hacerla constante de clase
        return letrasPos.charAt(indice);
    }

    @Override
    public int indiceAPosicionN(int indice) {
        return indice+1;
    }

    @Override
    public int posicionAIndice(char posicion) {
        String letrasPos = "ABCDEFGH";
        return letrasPos.indexOf(posicion);
    }

    @Override
    public int posicionAIndice(int posicion) {
        return posicion-1;
    }

    //PARA PRUEBAS
    @Override
    public String toString() {
        return String.format("""
                Tipo de pieza: %s
                Color: %s
                Posicion: [%s,%s]
                Es comido: %s
                """,this.getClass().getSimpleName(),color,indiceAPosicion(posicion.x),indiceAPosicionN(posicion.y),comida);
    }
}
