package e_B.e_B5;

/*
Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos como
letras del abecedario (A.txt, B.txt… Z.txt). Introducirá en cada archivo las palabras de
‘diccionario.txt’ que comiencen por dicha letra
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainB5_UD12 {
    public static void main(String[] args) {

        // Separados por claridad
        File dicc = new File("UD_12/Proyecto_12/DOCS/Diccionario");
        System.out.println(dicc.mkdir()?
                "Carpeta 'Diccionario' creada":
                "Carpeta 'Diccionario' no creada"
        );

        Map<String,File> mapaLetrasConArchivos = new HashMap<>();

        for (char letra = 65; letra <= 90; letra++) {
            File archivoLetra = new File(dicc,letra+".txt"); //!!! MUCHO MAS FACIL, RECORDAR
            mapaLetrasConArchivos.put(String.valueOf(letra),archivoLetra);
        }


        // Otro tipo de 'writer' seria mejor?
        //TODO: separar vocales para distinguir acentos
        for (Map.Entry<String, File> entry : mapaLetrasConArchivos.entrySet()) {
            try(PrintWriter pw = new PrintWriter(entry.getValue());
                Scanner scf = new Scanner(new File("UD_12/Proyecto_12/DOCS/diccionario.txt")))
            {
                while (scf.hasNext()){
                    String palabra = scf.next();
                    if(palabra.toUpperCase().startsWith(entry.getKey())){
                        pw.println(palabra);
                    }
                }
                pw.println();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
