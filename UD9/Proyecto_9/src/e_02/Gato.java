package e_02;

public class Gato extends Mascotas{

    private String color;//podria ser un enum pero buf
    private boolean peloLargo;

    public Gato(String nombre, int edad, Estado estado, String fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public void muestra() {
        System.out.println(this);
    }

    @Override
    public void habla() {
        System.out.println("*sonido de gato*");
    }

    @Override
    public String toString() {
        return super.toString()+
                ", color='" + color + '\'' +
                ", peloLargo=" + peloLargo +
                "} ";
    }

}
