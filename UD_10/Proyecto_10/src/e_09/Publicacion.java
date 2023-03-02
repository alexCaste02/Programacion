package e_09;

public abstract class Publicacion {

    private static int idTracker;

    final int ID;

    public Publicacion() {
        this.ID = idTracker;
        idTracker++;
    }

    abstract void mostrarEnLinea();



}
