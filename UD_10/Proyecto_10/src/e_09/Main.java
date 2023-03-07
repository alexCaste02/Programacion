package e_09;

import e_09.Excepciones.PublicacionException;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Publicacion lib1 = null;
        Publicacion rev1 = null;
        Publicacion lib2 = null;
        Publicacion rev2 = null;
        try {
            lib1 = new Libro(
                    "1234567890123",
                    "Libro 1",
                    new Autor("Javier", "javi")
            );

            rev1 = new Revista(
                    "12345678",
                    "revista 1",
                    1
            );

            lib2 = new Libro(
                    "1234567890123",
                    "Libro 2",
                    new Autor("jacint", "2")
            );

            rev2 = new Revista(
                    "12345678",
                    "revista 2",
                    1
            );


        } catch (PublicacionException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

        biblioteca.anyadir(lib1);
        try {
            biblioteca.anyadirLibro("","", new Autor("jacint", "2"));
        } catch (PublicacionException e) {
            System.out.println("puto mal");
        }
        biblioteca.anyadir(rev1);
        biblioteca.anyadir(lib2);
        biblioteca.anyadir(rev2);

        biblioteca.mostrarLineas();

        biblioteca.ordenar();
        biblioteca.mostrarLineas();




    }



}
