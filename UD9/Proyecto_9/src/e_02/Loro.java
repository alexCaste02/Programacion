package e_02;

public class Loro extends Aves{

    private String origen;//podria ser un enum pero buf
    private boolean habla;

    public Loro(String nombre, int edad, Estado estado, String fechaNacimiento, String pico, boolean vuela, String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
    }

    @Override
    public void volar() {
        //ultrabasico. asumo que da igual
        setVuela(true);
    }

    @Override
    public void muestra() {
        System.out.println(this);
    }

    @Override
    public void habla() {
        System.out.println("*sonido de loro*");
    }

    @Override
    public String toString() {
        return super.toString()+
                ", origen='" + origen + '\'' +
                ", habla=" + habla +
                '}';
    }
}
