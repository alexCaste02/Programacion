
/*
8. Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
utilizando Math.random(), y luego le pida al usuario un valor real R. Por último,
mostrará cuántos valores del array son igual o superiores a R.
*/

package Vectores_Y_Matrices;

import java.util.Scanner;

public class E_8 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] nums = new double[100];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }

        System.out.println("Introduce un valor real (R)");
        double r = input.nextDouble();

        int counter=0;

        for (double n :
                nums) {

            if(n>=r)
                counter++;

        }

        System.out.println("Hay "+counter+" numeros mayores o iguales a "+r);
    }
}
