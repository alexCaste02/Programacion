package AlejandroCastellanos;

import java.util.concurrent.ThreadLocalRandom;

public class SumaFilas {
    public static void main(String[] args) {

        //Creamos la matriz con las dimensiones de los argumentos
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[][] matriz = new int[n][m];

        //Recorremos el array, rellenando valores random
        for (int fila = 0; fila < matriz.length; fila++){
            for (int columna = 0; columna < matriz[0].length; columna++) {
                matriz[fila][columna] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            }
        }

        //FILAS
        int suma;
        for (int[] fila : matriz) {
            suma = 0;
            for (int valor : fila) {
                System.out.printf(" %3d  ", valor);
                suma += valor;
            }
            System.out.printf(" [%3d]\n", suma);
        }

        //COLUMNAS
        for (int j = 0; j < matriz[0].length; j++) {
            suma = 0;
            for (int i = 0; i < matriz.length; i++) {
                suma+=matriz[i][j];
            }
            System.out.printf("[%3d] ",suma);
        }

//        int[] sumaFilas = new int[n];
//        int[] sumaColumnas = new int[m];
//        for (int i = 0; i < matriz.length; i++) {
//
//            for (int j = 0; j < matriz[0].length; j++) {
//                System.out.printf(" %3d  ", valor);
//                sumaFilas[]
//            }
//            System.out.printf(" [%3d]\n", sumaFilas);
//        }

    }

}
