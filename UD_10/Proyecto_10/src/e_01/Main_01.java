package e_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("Introduce un valor entero");

        try{

            int n = input.nextInt();
            System.out.println("Valor introducido: "+n);

        } catch (InputMismatchException e) {

            e.printStackTrace();
            System.out.println("Valor introducido incorrecto");

        }

        System.out.println("Programa finalizado correctamente");

    }
}
