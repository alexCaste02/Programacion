package e_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);




        try{
            System.out.println("Introduce un valor entero A");
            int a = input.nextInt();

            System.out.println("Introduce un valor entero B");
            int b = input.nextInt();



            System.out.println(a+" / "+b+" = "+a/b);

        } catch (InputMismatchException e) {

            e.printStackTrace();
            System.out.println("Valor introducido incorrecto");
            
        } catch (ArithmeticException e) {

            e.printStackTrace();
            System.out.println("Division de valores introducidos no es posible");
        }

        System.out.println("Programa finalizado correctamente");

    }
}
