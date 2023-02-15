package e_02;

public class Canario extends Aves{

    String color;//podria ser un enum pero buf
    boolean canta;

    public Canario(String nombre, int edad, Estado estado, String fechaNacimiento, String pico, boolean vuela, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
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
        System.out.println("*sonido de canario*");
    }
}
