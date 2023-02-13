package e_01;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {



    }

    public static void menu(){

        System.out.print("""
                Introduzca la accion a realizar:
                
                1) Añadir un nuevo astro
                2) Editar un astro existente
                3) Eliminar un astro
                4) Mostrar informacion sobre un astro
                5) Mostrar todos los astros
                
                6) [Dev] Crear grupo de astros de ejemplo
                
                0) Salir
                
                """);

        optionSelect(input.nextLine(),6);



    }

    public static int optionSelect(String inputLine, int maxValidOption){
        boolean valid = false;
        while (!valid) {
            if (inputLine.matches("\\d")){
                int inputInt = Integer.parseInt(inputLine)
                if(inputInt<=maxValidOption){
                    return inputInt;
                }

            }




        }



    }

}


