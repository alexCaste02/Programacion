package e_09;

import e_09.Excepciones.ISBNInvalido;
import e_09.Excepciones.ValorIncorrecto;

public class Libro extends Publicacion {

    private final String ISBN;
    private final String TITULO;
    private final Autor AUTOR;
    private int numEjemplares;

    public Libro(String isbn, String titulo, Autor AUTOR) throws ISBNInvalido {
        super();
        if (!validarISBN(isbn)) throw new ISBNInvalido();
        this.ISBN = isbn;
        this.TITULO = titulo;
        this.AUTOR = AUTOR;
        this.numEjemplares = 1;
    }

    public Libro(String isbn, String titulo, Autor AUTOR, int numEjemplares) throws ISBNInvalido, ValorIncorrecto {
        super();
        if (!validarISBN(isbn)) throw new ISBNInvalido();
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
