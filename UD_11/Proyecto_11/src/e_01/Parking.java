package e_01;

import ReaderAndValidator.InputReader;
import ReaderAndValidator.InvalidInputException;

import java.util.LinkedList;
import java.util.Scanner;

public class Parking {

    static Scanner input = new Scanner(System.in);

    static LinkedList <String> parking = new LinkedList<>();

    public static void main(String[] args) {

        while (true) {
            try {
                if (!menu()) break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static boolean menu() throws InvalidInputException {

        System.out.print("""
                =============================================
                Introduzca la accion a realizar:
                
                1) Aparcar
                2) Desaparcar
                3) Mostrar lista
                
                4) [Dev] Pruebas automatica
                
                0) Salir
                =============================================
                """);

        switch (InputReader.readAndValidateOption(4)){
            case 1 -> {
                System.out.println("Introduce la matricula");
                aparcar(input.nextLine());
            }
            case 2 -> {desaparcar();}
            case 3 -> {mostrar();}
            case 4 -> {pruebas();}
            case 0 -> {return false;}
        }

        return true;

    }

    public static void pruebas(){

        aparcar("a1");
        mostrar();

        aparcar("a2");
        mostrar();

        aparcar("a3");
        aparcar("a4");
        aparcar("a5");
        aparcar("a6");
        aparcar("a7");
        aparcar("a8");
        aparcar("a9");
        aparcar("a10");
        mostrar();

        aparcar("a11");
        mostrar();

        desaparcar();
        mostrar();

        desaparcar();
        desaparcar();
        mostrar();

        desaparcar();
        desaparcar();
        desaparcar();
        desaparcar();
        desaparcar();
        desaparcar();
        desaparcar();
        mostrar();

        desaparcar();
        mostrar();

    }

    public static void aparcar(String matricula){
        if (parking.size()<10)
            parking.addFirst(matricula);
        else
            System.out.println("Parking lleno");
    }

    public static void desaparcar(){
        if (!parking.isEmpty()) {
            System.out.println(parking.getFirst());
            parking.removeFirst();
        } else {
            System.out.println("Parking vacio");
        }
    }

    public static void mostrar(){
        System.out.println(parking);

    }
}
