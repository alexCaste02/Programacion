package e_09;

import e_09.Excepciones.PublicacionException;
import e_09.Excepciones.ValorIncorrecto;

public class Libro extends Publicacion {

    private final String ISBN;
    private final String TITULO;
    private final Autor AUTOR;
    private int numEjemplares;

    public Libro(String isbn, String titulo, Autor AUTOR) throws PublicacionException {
        super();
        if (!validarISBN(isbn)) throw new PublicacionException();
        this.ISBN = isbn;
        this.TITULO = titulo;
        this.AUTOR = AUTOR;
        this.numEjemplares = 1;
    }

    public Libro(String isbn, String titulo, Autor AUTOR, int numEjemplares) throws PublicacionException, ValorIncorrecto {
        super();
        if (!validarISBN(isbn)) throw new PublicacionException();
        this.ISBN = isbn;
        this.TITULO = titulo;
        this.AUTOR = AUTOR;
        setNumEjemplares(numEjemplares);
    }

    private void setNumEjemplares(int n) throws ValorIncorrecto {
        if(n<0) throw new ValorIncorrecto(n);
        this.numEjemplares = n;
    }

    static boolean validarISBN(String isbn){
        return isbn.matches("\\d{13}");
    }

    @Override
    void mostrarEnLinea() {

    }
}
