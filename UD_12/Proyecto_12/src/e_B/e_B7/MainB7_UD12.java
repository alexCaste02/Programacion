package e_B.e_B7;

/*
Implementa un programa que lea un documento de texto y muestre por pantalla
algunos datos estadísticos: nº de líneas, nº de palabras, nº de caracteres y cuáles son las
10 palabras más comunes (y cuántas veces aparecen). Prueba el programa con los
archivos de la carpeta ‘Libros’.
NOTA: Para llevar la cuenta de cuántas veces aparece cada palabra puedes utilizar una
HashTable. Una tabla hash es una estructura de datos tipo colección (como el ArrayList), que
permite almacenar pares clave-valor. Por ejemplo {“elefante”, 5} o {“casa”, 10} son pares
<String,Integer> que asocian una palabra (clave) con un nº entero (valor).
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainB7_UD12 {
    public static void main(String[] args) {

        File f = new File("UD_12/Proyecto_12/DOCS/Mis Cosas/LECTURAS/lazarillo");

        int nLineas = 0;
        int nPalabras = 0;
        int nCaracteres = 0;
        Map<String, Integer> repsPalabras = new HashMap<>();

        try (Scanner scf = new Scanner(f)) {
            while (scf.hasNextLine()) {
                String linea = scf.nextLine();
                nLineas++;
                nCaracteres += linea.length();
                String[] palabrasLinea = linea.split(" ");
                nPalabras += palabrasLinea.length;

                for (String s : palabrasLinea) {
                    if (!s.equals("")) repsPalabras.put(s,repsPalabras.getOrDefault(s,0)+1);
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.printf("""
                Numero de lineas: %d
                Numero de palabras: %d
                Numero de caracteres: %d
                
                Palabras mas comunes:
                """,nLineas,nPalabras,nCaracteres);

        ArrayList<Map.Entry<String, Integer>> repsPalabrasOrdenado = new ArrayList<>(repsPalabras.entrySet());
        repsPalabrasOrdenado.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(repsPalabrasOrdenado);

        Iterator<Map.Entry<String, Integer>> iter = repsPalabrasOrdenado.iterator();
        for (int i = 0; i < 10; i++) {
            if (iter.hasNext()) System.out.println(iter.next());
        }

    }
}
