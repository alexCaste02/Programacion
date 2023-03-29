package e_AgendaTelefonica;

import custom.util.InputReader;
import custom.util.InvalidInputException;

import java.util.Comparator;

import java.util.Scanner;

public class Uso_Agenda {

    static Scanner input = new Scanner(System.in);

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
                case 1 -> Agenda.mostrarAgenda();
                case 2 -> Agenda.addEntrada();
                case 3 -> Agenda.buscarPorNombre();
                case 4 -> Agenda.buscarPorNumero();
                case 5 -> Agenda.borrarPorNombre();
                case 6 -> Agenda.borrarPorNumero();
                case 7 -> Agenda.ordenarPorNombre();
                case 0 -> {return false;}
            }

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        return true;

    }



}
