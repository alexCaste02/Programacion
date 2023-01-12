package ejs_2_6;

public class Trabajador {

    private double importeHoraExtra;
    private int numTrabajadores;
    private String dni;
    private String nombre;
    private double sueldoBase;
    private double horasExtrasMes;
    private double tipoIRPF;

    public Trabajador(double importeHoraExtra, int numTrabajadores, String dni, String nombre, double sueldoBase, double horasExtrasMes, double tipoIRPF) {
        this.importeHoraExtra = importeHoraExtra;
        this.numTrabajadores = numTrabajadores;
        this.dni = dni;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.horasExtrasMes = horasExtrasMes;
        this.tipoIRPF = tipoIRPF;
    }

    public calcularImporteHorasExtras(){

    }
}
