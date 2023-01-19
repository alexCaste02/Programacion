
/*
3. Crea un programa que pida diez números reales por teclado, los almacene en un
array, y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla.
*/

package Vectores;

import java.util.Scanner;

public class E_3 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion "+(i+1)+": ");
            nums[i] = input.nextInt();
        }

        int max=nums[0];
        int min=nums[0];


        for (double n :
                nums) {

            max = (int)Math.max(max,n);
            min = (int)Math.max(min,n);

        }

        System.out.println(
                "Maximo = "+max+
                "\nMinimo = "+min
        );

    }
}
