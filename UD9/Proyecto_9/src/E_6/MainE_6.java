/*
Ejercicio 6 - Receta
Implementa las clases Ingrediente y Receta (partiendo de los modelos UML que están
anexos abajo). Una vez creadas las clases. Implementa un método main que introduzca
por teclado los valores de los atributos para crear una receta. Se preguntará cuántos
ingredientes lleva la receta. Una vez introducidos los valores mostrar la receta.

 */


package E_6;

import java.util.Scanner;

public class MainE_6 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el nombre de la receta");
        String nombre = input.nextLine();

        System.out.println("Introduce la descripcion ");
        String nombre = input.nextLine();




        System.out.println("Introduce la cantidad de ingredientes que tiene la receta");
        int cantidad = validadCantidad(input.nextLine());

        Receta receta = new Receta();

    }

    public static int validadCantidad(String inputLine){
        while(true){
            if(inputLine.matches("\\d"))
                return Integer.parseInt(inputLine);

            System.out.println("Cantidad introducida no es valida. Vuelve a intentarlo");
        }
    }

}


