package e_02;

public class Perro extends Mascotas{

    private String raza;//podria ser un enum pero buf
    private boolean pulgas;

    public Perro(String nombre, int edad, Estado estado, String fechaNacimiento, String raza, boolean pulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    @Override
    public void muestra() {
        System.out.println(this);
    }

    @Override
    public void habla() {
        System.out.println("*sonido de perro*");
    }

    @Override
    public String toString() {
        return super.toString()+
                ", raza='" + raza + '\'' +
                ", pulgas=" + pulgas +
                '}';
    }
}
