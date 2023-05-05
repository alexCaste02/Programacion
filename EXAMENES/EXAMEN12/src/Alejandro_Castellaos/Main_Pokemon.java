package Alejandro_Castellaos;

import java.io.*;
import java.util.*;

public class Main_Pokemon {
    public static void main(String[] args) {

        // Estructura de tipo conjunto
        Set<Pokemon> conjuntoPoke = new HashSet<>();

        // Archivos de origen (pokemon.csv) y destino (pokemon_ordenados.ser) con sus rutas
        File pokeFile = new File("Resources/pokemon.csv");
        File destinoFile = new File("Resources/pokemon_ordenados.ser");

        //try-for-resources que crea un Scanner del archivo origen
        // y el grupo de objetos de las clases que nos permiten guardar
        // objetos de forma serializada
        try (Scanner scf = new Scanner(pokeFile);
             FileOutputStream fos = new FileOutputStream(destinoFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {

            // Mientras queden lineas en el .csv == Quedan pokemons
            while (scf.hasNextLine()) {
                String[] linea = scf.nextLine().split(",");

                //Comprobamos que el split haya separado 4 Strings (datos)
                // para saber si en la linea se encuentra un pokemon con formato valido
                if (linea.length == 4) {
                    conjuntoPoke.add(new Pokemon(
                            linea[0],
                            Integer.parseInt(linea[1]),
                            Integer.parseInt(linea[2]),
                            linea[3])
                    );
                }
            }

            //Guardamos en una List de pokemons el conjunto de pokemons ordenados
            // primero por ipo y en caso de igualdad por nombre

            //Utilizamos un stream del conjunto de pokemons que ordenamos segun el
            // criterio mencionado y luego convertimos a lista
            List<Pokemon> listaOrdenada = conjuntoPoke.stream().sorted((o1, o2) -> {
                if (o1.getTipo().equals(o2.getTipo()))
                    return o1.getNombre().compareTo(o2.getNombre());
                else
                    return o1.getTipo().compareTo(o2.getTipo());
            }).toList();


            //Guardamos los objetos de forma serializada recorriendo la lista ordenada
            for (Pokemon p : listaOrdenada) {
                oos.writeObject(p);
            }

        //Mostramos mensajes diferentes segun el error capturado
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado:");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de Input-Output:");
            e.printStackTrace();
        }

        // ----- PRUEBAS -----

        // Intentamos volver a leerlos y mostrarlos con el orden guardado

//        try (FileInputStream fis = new FileInputStream(destinoFile);
//             BufferedInputStream bis = new BufferedInputStream(fis);
//             ObjectInputStream ois = new ObjectInputStream(bis)
//        ) {
//
//            while (bis.available() > 0) {
//                Alejandro_Castellaos.Pokemon p = (Alejandro_Castellaos.Pokemon) ois.readObject();
//                System.out.print(p);
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

}