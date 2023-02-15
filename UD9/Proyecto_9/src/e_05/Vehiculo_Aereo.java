package e_05;

public class Vehiculo_Aereo extends Vehiculo{

    private final int numeroAsientos;

    public Vehiculo_Aereo(String matricula, String modelo, int numeroAsientos) {
        super(matricula, modelo);
        this.numeroAsientos = numeroAsientos;
    }

    @Override
    public String setMatricula(String matricula) {
        if(matricula.toLowerCase().matches("[a-z]{4}\\d{6}")) {
            return matricula;
        } else {
            System.err.println("Error al instanciar. Matricula no valida. (Almacenada como nula)");
            return null;
        }
    }

    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString()+
                "numeroAsientos=" + numeroAsientos +
                '}';
    }
}
