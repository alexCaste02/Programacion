package e_07;

public class Estaciones extends Propiedad{

    private static final int VALOR_ESTACION = 200;

    public Estaciones(String nombre) {
        super(nombre, VALOR_ESTACION, VALOR_ESTACION);
    }

    @Override
    public int getAlquiler(int modificacion) {
        return precio/modificacion;
    }



}
