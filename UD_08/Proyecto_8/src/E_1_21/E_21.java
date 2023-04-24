/*

21. Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del
1 al 25 y luego muestre la matriz por pantalla.

*/

package E_1_21;


public class E_21 {


    public static void main(String[] args) {

        int[][] matrix = new int[5][5];

        int num=1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=num;
                num++;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.println(anInt+"  ");
            }
        }

    }
}
