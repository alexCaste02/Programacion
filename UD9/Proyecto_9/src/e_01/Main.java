package e_01;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (menu());

    }

    public static int optionSelect(String inputLine, int maxValidOption){
        while (true) {
            if (inputLine.matches("\\d")){
                int inputInt = Integer.parseInt(inputLine);
                if(inputInt<=maxValidOption){
                    return inputInt;
                }
            }
            System.out.println("No se ha introducido una opcion valida. Intentelo de nuevo.");
        }
    }

    public static boolean menu(){

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

        switch (optionSelect(input.nextLine(),6)){
            case 1 -> {addAstro();}
            case 2 -> {editAstro();}
            case 3 -> {removeAstro();}
            case 4 -> {showAstro();}
            case 5 -> {showAll();}
            case 6 -> {devTemplate();}
            case 0 -> {return false;}
        }

        return true;

    }

    public static void addAstro(){
        System.out.print("""
                Que tipo de astro desea añadir:
                
                1) Planeta
                2) Satelite
                
                0) Volver
                """);

        switch (optionSelect(input.nextLine(),6)){
            case 1 -> {}
        }
    }

    public static void editAstro(){

    }

    public static void removeAstro(){

    }

    public static void showAstro(){

    }



}


