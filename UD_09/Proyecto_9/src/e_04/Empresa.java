package e_04;

import java.awt.*;
import java.util.ArrayList;

public class Empresa {
    private final String nombre;
    private final String CIF;

    private String telefono;
    private String direccion;
    private ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombre, String CIF, String telefono, String direccion) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaEmpleados = new ArrayList<>();
    }

    //TODO: revisar si ya existe
    public void addEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }

    public void removeEmpleado(String DNI){
        listaEmpleados.remove(buscarEmpleado(DNI));
    }

    private Empleado buscarEmpleado(String DNI){
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getDNI().equals(DNI))
                return empleado;
        }
        System.out.println("No se ha encontrado empleado con ese DNI");
        return null;
    }

    public void showAllEmpleados(){
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }

    public void showSalarioAllEmpleados(){
        for (Empleado empleado : listaEmpleados) {
            System.out.printf("""              
                DNI: ------------------ %s
                Sueldo Bruto Mensual: - %.2f
                Sueldo Neto Mensual: -- %.2f
                """, empleado.getDNI(), empleado.getSueldoBrutoMensual(), empleado.getSueldoNetoMensual());
        }
    }

    public double calcularSumaAllSueldosBrutos(){
        double suma = 0;
        for (Empleado empleado : listaEmpleados) {
            suma+=empleado.getSueldoBrutoMensual();
        }
        return suma;
    }

    public double calcularSumaAllSueldosNetos(){
        double suma = 0;
        for (Empleado empleado : listaEmpleados) {
            suma+=empleado.getSueldoNetoMensual();
        }
        return suma;
    }



}
