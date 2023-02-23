package e_05;

public class Vehiculo_Terrestre extends Vehiculo{

    private final int numeroRuedas;

    public Vehiculo_Terrestre(String matricula, String modelo, int numeroRuedas) {
        super(matricula, modelo);
        this.numeroRuedas = numeroRuedas;
    }

    @Override
    public String setMatricula(String matricula) {
        if(matricula.toLowerCase().matches("\\d{4}[a-z]{3}")) {
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
                "numeroRuedas=" + numeroRuedas +
                '}';
    }
}
