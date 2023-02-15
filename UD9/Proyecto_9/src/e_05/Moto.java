package e_05;

public class Moto extends Vehiculo_Terrestre{

    private String color;

    public Moto(String matricula, String modelo, int numeroRuedas) {
        super(matricula, modelo, numeroRuedas);
    }

    @Override
    public String toString() {
        return super.toString() +
                "color='" + color + '\'' +
                '}';
    }
}
