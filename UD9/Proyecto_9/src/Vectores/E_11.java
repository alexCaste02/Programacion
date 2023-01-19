
/*
11. Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá
en el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los
valores del primer array al segundo array en orden inverso, y mostrar ambos por
pantalla.
*/

package Vectores;

import java.util.Scanner;

public class E_11 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int[] arr1 = new int[100];
        int[] arr2 = new int[100];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
        }

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[(arr1.length - 1) - i];
        }


        System.out.println("Array 1");
        for (int x :
                arr1) {
            System.out.print(x + " ");
        }

        System.out.println("\nArray 2");
        for (int x :
                arr2) {
            System.out.print(x + " ");
        }

    }
}
