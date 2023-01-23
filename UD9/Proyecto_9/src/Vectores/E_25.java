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

        double[][] notas = new double[4][5];

        for (int alumno = 0; alumno < notas.length; alumno++) {
            for (int asignatura = 0; asignatura < notas[0].length; asignatura++) {
                System.out.println("Introduce la asignatura "+(asignatura+1)+" del alumno "+(alumno+1));
                notas[alumno][asignatura] = readAndValidate();
            }
        }

        double notaMax;
        double notaMin;

        double suma;

        for (int alumno = 0; alumno < notas.length; alumno++) {
            notaMax = notas[alumno][0];
            notaMin = notas[alumno][0];
            suma = 0;

            for (int asignatura = 0; asignatura < notas[0].length; asignatura++) {
                notaMax = Math.max(notaMax,notas[alumno][asignatura]);
                notaMin = Math.min(notaMin,notas[alumno][asignatura]);
                suma+=notas[alumno][asignatura];
            }

            System.out.printf("""
                    
                    Alumno %d
                    Nota Maxima: %.2f
                    Nota Minima: %.2f
                    Nota Media: %.2f
                    
                    """,alumno+1,notaMin,notaMax,suma/5);
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
