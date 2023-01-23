/*

24. Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados
“Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por
teclado y luego el programa mostrará la nota mínima, máxima y media de cada
alumno.

*/

package Vectores;


import java.util.Scanner;

public class E_24 {

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
