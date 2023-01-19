
/*
12. Crea un programa que cree un array de 10 enteros y luego muestre el siguiente
menú con distintas opciones:

a. Mostrar valores.
b. Introducir valor.
c. Salir.

La opción ‘a’ mostrará todos los valores por pantalla. La opción ‘b’ pedirá un valor V y
una posición P, luego escribirá V en la posición P del array. El menú se repetirá
indefinidamente hasta que el usuario elija la opción ‘c’ que terminará el programa.

*/

package Vectores;

import java.util.Scanner;

public class E_12 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array = new int[10];

        menu(array);


    }

    public static void menu(int[] arr) {

        char resp;
        do {

            System.out.println("""
                    
                    
                    a. Mostrar valores.
                    b. Introducir valor.
                    c. Salir.
                    """);
            resp = input.next().charAt(0);

            switch (resp) {
                case 'a' -> mostrarValores(arr);
                case 'b' -> introValor(arr);
                case 'c' -> System.out.println("Saliendo...");
                default -> System.out.println("Valor no valido");
            }
        } while (resp != 'c');

    }

    public static void mostrarValores(int[] arr){
        System.out.print("Los valores actuales son: ");
        for (int valor :
                arr) {
            System.out.print(valor+"  ");
        }
    }

    public static void introValor(int[] arr){
        System.out.print("Introduzca el valor: ");
        int v = input.nextInt();

        System.out.print("Introduzca la posicion para ese valor: ");
        int p = input.nextInt();

        arr[p-1]=v;

    }

}
