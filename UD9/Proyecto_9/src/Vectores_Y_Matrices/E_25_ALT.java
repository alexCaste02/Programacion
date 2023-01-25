package Vectores_Y_Matrices;

import java.util.Scanner;

public class E_25_ALT {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el numero total de trabajadores");
        int nTrabajadores = (int) readAndValidate();

        Double[][] sueldos = new Double[2][nTrabajadores];

        int genero;
        int hombres = 0;
        int mujeres = 0;
        double sumaSalariosHombres = 0;
        double sumaSalariosMujeres = 0;

        for (int i = 0; i < sueldos[0].length; i++) {

            System.out.println("Introduce el genero del trabajador (0=hombre, 1=mujer)");
            genero = readAndValidateGenero();
            System.out.println("Introduce el sueldo del trabajador");
            sueldos[genero][i] = readAndValidate();

            if (genero == 0) {
                hombres++;
                sumaSalariosHombres += sueldos[genero][i];
            } else {
                mujeres++;
                sumaSalariosMujeres += sueldos[genero][i];
            }

        }

        System.out.println("Sueldo medio de hombres: " + sumaSalariosHombres / hombres);
        System.out.println("Sueldo medio de mujeres: " + sumaSalariosMujeres / mujeres);

    }

    public static double readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("\\d+([.]\\d+)?")) {
                return Double.parseDouble(inputLine);
            }

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }

    public static int readAndValidateGenero() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("[0-1]")) {
                return Integer.parseInt(inputLine);
            }

            System.out.println("El genero introducido no es valido, intentelo de nuevo (0=hombre, 1=mujer)");
        }
    }
}
