package e_B.e_B9;

/*
En el fichero datos_personas.bin se encuentra serializada una lista de personas.
Recupera los datos, crea otra lista con aquellas personas con edad entre 20 y 29 años y
guardala serializada en el fichero datos_veintes.ser
 */


import utilidades.Persona;

import java.io.*;
import java.util.ArrayList;


public class MainB9_UD12 {
    public static void main(String[] args) {

        File origenFile = new File("UD_12/Proyecto_12/DOCS/datos_personas.bin");
        File destinoFile = new File(origenFile.getParent(),"datos_veintes.ser");

        ArrayList<Persona> listaPersonas = new ArrayList<>();


        ArrayList<Persona> listaPersonasVeintes = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(origenFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis)
        ){


//            while(bis.available()>0){
                listaPersonas = (ArrayList<Persona>) ois.readObject();
//            }



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Persona p : listaPersonas) {
            if(p.getEdad() <= 29 && p.getEdad() >=20) {
            listaPersonasVeintes.add(p);
        }
    }



        //escribir
        try(FileOutputStream fos = new FileOutputStream(destinoFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos))
        {

            oos.writeObject(listaPersonasVeintes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }









        //COMPROBAR QUE SE HA GUARDADO BIEN
        try(FileInputStream fis = new FileInputStream(destinoFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis))
        {

            System.out.println("LECTURA!!!");

            while(bis.available()>0) {
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
