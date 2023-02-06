package E_11;

import java.util.concurrent.ThreadLocalRandom;

public class MainE_11_ALT {
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

        int ceroGana = 0;
        int unoGana = 0;

        // Filas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == 0 && matriz[i][1] == 0 && matriz[i][2] == 0) {
                ceroGana++;
            }
            if (matriz[i][0] == 1 && matriz[i][1] == 1 && matriz[i][2] == 1) {
                unoGana++;
            }
        }

        // Columnas
        for (int j = 0; j < 3; j++) {
            if (matriz[0][j] == 0 && matriz[1][j] == 0 && matriz[2][j] == 0) {
                ceroGana++;
            }
            if (matriz[0][j] == 1 && matriz[1][j] == 1 && matriz[2][j] == 1) {
                unoGana++;
            }
        }

        // Diagonal 1
        if (matriz[0][0] == 0 && matriz[1][1] == 0 && matriz[2][2] == 0) {
            ceroGana++;
        }
        if (matriz[0][0] == 1 && matriz[1][1] == 1 && matriz[2][2] == 1) {
            unoGana++;
        }

        // Diagonal 2
        if (matriz[0][2] == 0 && matriz[1][1] == 0 && matriz[2][0] == 0) {
            ceroGana++;
        }
        if (matriz[0][2] == 1 && matriz[1][1] == 1 && matriz[2][0] == 1) {
            unoGana++;
        }

        System.out.println("Jugador 0 gana: " + ceroGana + " veces");
        System.out.println("Jugador 1 gana: " + unoGana + " veces");

        if (ceroGana > unoGana) {
            System.out.println("Jugador 0 gana");
        } else if (unoGana > ceroGana) {
            System.out.println("Jugador 1 gana");
        } else {
            System.out.println("Empate");
        }
    }
}
