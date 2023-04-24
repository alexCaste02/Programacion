package e_06;

import ReaderAndValidator.InputReader;
import ReaderAndValidator.InvalidInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Double> plantilla = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (menu()) ;

    }

    public static boolean menu() {

        System.out.print("""
                =============================================
                Introduzca la accion a realizar:
                                
                1) Añadir jugador
                2) Eliminar jugador
                3) Consultar salario jugador
                4) Incrementar salario 10%
                                
                5) [Dev] Mostrar jugadores
                                
                                
                0) Salir
                =============================================
                """);
        try {

            switch (InputReader.readAndValidateOption(5)) {
                case 1 -> {addJugador();}
                case 2 -> {removeJugador();}
                case 3 -> {consultarSalario();}
                case 4 -> {incrementarSalario10();}
                case 5 -> {mostrarJugadores();}
                case 0 -> {return false;}
            }

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    private static void addJugador() throws InvalidInputException {
        System.out.println("Dime el nombre del jugador");
        String nombre = input.nextLine();

        System.out.println("Dime el salario del jugador");
        double salario =  InputReader.readAndValidateDouble();

        plantilla.put(nombre,salario);
    }

    private static void removeJugador() {
        System.out.println("Dime el nombre del jugador");
        String nombre = input.nextLine();

        if(plantilla.containsKey(nombre)){
            plantilla.remove(nombre);
            System.out.println("Jugador no encontrado");
        }

    }

    private static void consultarSalario(){
        System.out.println("Dime el nombre del jugador");
        String nombre = input.nextLine();

        if(plantilla.containsKey(nombre))
            System.out.println(plantilla.get(nombre));
    }

    private static void incrementarSalario10(){
        System.out.println("Dime el nombre del jugador");
        String nombre = input.nextLine();

        if(plantilla.containsKey(nombre))
            plantilla.put(nombre,plantilla.get(nombre)*1.1);
    }

    private static void mostrarJugadores(){
        for (String s : plantilla.keySet()) {
            System.out.println(s+" - "+plantilla.get(s));
        }
    }

}
