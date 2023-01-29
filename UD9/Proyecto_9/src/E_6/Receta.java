package E_6;

public class Receta {
    private String Nombre, Elaboracion;
    private int Duracion;
    private Ingrediente[] ingredientes;

    public Receta(String nombre, String elaboracion, int duracion, Ingrediente[] ingredientes) {
        Nombre = nombre;
        Elaboracion = elaboracion;
        Duracion = duracion;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getElaboracion() {
        return Elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        Elaboracion = elaboracion;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public void mostrarReceta(){

    }
}
