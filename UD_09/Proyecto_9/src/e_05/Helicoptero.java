package e_05;

public class Helicoptero extends Vehiculo_Aereo{

    private int numeroHelices;

    public Helicoptero(String matricula, String modelo, int numeroAsientos, int numeroHelices) {
        super(matricula, modelo, numeroAsientos);
        this.numeroHelices = numeroHelices;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numeroHelices=" + numeroHelices +
                '}';
    }
}
