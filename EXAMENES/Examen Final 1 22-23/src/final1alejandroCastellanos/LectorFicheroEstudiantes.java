package final1alejandroCastellanos;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;


public class LectorFicheroEstudiantes {

    public static void main(String[] args) {

        // Pruebas sin archivo
//        ArrayList<Estudiante> listaPruebas = new ArrayList<>();
//        Estudiante ale = new Estudiante("ABC","Alex","Caste Dalm","alex@caste.com");
//        Estudiante ale2 = new Estudiante("ABC2","Alex2","Caste Dalm","alex@caste.com");
//        listaPruebas.add(ale);
//        listaPruebas.add(ale2);
//        ale.matricular(new Asignatura("Mates"));
//        ale2.matricular(new Asignatura("LENG"));
//
//        try {
//            ale.cambiarNota("Mates",6.4);
//            ale.cambiarNota("Mates",6.4);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//            for (Estudiante estudiante : listaPruebas) {
//                if(estudiante.promociona()) listaPromocionados.add(estudiante);
//                else listaNoPromocionados.add(estudiante);
//            }

        File archivo = new File("Resources/estudiantes.dat");

        try(FileInputStream fis = new FileInputStream(archivo);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis))
        {

            ArrayList<Estudiante> listaPromocionados = new ArrayList<>();
            ArrayList<Estudiante> listaNoPromocionados = new ArrayList<>();

            while(bis.available()>0){
                Estudiante estudiante = (Estudiante) ois.readObject();
                if(estudiante.promociona()) listaPromocionados.add(estudiante);
                else listaNoPromocionados.add(estudiante);
            }


            // Estudiantes promocionados
            System.out.println("=========================");
            System.out.println("Estudiantes promocionados: ");
            System.out.println("---------------------------");
            System.out.printf("%-15s - %-15s - %-25s - %-30s %n",
                    "Identificador", "Nombre", "Apellidos", "Correo"
            );

            for (Estudiante estudiante : listaPromocionados) {
                System.out.println(estudiante);
                System.out.println("--- Notas ---");
                estudiante.mostrarNotas();

                Double sumaNotas = 0.0;
                for (Double nota : estudiante.getAsignaturas().values()) {
                    sumaNotas+=nota;
                }
                System.out.println("\nMedia: "+sumaNotas/estudiante.getAsignaturas().size());
            }


            // Estudiantes NO promocionados
            System.out.println("=========================");
            System.out.println("Estudiantes NO promocionados: ");
            System.out.println("------------------------------");
            System.out.printf("%-15s - %-15s - %-25s - %-30s %n",
                    "Identificador", "Nombre", "Apellidos", "Correo"
            );
            for (Estudiante estudiante : listaNoPromocionados) {
                System.out.println(estudiante);
                System.out.println("--- Notas ---");
                estudiante.mostrarNotas();

                System.out.println("\nAsignaturas suspendidas:");
                for (Map.Entry<Asignatura, Double> entry : estudiante.getAsignaturas().entrySet()) {
                    if(entry.getValue()<5)
                        System.out.println(entry);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
