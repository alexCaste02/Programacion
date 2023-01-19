
/*
6. Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño
N, escriba M en todas sus posiciones y lo muestre por pantalla.
*/

package Vectores;

import java.util.Arrays;
import java.util.Scanner;

public class E_6 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("Introduce un primer valor");
        int n = input.nextInt();

        System.out.println("Introduce un segundo valor");
        int m = input.nextInt();

        int[] nums = new int[n];


        Arrays.fill(nums, m);

//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = m;
//        }

        for (int x:
             nums) {
            System.out.println(x);
        }

    }
}
