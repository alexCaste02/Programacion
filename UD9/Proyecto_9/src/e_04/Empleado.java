package e_04;

public class Empleado {
    private final String NOMBRE;
    private final String DNI;

    private double sueldoBrutoMensual;
    private int edad;
    private String telefono;
    private String direccion;



    public Empleado(String nombre, String DNI, double sueldoBrutoMensual) {
        this.NOMBRE = nombre;
        this.DNI = DNI;
        this.sueldoBrutoMensual = sueldoBrutoMensual;
    }

    public void calcularSueldoNeto(){
        sueldoBrutoMensual-
    }

    //TODO: usar switch para decidir
    //  - usar ENUM?
    public void porcentajeIRPF(){

    }

    //probablemente sobra
    public void showInfoEmpleado(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("""
                Nombre: - %s
                DNI: ---- %s
                Edad: ----------------- %d
                Telefono: ------------- %s
                Direccion: ------------ %s
                
                Sueldo Bruto Mensual: - %.2f
                """,NOMBRE,DNI,edad,telefono,direccion,sueldoBrutoMensual);
    }
}
