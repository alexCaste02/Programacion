/*

25. Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una
empresa y detectar si existe brecha salarial entre ambos. El programa pedirá por
teclado la información de N personas distintas (valor también introducido por teclado).
Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo. Esta
información debe guardarse en una única matriz. Luego se mostrará por pantalla el
sueldo medio de cada género.

*/

package Vectores;


import java.util.Scanner;

public class E_25 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduce el numero total de trabajadores");
        int n = (int) readAndValidate();

        Double[][] sueldos = new Double[2][n];

        int genero;
        int hombres=0;
        int mujeres=0;
        double sumaSalarios;

        for (int i = 0; i < sueldos[0].length; i++) {

            System.out.println("Introduce el genero del trabajador (0=hombre, 1=mujer)");
            genero = readAndValidateGenero();
            System.out.println("Introduce el sueldo del trabajador");

            if (genero==0) {
                sueldos[genero][hombres] = readAndValidate();
                hombres++;
            } else {
                sueldos[genero][mujeres] = readAndValidate();
                mujeres++;
            }

        }


        for (int g = 0; g < 2; g++) {

            sumaSalarios=0;
            for (int trabajador = 0; trabajador < sueldos[0].length; trabajador++) {

                if (sueldos[g][trabajador]!=null && sueldos[g][trabajador]!=0) {
                    sumaSalarios += sueldos[g][trabajador];
                }

            }

            System.out.println(g==0?
                    "Sueldo medio de hombres: "+sumaSalarios/(hombres):
                    "Sueldo medio de mujeres: "+sumaSalarios/(mujeres)
            );

        }

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