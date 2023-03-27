package e_AgendaTelefonica;

import custom.util.InputReader;
import custom.util.InvalidInputException;

public class Uso_Agenda {
    public static void main(String[] args) {
        while (menu());
    }

    public static boolean menu() {

        System.out.print("""
                =============================================
                Introduzca la accion a realizar:
                
                1) Mostrar Agenda
                
                2) Añadir entrada
                
                3) Buscar por nombre
                4) Buscar por numero
                
                5) Borrar por nombre
                6) Borrar por numero
                
                7) Ordenar por nombre
                
                0) Salir
                =============================================
                """);

        try {
            switch (InputReader.readAndValidateOption(7)) {
                case 1 -> {
                    mostrarAgenda();
                }
                case 2 -> {
                    addEntrada();
                }
                case 3 -> {
                    buscarPorNombre();
                }
                case 4 -> {
                    buscarPorNumero();
                }
                case 5 -> {
                    borrarPorNombre();
                }
                case 6 -> {
                    borrarPorNumero();
                }
                case 7 -> {
                    ordenarPorNombre();
                }
                case 0 -> {
                    return false;
                }
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        return true;

    }


    private static void mostrarAgenda() {
        for (Registro registro : Agenda.registros) {
            System.out.println(registro);
        }
    }

    private static void addEntrada() {
        System.out.print("Introduce el nombre:");
        String nombre = 
    }

    private static void buscarPorNombre() {
    }

    private static void buscarPorNumero() {
    }

    private static void borrarPorNombre() {
    }

    private static void borrarPorNumero() {
    }

    private static void ordenarPorNombre() {
    }
}
