package e_09;

import e_09.Excepciones.PublicacionException;
import e_09.Excepciones.ValorIncorrecto;

import java.util.Objects;

public class Libro extends Publicacion implements Comparable<Publicacion> {

    private final String isbn;
    private final String titulo;
    private final Autor autor;
    private int numEjemplares;

    public Libro(String isbn, String titulo, Autor autor) throws PublicacionException {
        super();
        if (!validarISBN(isbn)) throw new PublicacionException();
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = 1;
    }

    public Libro(String isbn, String titulo, Autor autor, int numEjemplares) throws PublicacionException, ValorIncorrecto {
        super();
        if (!validarISBN(isbn)) throw new PublicacionException();
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        setNumEjemplares(numEjemplares);
    }

    private void setNumEjemplares(int n) throws ValorIncorrecto {
        if(n<0) throw new ValorIncorrecto(n);
        this.numEjemplares = n;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    static boolean validarISBN(String isbn){
        return isbn.matches("\\d{13}");
    }

    @Override
    void mostrarEnLinea() {
        System.out.printf("""
                ISBN: %s, Titulo: %s, Autor: %s, Nº ejemplares: %d""",isbn,titulo,autor,numEjemplares);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn) && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, titulo, autor);
    }


    @Override
    public int compareTo(Publicacion o) {
        if(o.getClass() == Revista.class){
            Libro libro = (Libro) o;
            if (titulo.compareTo(libro.getTitulo())!=0)
                return titulo.compareTo(libro.getTitulo());
            else
                return autor.compareTo(libro.getAutor());
        } else {
            return -1;
        }
    }
}
