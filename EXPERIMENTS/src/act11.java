import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class act11 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int nRandom = ThreadLocalRandom.current().nextInt(1, 101);
        int nIntroducido = 0;
        boolean acertado = false;

        System.out.println("Bienvenido al juego de adivinar el número secreto.");
        System.out.println("El número secreto está entre 1 y 100. Ingresa -1 para salir.");

        while (!acertado && nIntroducido != -1) {

            System.out.print("Ingresa un número: ");

            try {

                nIntroducido = Integer.parseInt(input.nextLine());

                if (nIntroducido == nRandom) {
                    acertado = true;
                    System.out.println("Has adivinado el numero");
                } else if (nIntroducido == -1) {
                    System.out.println("Te has rendido.");
                } else if (nIntroducido < nRandom) {
                    System.out.println("Estas por debajo");
                } else {
                    System.out.println("Estas por encima");
                }

            } catch (Exception e) {
                System.out.println("Valor no valido");
            }

        }

    }
}
