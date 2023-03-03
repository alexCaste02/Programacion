package e_09;

public record Autor(String nombre, String pseudonimo) {

    public int compareTo(Autor autor) {
        if (nombre.compareTo(autor.nombre())!=0)
            return nombre.compareTo(autor.nombre());
        else
            return pseudonimo.compareTo(autor.pseudonimo());
    }

    @Override
    public String toString() {
        return String.format("""
                %s '%s'""",nombre,pseudonimo);
    }
}
