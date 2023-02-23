package e_02;

public abstract class Aves extends Mascotas{

    private String pico;//podria ser un enum pero buf
    private boolean vuela;


    public Aves(String nombre, int edad, Estado estado, String fechaNacimiento, String pico, boolean vuela) {
        super(nombre, edad, estado, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }

    public abstract void volar();

    @Override
    public String toString() {
        return super.toString()+
                ", pico='" + pico + '\'' +
                ", vuela=" + vuela;
    }

    public String getPico() {
        return pico;
    }

    public void setPico(String pico) {
        this.pico = pico;
    }

    public boolean isVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }
}
