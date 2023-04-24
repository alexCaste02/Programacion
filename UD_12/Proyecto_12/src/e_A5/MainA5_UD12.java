package e_A5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainA5_UD12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Escribe la ruta que quieres borrar");
        File toDelete = new File(input.nextLine());
        try {
            borraTodo(toDelete,0);
            System.out.println("Borrado finalizado con exito!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }


    public static boolean borraTodo(File f, int depth) throws FileNotFoundException {
        
        if(!f.exists()) throw new FileNotFoundException("No existe");

        for (int i = 1; i <= depth; i++) {
            System.out.print("--");
        }
        System.out.print("- ");
        
        if(f.isFile()) {
            System.out.println("Borrando archivo "+f.getName());

        } else {

            System.out.println("Borrando contenido de "+f.getPath());
            File[] contenido = f.listFiles();
            assert contenido != null;
            int size = contenido.length;
            int n = 1;


            for (File file : contenido) {

                if(file.isDirectory()) borraTodo(file,depth+1);

                for (int i = 1; i <= depth; i++) {
                    System.out.print("--");
                }
                System.out.print("- ");

                if (file.isFile()) {
                    System.out.printf(
                            (file.delete() ?
                                    "Archivo borrado correctamente " :
                                    "Archivo no ha podido ser borrado ")
                                    + "[%s] (%d/%d)%n", file.getName(), n, size);
                }

                n++;
            }

            for (int i = 1; i <= depth; i++) {
                System.out.print("--");
            }
            System.out.print("- ");

            System.out.println("Borrando directorio...");

        }

        return f.delete();

    }

    public static int mammaMiaPizzeria(int d){
        
    }
}
