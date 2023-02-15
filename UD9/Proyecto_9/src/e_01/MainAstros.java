package e_01;

import java.util.Scanner;
import custom.util.InputReader;

public class MainAstros {

    static Scanner input = new Scanner(System.in);

    /*
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
    */

    public static void main(String[] args) {

        while (menu());


    }

    public static boolean menu(){

        System.out.print("""
                =============================================
                Introduzca la accion a realizar:
                
                1) Añadir un nuevo astro
                2) Editar un astro existente
                3) Eliminar un astro
                4) Mostrar informacion sobre un astro
                5) Mostrar todos los astros
                
                6) [Dev] Crear grupo de astros para pruebas
                
                0) Salir
                =============================================""");

        switch (InputReader.readAndValidateOption(6)){
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

    public static boolean addAstro(){
        System.out.print("""
                =============================================
                Que tipo de astro desea añadir:
                
                1) Planeta
                2) Satelite
                
                0) Volver
                =============================================""");

        switch (InputReader.readAndValidateOption(2)){
            case 1 -> {addPlaneta();}
            case 2 -> {addSatelite();}
            case 0 -> {return false;}
        }
        return true;
    }

    public static void addPlaneta(){
        System.out.print("Introduce el nombre del planeta: ");
        String nombre = input.nextLine();
        //FIXME: comprobar si ya existe en nombre

        System.out.print("Introduce su masa (En KG): ");
        double masa = InputReader.readAndValidateDouble();
        System.out.print("Introduce su diametro (En KM): ");
        double diametro = InputReader.readAndValidateDouble();
        System.out.print("Introduce su periodo de rotacion (En dias): ");
        double periodoRotacion = InputReader.readAndValidateDouble();
        System.out.print("Introduce su periodo de traslacion (En dias): ");
        double periodoTraslacion = InputReader.readAndValidateDouble();

        new Planetas(nombre,masa,diametro,periodoRotacion,periodoTraslacion);
    }

    //TODO: terminar menu zzz
    public static boolean addSatelite(){
        System.out.print("Introduce el nombre del satelite: ");
        String nombre = input.nextLine();
        //FIXME: comprobar si ya existe en nombre

        System.out.print("Introduce el nombre del cuerpo al que orbita: ");
        String nombreAstroOrbitado = input.nextLine();
        if(Astros.findAstroByName(nombreAstroOrbitado)==null)
            return false;
        Astros cuerpoOrbitado = Astros.findAstroByName(nombreAstroOrbitado);

        System.out.print("Tiene una rotacion sincrona? (Introduce Y o N): ");
        boolean rotaSinc = InputReader.readAndValidateYN();
        System.out.print("Introduce su masa (En KG): ");
        double masa = InputReader.readAndValidateDouble();
        System.out.print("Introduce su diametro (En KM): ");
        double diametro = InputReader.readAndValidateDouble();
        System.out.print("Introduce su periodo de rotacion (En dias): ");
        double periodoRotacion = InputReader.readAndValidateDouble();
        System.out.print("Introduce su periodo de traslacion (En dias): ");
        double periodoTraslacion = InputReader.readAndValidateDouble();

        new Satelites(nombre,masa,diametro,periodoRotacion,periodoTraslacion,cuerpoOrbitado,rotaSinc);
        return true;
    }

    public static boolean editAstro(){
        System.out.print("Introduce el nombre del cuerpo a editar: ");
        String nombreAstroOrbitado = input.nextLine();
        if(Astros.findAstroByName(nombreAstroOrbitado)==null)
            return false;
        Astros cuerpoOrbitado = Astros.findAstroByName(nombreAstroOrbitado);

        return true;
    }

    public static void removeAstro(){

    }

    public static void showAstro(){

    }

    public static void showAll(){

    }

    public static void devTemplate(){

    }



}


