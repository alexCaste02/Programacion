package e_05;

public abstract class Vehiculo {
    private final String matricula;
    private final String modelo;

    public Vehiculo(String matricula, String modelo) {

        this.matricula = setMatricula(matricula);
        this.modelo = modelo;

    }

    public abstract String setMatricula(String matricula);

    public abstract void imprimir();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'';
    }
}
