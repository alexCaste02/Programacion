package E_11;

import java.util.concurrent.ThreadLocalRandom;

public class MainE_11 {

    static int ceroGana = 0;
    static int unoGana = 0;
    static int[] victoriasJugadores = new int[2];


    public static void main(String[] args) {

        int[][] matriz = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            }
        }

        System.out.println("Tablero generado:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        int[] jugadores = new int[2];



        System.out.println("Jugador 0 gana: " + ceroGana + " veces");
        System.out.println("Jugador 1 gana: " + unoGana + " veces");

        if (ceroGana > unoGana) {
            System.out.println("Jugador 0 gana");
        } else if (unoGana > ceroGana) {
            System.out.println("Jugador 1 gana");
        }
    }

    // Filas
    public static void filas(int[][] matriz) {

        boolean lineaCompleta;
        for (int jugador = 0; jugador < 2; jugador++) {

            for (int fila = 0; fila < 3; fila++) {
                lineaCompleta = true;
                for (int columna = 0; columna < 3; columna++) {
                    if (matriz[fila][columna] != jugador) {
                        lineaCompleta = false;
                        break;
                    }
                }

                if (lineaCompleta)
                    victoriasJugadores[jugador]++;
            }

        }


    }

}
