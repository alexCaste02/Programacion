package e_B.e_B9;

import utilidades.Persona;

import java.io.*;
import java.util.ArrayList;

public class MainB9_UD12_v2 {

    public static void main(String[] args) {
        File origenFile = new File("UD_12/Proyecto_12/DOCS/datos_personas.bin");
        File destinoFile = new File(origenFile.getParent(),"datos_veintes.ser");

        ArrayList<Persona> listaPersonas = leerListaPersonasDesdeFichero(origenFile);

        ArrayList<Persona> listaPersonasVeintes = obtenerPersonasEntre20y29(listaPersonas);

        escribirListaPersonasEnFichero(listaPersonasVeintes, destinoFile);

        leerListaPersonasDesdeFicheroYMostrar(destinoFile);
    }

    private static ArrayList<Persona> leerListaPersonasDesdeFichero(File file) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            while (bis.available() > 0) {
                listaPersonas = (ArrayList<Persona>) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }

    private static ArrayList<Persona> obtenerPersonasEntre20y29(ArrayList<Persona> listaPersonas) {
        ArrayList<Persona> listaPersonasVeintes = new ArrayList<>();
        for (Persona p : listaPersonas) {
            if (p.getEdad() <= 29 && p.getEdad() >= 20) {
                listaPersonasVeintes.add(p);
            }
        }
        return listaPersonasVeintes;
    }

    private static void escribirListaPersonasEnFichero(ArrayList<Persona> listaPersonas, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(listaPersonas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerListaPersonasDesdeFicheroYMostrar(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            System.out.println("LECTURA!!!");
            while (bis.available() > 0) {
                ArrayList<Persona> lista = (ArrayList<Persona>) ois.readObject();
                for (Persona persona : lista) {
                    persona.imprime();
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
