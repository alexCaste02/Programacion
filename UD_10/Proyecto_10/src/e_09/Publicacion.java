package e_09;

import java.util.Objects;

public abstract class Publicacion implements Comparable<Publicacion>{

    private static int idTracker;

    final int id;

    public Publicacion() {
        this.id = idTracker;
        idTracker++;
    }

    abstract void mostrarEnLinea();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publicacion that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
