package e_04;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main_04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int[] vector = new int[ThreadLocalRandom.current().nextInt(0, 100 + 1)];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = ThreadLocalRandom.current().nextInt(0,10+1);
        }

        boolean repeat = true;
        int pos = 0;
        while (repeat) {
            System.out.println("Que posicion del vector quieres mostrar por pantalla");


            try {

                pos = Integer.parseInt(input.nextLine())-1;
                System.out.println("El valor de la posicion "+pos+" es: "+vector[pos]);

            } catch (ArrayIndexOutOfBoundsException e) {

                if (pos <= 0) {
                    repeat=false;
                } else {
                    e.printStackTrace();
                    System.out.println("Posicion introducida esta fuera del vector");
                }

            } catch (NumberFormatException e) {

                e.printStackTrace();
                System.out.println("Formato no valido");

            }
        }

        System.out.println("Programa finalizado correctamente");

    }
}
