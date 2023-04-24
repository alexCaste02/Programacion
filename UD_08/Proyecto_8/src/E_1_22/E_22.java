/*

22. Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas
de multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por
pantalla

*/

package E_1_22;


public class E_22 {


    public static void main(String[] args) {

        int[][] matrix = new int[10][10];

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                matrix[i-1][j-1]=i*j;
            }
        }

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                System.out.println(i+" x "+j+" = "+matrix[i-1][j-1]);
            }
            System.out.println();
        }

    }
}
