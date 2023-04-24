
/*
10. Crea un programa para realizar cálculos relacionados con la altura (en metros) de
personas. Pedirá un valor N y luego almacenará en un array N alturas introducidas por
teclado. Luego mostrará la altura media, máxima y mínima así como cuántas personas
miden por encima y por debajo de la media.
*/

package E_1_10;

import java.util.Scanner;

public class E_10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("Introduce el tamaño del array (N)");
        int n = input.nextInt();
        double[] alturas = new double[n];


        double sum=0;

        for (int i = 0; i < alturas.length; i++) {
            System.out.print("Altura "+(i+1)+": ");
            alturas[i] = input.nextDouble();
        }


        double max = alturas[0];
        double min = alturas[0];

        for (double alt :
                alturas) {

            max = Math.max(max,alt);
            min = Math.max(min,alt);
            sum+=alt;

        }


        double media = sum/ alturas.length;
        int persEncima = 0;
        int persDebajo = 0;

        for (double alt :
                alturas) {

            if(alt>media)
                persEncima++;
            else
                persDebajo++;

        }

        System.out.printf("""
                Altura media: %.3f
                Altura maxima: %.2f
                Altura minima: %.2f
                Personas por encima de la media: %d
                Personas por debajo de la media: %d
                """,media,max,min,persEncima,persDebajo
        );

    }
}
