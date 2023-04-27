package e_A4;

import java.io.File;

public class MainA4_UD12 {
    public static void main(String[] args) {

        File cosas = new File("UD_12/Proyecto_12/DOCS/Mis Cosas");
        System.out.println(cosas.mkdir());

        File cFotos = new File("UD_12/Proyecto_12/DOCS/FOTOS");
        System.out.println(cFotos.renameTo(new File("UD_12/Proyecto_12/DOCS/Mis Cosas/FOTOS")));

        File cLibros = new File("UD_12/Proyecto_12/DOCS/LECTURAS");
        System.out.println(cLibros.renameTo(new File("UD_12/Proyecto_12/DOCS/Mis Cosas/LECTURAS")));

        File alfab = new File("UD_12/Proyecto_12/DOCS/Alfabeto");
        System.out.println(alfab.mkdir());

        File nueva;
        for (int i = 65; i <= 90; i++) {
            nueva = new File("UD_12/Proyecto_12/DOCS/Alfabeto/"+((char)i));
            System.out.println(nueva.mkdir());
        }

    }
}
