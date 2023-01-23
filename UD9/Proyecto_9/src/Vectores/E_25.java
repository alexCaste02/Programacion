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

        System.out.println("");
        int n = (int) readAndValidate();

        Double[][] sueldos = new Double[2][n];

        int gen;
        int trabajadorH=0;
        int trabajadorM=0;


        for (int totalTrabajadores = 0; totalTrabajadores < sueldos[0].length; totalTrabajadores++) {

            System.out.println("Introduce el genero del trabajador (0=hombre, 1=mujer)");
            //FIXME: -validar diferente 0 o 1
            gen = (int) readAndValidate();
            System.out.println("Introduce el sueldo del trabajador");

            if (gen==0) {
                sueldos[gen][trabajadorH] = readAndValidate();
                trabajadorH++;
            } else {
                sueldos[gen][trabajadorM] = readAndValidate();
                trabajadorM++;
            }

        }

        double suma;

        for (int g = 0; g < 2; g++) {

            suma=0;
            for (int trabajador = 0; trabajador < sueldos[0].length; trabajador++) {

                if (sueldos[g][trabajador]==0)
                    break;

                suma+=sueldos[g][trabajador];
            }

            System.out.println(g==o?
                    "Sueldo de hombres: ");

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


}
