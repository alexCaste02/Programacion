/*
4. Crea un programa que pida veinte números enteros por teclado, los almacene en un
array y luego muestre por separado la suma de todos los valores positivos y negativos.
*/

package E_1_04;

import java.util.Scanner;

public class E_4 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int[] nums = new int[10];
        int sumaPos = 0;
        int sumaNeg = 0;


        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion " + (i + 1) + ": ");
            nums[i] = input.nextInt();
        }

        for (int num : nums) {
            if (num >= 0) sumaPos += num;
            else sumaNeg += num;
        }

        System.out.println("Suma de positivos = " + sumaPos + "\nSuma de negativos = " + sumaNeg);

    }
}
