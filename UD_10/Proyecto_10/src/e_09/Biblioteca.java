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
                if(libro.getTitulo().equals(name)) return true;
            } else {
                Revista revista = (Revista) publicacion;
                if(revista.getNombre().equals(name)) return true;
            }
        }
        return false;
    }

    public boolean buscarLibro(Libro libroBuscado) throws PublicacionException {
        for (Publicacion publicacion : publicaciones) {
            if (libroBuscado.equals(publicacion)) return true;
        }
        return false;
    }

    public boolean buscarLibro(String isbn, String titulo, Autor autor) throws PublicacionException {
        Libro libroBuscado = new Libro(isbn, titulo, autor); //claridad
        return buscarLibro(libroBuscado);
    }

    public ArrayList<Revista> revistasOrdenadas() {
        ArrayList<Revista> listaRevistas = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            if(publicacion.getClass() == Revista.class) listaRevistas.add((Revista) publicacion);
        }
        Collections.sort(listaRevistas);
        return listaRevistas;
    }

    public void ordenar(){
        Collections.sort(publicaciones);

    }

    public void mostrarLineas(){
//        ordenar();
        System.out.printf("%-2s - %-15s - %-10s - %-15s - %-2s\n",
                "ID", "ISBN/ISSN", "Titulo", "Autor", "Nº");
        for (Publicacion publicacion : publicaciones) {
            publicacion.mostrarEnLinea();
            System.out.println();
        }
        System.out.println();
    }


}
