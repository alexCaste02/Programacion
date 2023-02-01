package E_06;

public class Ingrediente {
    private String nombre, unidad;
    private int cantidad;

    public Ingrediente(String nombre, int cantidad, String unidad) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {//
        return String.format("%s, %d %s",nombre,cantidad,unidad);
    }
}
