
/*
9. Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores
enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N
y mostrará en qué posiciones del array aparece N.
*/

package Vectores_Y_Matrices;

import java.util.Scanner;

public class E_9 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (1+Math.random()*10);
        }

        System.out.println("Introduce un valor real (N)");
        int n = input.nextInt();

        System.out.println(n+" aparece en las posiciones..  ");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==n)
                System.out.print(i+"  ");
        }


    }
}
