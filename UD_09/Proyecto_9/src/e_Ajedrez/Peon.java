package e_Ajedrez;

import java.awt.*;

public class Peon extends Pieza implements JuegoTablero {

    public Peon(ColorPieza color, int posicionX, int posicionY) {
        super(color, posicionX, posicionY);

        //ESTO ES SOLO PARA INFORMAR DE QUE EL PEON HA SIDO GENERADO EN UNA POSICION INVALIDA
        if (color == ColorPieza.BLANCO) {

            if (posicionY == 0) {
                System.err.println("Posicion del peon blanco esta dentro del tablero, pero es ilegal");
            }

        } else {

            if (posicionY == 7) {
                System.err.println("Posicion del peon negro esta dentro del tablero, pero es ilegal");
            }

        }
    }

    @Override
    public void mover(int x, int y) {

        //TODO: podria usar un .translate para realizar lo mismo
        Point nuevaPos = new Point(posicion.x + x, posicion.y + y); //nuevo punto para mayor claridad

        if (comprobarPosicion(nuevaPos.x) && comprobarPosicion(nuevaPos.y)) {//comprobamos si esta en el tablero

            if (color == ColorPieza.BLANCO) {

                // comprobamos si se ha movido solo una posicion "hacia arriba" el peon blanco
                if (nuevaPos.y == posicion.y + 1 && nuevaPos.x == posicion.x) {
                    posicion.setLocation(nuevaPos);
                }

                // comprobamos si el peon esta en su posicion inicial, y si se ha movido 2 posiciones "hacia arriba"
                else if (posicion.y == 1 && nuevaPos.y == 3 && nuevaPos.x == posicion.x) {
                    posicion.setLocation(nuevaPos);

                } else {
                    System.err.println("Movimiento no puede ser realizado por un peon (blanco)");
                }

            } else {

                // comprobamos si se ha movido solo una posicion "hacia abajo" si es blaca
                if (nuevaPos.y == posicion.y - 1 && nuevaPos.x == posicion.x) {
                    posicion.setLocation(nuevaPos);
                }

                // comprobamos si el peon esta en su posicion inicial, y si se ha movido 2 posiciones "hacia abajo"
                else if (posicion.y == 6 && nuevaPos.y == 4 && nuevaPos.x == posicion.x) {
                    posicion.setLocation(nuevaPos);

                } else {
                    System.err.println("Movimiento no puede ser realizado por un peon (negro)");
                }

            }

        } else {
            System.err.println("Movimiento sale del tablero");
        }
    }


    //FIXME: StringIndexOutOfBounds cuando esta fuera del tablero (duh)
    //  - Poner un valor default // "ABCDEFGHX" por ejemplo?
    @Override
    public char indiceAPosicion(int indice) {
        String letrasPos = "ABCDEFGH"; // podria hacerla constante de clase
        return letrasPos.charAt(indice);
    }

    @Override
    public int indiceAPosicionN(int indice) {
        return indice + 1;
    }

    @Override
    public int posicionAIndice(char posicion) {
        String letrasPos = "ABCDEFGH";
        return letrasPos.indexOf(posicion);
    }

    @Override
    public int posicionAIndice(int posicion) {
        return posicion - 1;
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
