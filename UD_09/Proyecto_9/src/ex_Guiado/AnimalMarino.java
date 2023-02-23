package ex_Guiado;

public class AnimalMarino extends Animal implements Nadador {

    private TipoAgua tipoAgua;
    private int velocidad;

    public AnimalMarino(String nombre, int estancia, TipoAgua tipoAgua, int velocidad) {
        super(nombre, estancia);
        this.tipoAgua = tipoAgua;
        this.velocidad = velocidad;
    }

    public TipoAgua getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(TipoAgua tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void ejercicio() {
        System.out.println("El animal marino hace ejercicio");
    }

    @Override
    public int nadar(int metros) {
        double metrosSegundo = this.velocidad / 0.27777778;
        return (int) (metros * metrosSegundo);
    }

    @Override
    public int velocidadMS() {
        return velocidad;
    }

}
