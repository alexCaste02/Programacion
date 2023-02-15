package e_05;

public class Vehiculo_Acuatico extends Vehiculo{

    private final int eslora;

    public Vehiculo_Acuatico(String matricula, String modelo, int eslora) {
        super(matricula, modelo);
        this.eslora = eslora;
    }

    @Override
    public String setMatricula(String matricula) {
        if(matricula.toLowerCase().matches("[a-z]{3,10}")) {
            return matricula;
        } else {
            System.err.println("Error al instanciar. Matricula no valida. (Almacenada como nula)");
            return null;
        }
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString()+
                ", eslora=" + eslora;
    }
}
