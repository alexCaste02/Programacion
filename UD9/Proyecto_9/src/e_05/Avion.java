package e_05;

public class Avion extends Vehiculo_Aereo{

    private int maxTiempoVuelo;

    public Avion(String matricula, String modelo, int numeroAsientos, int maxTiempoVuelo) {
        super(matricula, modelo, numeroAsientos);
        this.maxTiempoVuelo = maxTiempoVuelo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "maxTiempoVuelo=" + maxTiempoVuelo +
                '}';
    }
}
