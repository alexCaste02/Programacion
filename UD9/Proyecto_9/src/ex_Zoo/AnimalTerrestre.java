package ex_Zoo;

public class AnimalTerrestre extends Animal {

    private int recinto;
    private int longitudSalto;

    public AnimalTerrestre(String nombre, int estancia, int recinto, int longitudSalto) {
        super(nombre, estancia);
        this.recinto = recinto;
        this.longitudSalto = longitudSalto;
    }

    public int getRecinto() {
        return recinto;
    }
    public void setRecinto(int recinto) {
        this.recinto = recinto;
    }
    public int getLongitudSalto() {
        return longitudSalto;
    }
    public void setLongitudSalto(int longitudSalto) {
        this.longitudSalto = longitudSalto;
    }

    @Override
    public void ejercicio() {
        System.out.println("El animal terrestre hace ejercicio");
    }
}
