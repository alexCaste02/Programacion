
/*
2. Crea un programa que pida diez números reales por teclado, los almacene en un
array, y luego muestre la suma de todos los valores
*/

package Vectores;

import java.util.Scanner;

public class E_2 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int[] nums = new int[10];
        int suma=0;


        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion "+(i+1)+": ");
            nums[i] = input.nextInt();
        }

        for (int n : nums) {
            suma+=n;
        }

        System.out.println("El suma de esos valores = "+suma);

    }
}
