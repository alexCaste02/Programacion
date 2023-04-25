package e_A3;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;


public class MainA3_UD12 {
    public static void main(String[] args) {


        File carpetaDocus = new File("UD_12/Proyecto_12/Documentos");
        System.out.println(carpetaDocus.renameTo(new File("UD_12/Proyecto_12/DOCS")));


        File carpetaFotos = new File("UD_12/Proyecto_12/DOCS/Fotografias");
        File carpetaLibros = new File("UD_12/Proyecto_12/DOCS/Libros");
        System.out.println(carpetaFotos.renameTo(new File("UD_12/Proyecto_12/DOCS/FOTOS")));
        System.out.println(carpetaLibros.renameTo(new File("UD_12/Proyecto_12/DOCS/LECTURAS")));

        carpetaFotos = new File("UD_12/Proyecto_12/DOCS/FOTOS");
        carpetaLibros = new File("UD_12/Proyecto_12/DOCS/LECTURAS");

        File[] archivosCarpetaFotos = carpetaFotos.listFiles();
        File[] archivosCarpetaLibros = carpetaLibros.listFiles();

        ArrayList<File> archivosARenombrar = new ArrayList<>();
        assert archivosCarpetaFotos != null && archivosCarpetaLibros != null;
        archivosARenombrar.addAll(Arrays.asList(archivosCarpetaFotos));
        archivosARenombrar.addAll(Arrays.asList(archivosCarpetaLibros));


        for (File file : archivosARenombrar) {
            String ruta = file.getPath();
            String nuevoNombre = ruta.substring(0,ruta.lastIndexOf("."));
            System.out.println(file.renameTo(new File(nuevoNombre)));
            System.out.println(nuevoNombre);
        }

    }
}
