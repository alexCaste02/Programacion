package final1alejandroCastellanos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Asignatura implements Serializable {

    @Serial
    private static final long serialVersionUID = 2223L;

    public final String nombre;
    public final int codigo;

    //Usamos atributo estatico para mantener la cuenta
    private static int contadorCodigo = 1;

    public Asignatura(String nombre) {
        this.nombre = nombre;
        codigo = contadorCodigo++;
    }

    /**
     * Equals definiendo que 2 Asignaturas son iguales si tienen el mismo nombre
     * @param o Objeto al que se compara
     * @return True si el objeto es de clase 'Asignatura' y tiene el mismo nombre
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
