package e_09;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor autor)) return false;
        return Objects.equals(nombre, autor.nombre) && Objects.equals(pseudonimo, autor.pseudonimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pseudonimo);
    }
}
