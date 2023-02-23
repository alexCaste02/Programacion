
/*
2. Crea un programa que pida diez números reales por teclado, los almacene en un
array, y luego muestre la suma de todos los valores
*/

package E_1_02;

import java.util.Scanner;

public class E_1_2 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        double[] nums = new double[10];
        double suma=0;


        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce el numero en la posicion "+(i+1)+": ");
            nums[i] = input.nextDouble();
        }

        for (double n : nums) {
            suma+=n;
        }

        System.out.println("El suma de esos valores = "+suma);

    }
}
