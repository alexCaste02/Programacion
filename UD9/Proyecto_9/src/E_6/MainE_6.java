/*
Ejercicio 6 - Receta
Implementa las clases Ingrediente y Receta (partiendo de los modelos UML que están
anexos abajo). Una vez creadas las clases. Implementa un método main que introduzca
por teclado los valores de los atributos para crear una receta. Se preguntará cuántos
ingredientes lleva la receta. Una vez introducidos los valores mostrar la receta.

 */


package E_6;

import java.util.Arrays;
import java.util.Scanner;

public class MainE_6 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Introduce el nombre de la receta: ");
        String nombre = input.nextLine();

        System.out.print("Introduce la elaboracion de la receta: ");
        String desc = input.nextLine();

        System.out.print("Introduce la duracion de la receta (en minutos): ");
        int duracion = validateNumPositivo();

        System.out.print("Introduce la cantidad de ingredientes que tiene la receta: ");
        int cantidad = validateNumPositivo();
        
        Ingrediente[] ingredientes = new Ingrediente[cantidad];




        for (int i = 0; i < cantidad; i++) {
            System.out.println();

            System.out.print("Introduce el nombre del ingrediente "+(i+1)+": ");
            String nombreIng = input.nextLine();

            System.out.print("Introduce la unidad del ingrediente " +(i+1)+": ");
            String unidadIng = input.nextLine();

            System.out.print("Introduce la cantidad del ingrediente "+(i+1)+": ");
            int cantidadIng = validateNumPositivo();

            ingredientes[i] = new Ingrediente(nombreIng,cantidadIng, unidadIng);

        }

        Receta rec = new Receta(nombre,desc,duracion, ingredientes);

        rec.mostrarReceta();

    }

    public static int validateNumPositivo(){
        while(true){
            String inputLine = input.nextLine();
            if(inputLine.matches("\\d+"))
                return Integer.parseInt(inputLine);
            System.out.println("Cantidad introducida no es valida. Vuelve a intentarlo");
        }
    }

}


