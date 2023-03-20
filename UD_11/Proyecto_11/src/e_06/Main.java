package e_06;

import custom.util.InputReader;
import custom.util.InvalidInputException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Integer> plantilla = new HashMap<>();
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
                case 4 -> {}
                case 0 -> {return false;}
            }

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }


        return true;
    }
}
