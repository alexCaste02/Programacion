/*

15. Crea un programa que pida la usuario dos valores N y M y luego cree un array de
tamaño N que contenga M en todas sus posiciones. Luego muestra el array por
pantalla.

*/

package Vectores;

import java.util.Arrays;
import java.util.Scanner;

public class E_15 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el tamaño del array (n)");

        int n = leerInputPos();

        System.out.println("Introduce el valor que desea guardar en el array (m)");
        int m = leerInput();


        int[] nums = new int[n];


        Arrays.fill(nums, m);

//        for (int i = 0; i < nums.length; i++) {
//            nums[i]=m;
//        }

        for (int i : nums) {
            System.out.print(i+"  ");
        }

    }

    public static int leerInput(){
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("\\d+"))
                return Integer.parseInt(inputLine);

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }

    public static int leerInputPos(){
        while (true){
            String inputLine = input.nextLine();

            if(inputLine.matches("\\d+") && Integer.parseInt(inputLine)>=0)
                 return Integer.parseInt(inputLine);

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }


}
