package e_09;

import e_09.Excepciones.PublicacionException;
import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {

    ArrayList<Publicacion> publicaciones = new ArrayList<>();

    //    public void anyadir(Revista revista){
//    }

    //Quiere que usemos polimorfismo?
    public void anyadir(Publicacion publicacion){
        publicaciones.add(publicacion);
    }

    public void anyadirLibro(String isbn, String titulo, Autor autor) throws PublicacionException {
        publicaciones.add(new Libro(isbn,titulo,autor));
    }

    public boolean buscar(String name){
        for (Publicacion publicacion : publicaciones) {
            if (publicacion.getClass() == Libro.class){
                Libro libro = (Libro) publicacion; //casteamos en otra linea por claridad
                if( libro.getTitulo().equals(name)) return true;
            } else {
                Revista revista = (Revista) publicacion;
                if( revista.getNombre().equals(name)) return true;
            }
        }
        return false;
    }

    public boolean buscarLibro(String isbn, String titulo, Autor autor) throws PublicacionException {
        Libro libroBuscado = new Libro(isbn, titulo, autor); //claridad

        for (Publicacion publicacion : publicaciones) {
            if(publicacion.getClass() == Libro.class) {
                Libro libro = (Libro) publicacion;
                if (libroBuscado.equals(libro)) return true;
            }
        }
        return false;
    }

    public ArrayList<Revista> revistasOrdenadas() {
        ArrayList<Revista> revistasrevistas = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            Revista revista = (Revista) publicacion;
            if(publicacion.getClass() == Revista.class) revistasrevistas.add(revista);
        }
        Collections.sort(revistasrevistas);
        return revistasrevistas;
    }

    public void ordenar(){
        Collections.sort(publicaciones);
    }

    public void mostratLineas(){
        ordenar();
        System.out.print("""
                ISSN %20s, Nombre: %20s, Numero: %20d""");
        for (Publicacion publicacion : publicaciones) {
            publicacion.mostrarEnLinea();
        }
    }


}
