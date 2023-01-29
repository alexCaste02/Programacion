package E_6;

public class Receta {
    private String nombre, elaboracion;
    private int duracion;
    private Ingrediente[] ingredientes;

    public Receta(String nombre, String elaboracion, int duracion, Ingrediente[] ingredientes) {
        this.nombre = nombre;
        this.elaboracion = elaboracion;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void mostrarReceta(){
        System.out.printf("""
                
                Nombre de la receta: %s
                Elaboracion: %s
                Duracion (en minutos): %d
                Ingredientes:
                """,nombre,elaboracion,duracion);

        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente);
        }
    }

}
