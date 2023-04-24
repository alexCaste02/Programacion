/*
5. Crea un programa que pida veinte números reales por teclado, los almacene en un
array y luego lo recorra para calcular y mostrar la media: (suma de valores) / nº de
valores.
*/

package E_1_05;

import java.util.Scanner;

public class E_5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        double[] nums = new double[20];
        double suma = 0;


        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion " + (i + 1) + ": ");
            nums[i] = input.nextInt();
        }

        for (double n : nums) {
            suma += n;
        }

        System.out.printf("%.2f", suma / nums.length);

    }
}
