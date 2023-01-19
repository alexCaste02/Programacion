
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
        int max=0;
        int min=0;


        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion "+(i+1)+": ");
            nums[i] = input.nextInt();
        }

        for (int i = 0; i < nums.length; i++) {

            if (i==0){
                max=nums[i];
                min=nums[i];
            }

            if (nums[i]>max) {
                max = nums[i];

            } else if (nums[i]<min) {
                min = nums[i];
            }
        }

        System.out.println(
                "Maximo = "+max+
                "\nMinimo = "+min
        );

    }
}
