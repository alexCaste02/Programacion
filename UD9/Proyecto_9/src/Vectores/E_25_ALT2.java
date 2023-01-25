package Vectores;

import java.util.Scanner;

public class E_25_ALT2 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el numero total de trabajadores");
        int nTrabajadores = input.nextInt();

        double[][] trabajadoresArray = new double[nTrabajadores][2];

        for (int i = 0; i < nTrabajadores; i++) {
            System.out.println("Introduce el genero del trabajador (0=hombre, 1=mujer)");
            trabajadoresArray[i][0] = input.nextInt();
            System.out.println("Introduce el sueldo del trabajador");
            trabajadoresArray[i][1] = input.nextDouble();
        }

        double sumaSalarioH = 0;
        double sumaSalarioM = 0;
        int trabajadoresH = 0;
        int trabajadoresM = 0;

        for (int i = 0; i < nTrabajadores; i++) {
            if (trabajadoresArray[i][0] == 0) {
                sumaSalarioH += trabajadoresArray[i][1];
                trabajadoresH++;
            } else {
                sumaSalarioM += trabajadoresArray[i][1];
                trabajadoresM++;
            }
        }

        double mediaH = sumaSalarioH / trabajadoresH;
        double mediaM = sumaSalarioM / trabajadoresM;
        System.out.println("Sueldo medio de hombres: " + mediaH);
        System.out.println("Sueldo medio de mujeres: " + mediaM);

        if (mediaH > mediaM) {
            System.out.println("hombres ganan mas");
        } else if (mediaM > mediaH) {
            System.out.println("mujeres ganan mas");
        } else {
            System.out.println("ganan lo mismo");
        }
    }
}
