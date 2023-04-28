package e_B.e_B3;

/*
 * Implementa un programa que pida al usuario un nombre de archivo A para lectura y
 * otro nombre de archivo B para escritura. Leerá el contenido del archivo A (por ejemplo
 * ‘usa_personas.txt’) y lo escribirá ordenado alfabéticamente en B (por ejemplo
 * ‘usa_personas_sorted.txt’).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainB3_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el nombre del archivo A");
        File archivoA = new File("UD_12/Proyecto_12/DOCS/"+input.nextLine());

        // TODO: comprobaciones de input
//        System.out.println(archivoA.exists());
//        System.out.println(archivoA.getAbsolutePath());

        System.out.println("Introduce el nombre del archivo B");
        File archivoB = new File("UD_12/Proyecto_12/DOCS/"+input.nextLine());


        ArrayList<String> lineas = new ArrayList<>();
        try(Scanner scf = new Scanner(archivoA);
            PrintWriter pw = new PrintWriter(archivoB))
        {

            while (scf.hasNext()){
                lineas.add(scf.nextLine());
            }

            lineas.sort(String::compareTo);

            for (String linea : lineas) {
                pw.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
