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
                
            }
        }



    }

    public static int readAndValidate() {
        while (true) {
            String inputLine = input.nextLine();

            if (inputLine.matches("-?\\d+")) {
                return Integer.parseInt(inputLine);
            }

            System.out.println("El valor introducido no es valido, intentelo de nuevo");
        }
    }

}
