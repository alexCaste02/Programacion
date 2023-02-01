package E_10;

import java.util.Scanner;

public class MainE_10 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int f = Integer.parseInt(args[0]);
        int c = Integer.parseInt(args[0]);

        int[][] matriz = new int [f][c];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random()*19)+1;

            }
        }

        System.out.println("Introduce un numero entero");
        int v = Integer.parseInt(input.nextLine());


        int cont;
        for (int i = 0; i < matriz.length; i++) {
            cont = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] % v == 0)
                    cont++;
            }
            System.out.println("Fila "+(i+1)+": "+cont);
        }


    }

}
