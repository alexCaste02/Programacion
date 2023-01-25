/*

13. Crea un programa que permita al usuario almacenar una secuencia aritmética en un
array y luego mostrarla. Una secuencia aritmética es una serie de números que
comienza por un valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1
e I=2, la secuencia sería 1, 3, 5, 7, 9... Con V=7 e I=10, la secuencia sería 7, 17, 27, 37...
El programa solicitará al usuario V, I además de N (nº de valores a crear).

*/

package Vectores_Y_Matrices;

import java.util.Scanner;

public class E_13 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el valor inicial (v)");
        int v = leerInput();

        System.out.println("Introduce el valor de los incrementos (i)");
        int i = leerInput();

        System.out.println("Indica el numero de valores a crear (n)");
        int n = leerInput();


        int[] secuencia = new int[n];
        secuencia[0] = v;

        for (int j=1; j<secuencia.length; j++){
            secuencia[j]=secuencia[j-1]+i;
        }


        for (int valor :
                secuencia) {
            System.out.print(valor+"  ");
        }

    }

    public static int leerInput (){
        while (true){
            String inputLine = input.nextLine();

            if (inputLine.matches("\\d+"))
                return Integer.parseInt(inputLine);

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }

    // TODO: 22/01/2023 -Crear validacion como funcion diferente para ++modularidad?
//    public static boolean esInputValido(String inputLine){
//
//    }


}
