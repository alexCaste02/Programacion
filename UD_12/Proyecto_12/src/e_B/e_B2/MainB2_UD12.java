package e_B.e_B2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Ejercicio B2 - Notas de alumnos
 * El archivo ‘alumnos_notas.txt’ contiene una lista de 10 alumnos y las notas que han
 * obtenido en cada asignatura. El número de asignaturas de cada alumno es variable.
 * Implementa un programa que muestre por pantalla la nota media de cada alumno junto
 * a su nombre y apellido, ordenado por nota media de mayor a menor.
 */

public class MainB2_UD12 {
    public static void main(String[] args) {

        ArrayList<Alumno> listaAlum = new ArrayList<>();

        try (Scanner scf = new Scanner(new File("UD_12/Proyecto_12/DOCS/alumnos_notas.txt"))) {
           while(scf.hasNext()) {
               String nom = scf.next();
               String ape = scf.next();

               int suma = 0;
               int c = 0;
               while (scf.hasNextInt()) {
                   suma += scf.nextInt();
                   c++;
               }
               listaAlum.add(new Alumno(nom, ape, (double) suma / c));
               //TODO: VARIOS NEXT EN LA MISMA LINEA DEVUELVEN LO MISMO
           }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // no he comprobado si es ascendente o descendente
//        listaAlum.sort(new Comparator<Alumno>() {
//            @Override
//            public int compare(Alumno o1, Alumno o2) {
//                if(o1.getMedia() - o2.getMedia() > 0)
//                    return 1;
//                else if (o1.getMedia() - o2.getMedia() < 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });

        listaAlum.sort(Comparator.comparingDouble(Alumno::getMedia).reversed());

        for (Alumno alumno : listaAlum) {
            System.out.println(alumno);
        }

    }
}
