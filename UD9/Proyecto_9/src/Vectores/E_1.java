
/*
1. Crea un programa que pida diez números reales por teclado, los almacene en un
array, y luego muestre todos sus valores.
*/

package Vectores;

import java.util.Scanner;

public class E_1 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int[] nums = new int[10];

//        for (int n :
//                nums) {
//            System.out.println("Introduce el valor");
//        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion "+(i+1)+": ");
            nums[i] = input.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("El valor de la posicion "+(i+1)+" es: "+nums[i]);
        }

//        for (int n :
//                nums) {
//            System.out.println("El valor de la posicion es: "+n);
//        }


    }
}
