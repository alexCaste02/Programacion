package e_05;

public class Coche extends Vehiculo_Terrestre{

    private boolean aireAcon;

    public Coche(String matricula, String modelo, int numeroRuedas, boolean aireAcon) {
        super(matricula, modelo, numeroRuedas);
        this.aireAcon = aireAcon;
    }

    @Override
    public String toString() {
        return super.toString() +
                "aireAcon=" + aireAcon +
                '}';
    }
}
