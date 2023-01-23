/*

23. Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por
teclado) e introduzca en ella NxM valores (también introducidos por teclado). Luego
deberá recorrer la matriz y al final mostrar por pantalla cuántos valores son mayores
que cero, cuántos son menores que cero y cuántos son igual a cero.

*/

package Vectores;


import java.util.Scanner;

public class E_23 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce las filas del array [N]");
        int n = readAndValidate();

        System.out.println("Introduce las columnas del array [M]");
        int m = readAndValidate();


        int[][] matrix = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Introduce el valor de indices " + i + "," + j);
                matrix[i][j] = readAndValidate();
            }
        }

        int pos = 0;
        int neg = 0;
        int cero = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {

                if (anInt > 0) {
                    pos++;
                } else if (anInt < 0) {
                    neg++;
                } else {
                    cero++;
                }

            }
        }

        System.out.println("Valores positivos: " + pos);
        System.out.println("Valores negativos: " + neg);
        System.out.println("Valores 0: " + cero);


    }

    public static int readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("-?\\d+")) {
                return Integer.parseInt(inputLine);
            }

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }

}
