package e_09;

import e_09.Excepciones.PublicacionException;

public class Revista {

    private final String ISSN;
    private final String NOMBRE;
    private final int NUMERO;

    public Revista(String issn, String nombre, int numero) throws PublicacionException {
        if(!issn.matches("\\d{8}") || numero<=0 ) throw new PublicacionException();
        this.ISSN = issn;
        this.NOMBRE = nombre;
        this.NUMERO = numero;
    }

}
