package e_07;

public abstract class Propiedad extends Casilla {

    protected final int precio;
    protected final int hipoteca;
    private int propietario;

    public Propiedad(String nombre, int codigo, int precio, int hipoteca, int propietario) {
        super(nombre, codigo);
        this.precio = precio;
        this.hipoteca = hipoteca;
        this.propietario = -1;
    }

    public int getPropietario() {
        return propietario;
    }

    public abstract int getAlquiler(int modificacion);
}
