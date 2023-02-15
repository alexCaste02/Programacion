package e_04;

import java.util.Objects;

public class Empleado {
    private final String NOMBRE;
    private final String DNI;

    private double sueldoBrutoMensual;
    private int edad;
    private String telefono;
    private String direccion;

    //FIXME: no usar varible para no tener que recalcular
    private double sueldoNetoMensual;
    private int porcentajeIRPF;


    public Empleado(String nombre, String DNI, double sueldoBrutoMensual) {
        this.NOMBRE = nombre;
        this.DNI = DNI;
        this.sueldoBrutoMensual = sueldoBrutoMensual;
        porcentajeIRPF = porcentajeIRPF();
        sueldoNetoMensual = calcularSueldoNeto();
    }


    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getDNI() {
        return DNI;
    }

    public double getSueldoBrutoMensual() {
        return sueldoBrutoMensual;
    }

    public void setSueldoBrutoMensual(double sueldoBrutoMensual) {
        this.sueldoBrutoMensual = sueldoBrutoMensual;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldoNetoMensual() {
        return sueldoNetoMensual;
    }

    public void setSueldoNetoMensual(double sueldoNetoMensual) {
        this.sueldoNetoMensual = sueldoNetoMensual;
    }

    public int getPorcentajeIRPF() {
        return porcentajeIRPF;
    }

    public void setPorcentajeIRPF(int porcentajeIRPF) {
        this.porcentajeIRPF = porcentajeIRPF;
    }

    public double calcularSueldoNeto() {
        return sueldoBrutoMensual - ((double) porcentajeIRPF / 100 * sueldoBrutoMensual);
    }

    public int porcentajeIRPF() {
        if (sueldoBrutoMensual * 12 < 12000)
            return 20;
        else if (sueldoBrutoMensual * 12 >= 12000 && sueldoBrutoMensual * 12 <= 25000)
            return 30;
        else if (sueldoBrutoMensual * 12 > 25000)
            return 40;

        return 0;
    }


    //probablemente sobra
    public void showInfoEmpleado() {
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
                """, NOMBRE, DNI, edad, telefono, direccion, sueldoBrutoMensual);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado empleado)) return false;
        return DNI.equals(empleado.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI);
    }




}
