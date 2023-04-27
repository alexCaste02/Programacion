package e_A2;

import ReaderAndValidator.InvalidInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static ReaderAndValidator.InputReader.readAndValidateYN;

public class MainA2_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String ruta;
        boolean repeat = true;
        boolean info;
        do {

            System.out.print("Introduce una ruta del sistema de archivos (No introduzcas nada para finalizar): ");
            ruta = input.nextLine();




            if(ruta.equals(""))
                repeat = false;
            else {
                System.out.print("Quieres informacion del archivo? (Y o F)");

                try {
                    info = readAndValidateYN();
                    muestraInfoRuta(new File(ruta),info);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidInputException e) {
                    System.out.println("Valor incorrecto. Asumimos F");
                }
            }

        } while (repeat);

    }

    static void muestraInfoRuta(File file, boolean info) throws FileNotFoundException {

        if(!file.exists()) throw new FileNotFoundException("No existe esa ruta");

        if(info){
            System.out.println("Tamaño: "+file.length()+" Bytes");
            Date fecha = new Date(file.lastModified());
            System.out.println("Ultima modificacion: "+fecha);
        }


        if(file.isFile()){

            System.out.println("[A] "+file.getName());

        } else if(file.isDirectory()) {  //Creo que no hace falta, pero asi uso el metodo

            Arrays.stream(Objects.requireNonNull(file.listFiles())).sorted((o1, o2) -> {
                if (o1.isFile() && o2.isFile() || o1.isDirectory() && o2.isDirectory())
                    return o1.compareTo(o2);
                else if (o1.isFile() && o2.isDirectory())
                    return 1;
                else
                    return -1;
            }).forEach(f -> System.out.println((f.isFile()?"[A] ":"[*] ")+f.getName()));

        }



    }
}
