package e_A1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainA1_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String ruta;
        boolean repeat = true;
        do {

            System.out.print("Introduce una ruta del sistema de archivos (No introduzcas nada para finalizar): ");
            ruta = input.nextLine();

            if(ruta.equals(""))
                repeat = false;
            else {
                try {
                    muestraInfoRuta(new File(ruta));
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (repeat);

    }

    static void muestraInfoRuta(File file) throws FileNotFoundException {

        if(!file.exists()) throw new FileNotFoundException("No existe esa ruta");


        if(file.isFile()){

            System.out.println("[A] "+file.getName());

        } else if(file.isDirectory()) {  //Creo que no hace falta, pero asi uso el metodo

            Arrays.stream(Objects.requireNonNull(file.listFiles())).sorted((o1, o2) -> {

                if (o1.isDirectory() && o2.isFile()) return -1;
                else if (o2.isDirectory() && o1.isFile()) return 1;
                return 0;

            }

            ).forEach(f -> System.out.println((f.isFile()?"[A] ":"[*] ")+f.getName()));
            //map tb es posible

        }

    }
}
