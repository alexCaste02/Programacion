package e_07;

public class Estaciones extends Propiedad{

    public Estaciones(String nombre, int codigo, int precio, int hipoteca, int propietario) {
        super(nombre, codigo, precio, hipoteca, propietario);
    }

    @Override
    public int getAlquiler(int modificacion) {
        return 0;
    }

}
