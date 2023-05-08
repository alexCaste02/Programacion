package e_B.e_B8;

/*
Copia el fichero Persona.jar en el directorio de tu proyecto. Añadirlo como librería. Ya
podemos usar la clase utilidades.Persona.
En el fichero datos_personas.csv del directorio Documentos tenemos datos de personas.
Crea un mapa para guardar todos los datos de las personas, referenciadas por su dni.
Lee el fichero, crea objetos Persona con sus datos y añádelos al mapa.
A continuación pregunta por un dni, y mostrará los datos de esa persona si se encuentra
en el sistema, o informará que no se encuentra. Se repetirá hasta que se introduzca “fin”.
Para finalizar genera un fichero en el directorio Documentos, con nombre
datos_junilados.csv con los datos en formato “dni;nombre;apellidos;edad” de las
personas jubiladas, ordenadas por dni.
 */

import utilidades.Persona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.System.in;

public class MainB8_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(in);
        Map<String, Persona> dniPersonaMapa = new HashMap<>();

        //guardar personas en mapa
        try (Scanner scf = new Scanner(new File("UD_12/Proyecto_12/DOCS/datos_personas.csv"))) {
            while (scf.hasNextLine()) {
                String[] lineaPersona = scf.nextLine().split(";");
                dniPersonaMapa.put(lineaPersona[0], new Persona(lineaPersona[0], lineaPersona[1], lineaPersona[2], Integer.parseInt(lineaPersona[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //buscar persona
        Persona p = null;
        boolean repetir = true;
        while (repetir) {
            System.out.println("Introduce un dni (o 'fin' para terminar)");
            String txt = input.nextLine();

            if (txt.equals("fin")) {
                break;
            }

            if (!Persona.validarDNI(txt)) {
                System.out.println("DNI no valido");
                continue;
            }

            for (Map.Entry<String, Persona> entry : dniPersonaMapa.entrySet()) {
                if (txt.equals(entry.getKey())) {
                    p = entry.getValue();
                    repetir = false;
                }
            }
        }

        if (p == null) System.out.println("No se ha encontrado persona");
        else System.out.println("Se encuentra: " + p);


        //jubilados
        try (PrintWriter pw = new PrintWriter("UD_12/Proyecto_12/DOCS/datos_junilados.csv")) {

            ArrayList<Persona> personasJubiladas = new ArrayList<>();
            for (Map.Entry<String, Persona> entry : dniPersonaMapa.entrySet()) {
                if (entry.getValue().esJubilado()) personasJubiladas.add(entry.getValue());
            }

            personasJubiladas.sort(Comparator.comparing(Persona::getDni));

            for (Persona pj : personasJubiladas) {
                pw.println(pj.getDni() + ";" + pj.getNombre() + ";" + pj.getApellidos() + ";" + pj.getEdad());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}