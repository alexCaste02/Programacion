/*

17. Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
primeros en un array y los 10 últimos en otro array. Por último, comparará ambos
arrays y le dirá al usuario si son iguales o no.

*/

package Vectores_Y_Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class E_17 {

    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        int[] array1 = new int[10];
        int[] array2 = new int[10];

        for (int i = 0; i < 20; i++) {
            System.out.print("Introduce el valor numero " + (i + 1) + ": ");
            if (i < 10)
                array1[i] = readAndValidate();
            else
                array2[i-10] = readAndValidate();
        }

        if (Arrays.compare(array1,array2)==0)
            System.out.println("Son iguales");
        else
            System.out.println("Son diferentes");
    }

    public static int readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("-?\\d+"))
                return Integer.parseInt(inputLine);

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }
}
