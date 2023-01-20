/*
7. Crea un programa que pida dos valores enteros P y Q, luego cree un array que
contenga todos los valores desde P hasta Q, y lo muestre por pantalla.
*/

package Vectores;

import java.util.Scanner;

public class E_7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un primer valor (P)");
        int p = input.nextInt();

        System.out.println("Introduce un segundo valor (Q)");
        int q = input.nextInt();


        int[] nums = new int[Math.abs(p - q) + 1];


        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.min(p, q)+i;
        }

        for (int n : nums) System.out.print(n+"  ");

    }
}
