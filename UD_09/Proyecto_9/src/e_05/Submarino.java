package e_05;

public class Submarino extends Vehiculo_Acuatico{

    private int profundidadMaxima;

    public Submarino(String matricula, String modelo, int eslora, int profundidadMaxima) {
        super(matricula, modelo, eslora);
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", profundidadMaxima=" + profundidadMaxima +
                '}';
    }
}
