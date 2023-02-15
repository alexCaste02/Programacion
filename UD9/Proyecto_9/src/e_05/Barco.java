package e_05;

public class Barco extends Vehiculo_Acuatico{

    private boolean motor;

    public Barco(String matricula, String modelo, int eslora, boolean motor) {
        super(matricula, modelo, eslora);
        this.motor = motor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "motor=" + motor +
                '}';
    }
}
