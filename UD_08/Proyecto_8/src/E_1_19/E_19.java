/*

18. Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios
entre 0 y 9. Luego ordena los valores del array y los mostrará por pantalla.

*/

package E_1_19;

import java.util.Arrays;
import java.util.Scanner;

public class E_19 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int[] puntuaciones = new int[8];

        for (int i = 0; i < puntuaciones.length; i++) {
            System.out.print("Introduce la puntuacion del jugador "+(i+1)+" (debe estar entre 1000 y 2800): ");
            puntuaciones[i] = readAndValidate();
        }

        Arrays.sort(puntuaciones);

        for (int i = puntuaciones.length-1; i >= 0 ; i--) {
            System.out.print(puntuaciones[i]+"  ");
        }

    }

    public static int readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("-?\\d+")
                    && Integer.parseInt(inputLine)>1000
                    && Integer.parseInt(inputLine)<2800) {
                return Integer.parseInt(inputLine);
            }

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }


}
