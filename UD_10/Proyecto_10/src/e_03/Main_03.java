package e_03;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] vector = new double[5];


        for (int i = 0; i < 5; i++) {

            System.out.println("Introduce el valor de posicion "+(i+1)+": ");

            try{

                String v = input.nextLine();
                vector[i]= Double.parseDouble(v);

            } catch (InputMismatchException e) {

                //FIXME: puede que esto no ocurre nunca con parseInt lol
                e.printStackTrace();
                System.out.println("Valor introducido no es valido");
                i--;

            } catch (NumberFormatException e){

                e.printStackTrace();
                System.out.println("Formato no valido");
                i--;

            }

        }

        System.out.println(Arrays.toString(vector));

        System.out.println("Programa finalizado correctamente");

    }
}
