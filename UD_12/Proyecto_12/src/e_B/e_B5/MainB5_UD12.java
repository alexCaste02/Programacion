package e_B.e_B5;

/*
Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos como
letras del abecedario (A.txt, B.txt… Z.txt). Introducirá en cada archivo las palabras de
‘diccionario.txt’ que comiencen por dicha letra
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
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

        Map<Character,File> mapaLetras = new HashMap<>();

        for (int i = 65; i <= 90; i++) {
            char letra = (char) i;
            File archivoLetra = new File("UD_12/Proyecto_12/DOCS/Diccionario/"+letra+".txt");
            mapaLetras.put(letra,archivoLetra);
        }


        // Otro tipo de 'writer' seria mejor?
        for (Map.Entry<Character, File> entry : mapaLetras.entrySet()) {
            try(PrintWriter pw = new PrintWriter(entry.getValue());
                Scanner scf = new Scanner(new File("UD_12/Proyecto_12/DOCS/diccionario.txt")))
            {
                while (scf.hasNext()){
                    String palabra = scf.next();
                    if(palabra.charAt(0) == entry.getKey()){
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
