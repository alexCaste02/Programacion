package e_09;

import e_09.Excepciones.PublicacionException;

public class Revista extends Publicacion implements Comparable<Publicacion>{

    private final String issn;
    private final String nombre;
    private final int numero;

    public Revista(String issn, String nombre, int numero) throws PublicacionException {
        if(!issn.matches("\\d{8}") || numero<=0 ) throw new PublicacionException();
        this.issn = issn;
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    void mostrarEnLinea() {
        System.out.printf("%-2s - %-15s - %-10s - %-15s - %-2s"
                ,super.id,issn,nombre,nombre,numero);
    }


    public String getIssn() {
        return issn;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int compareTo(Publicacion o) {
        if(o.getClass() == Revista.class){
            Revista revista = (Revista) o;
            if (nombre.compareTo(revista.getNombre())!=0)
                return nombre.compareTo(revista.getNombre());
            else
                return issn.compareTo(revista.getIssn());
        } else {
            return 1;
        }
    }
}
