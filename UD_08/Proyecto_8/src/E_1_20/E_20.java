/*

20. Crea un programa que cree un array de tamaño 1000 y lo rellene con valores enteros
aleatorios entre 0 y 99. Luego pedirá por teclado un valor N y se mostrará por pantalla
si N existe en el array, además de cuantas veces.

*/

package E_1_20;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class E_20 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0,100);
        }

        System.out.println("Introduce un valor a buscar");
        int n = readAndValidate();

        int reps=0;

        for (int i : arr) {
            if (i==n)
                reps++;
        }

        System.out.println("Se repite "+reps+" veces");

    }

    public static int readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("-?\\d+")) {
                return Integer.parseInt(inputLine);
            }

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }


}
