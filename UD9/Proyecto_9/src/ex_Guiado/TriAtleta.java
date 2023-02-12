package ex_Guiado;

public class TriAtleta implements Nadador, Saltador {

    private String nombre;
    private int velCorriendo;
    private int velNadando;
    private int velBicicleta;

    public TriAtleta(String nombre, int velCorriendo, int velNadando, int velBicicleta) {
        this.nombre = nombre;
        this.velCorriendo = velCorriendo;
        this.velNadando = velNadando;
        this.velBicicleta = velBicicleta;
    }

    @Override
    public boolean saltar(int centimetros) {
        // Los triatletas no saltan
        return false;
    }

    @Override
    public int nadar(int metros) {
        // Su velocidad es en kilometros por hora.
        // la pasamos a metros por segundo
        double metrosSegundo = this.velNadando / 0.27777778;
        return (int) (metros * metrosSegundo);
    }

    @Override
    public int velocidadMS() {
        //TODO: Deberiamos devolver una segun el deporte?
        return velNadando;
    }

}