package ejs_2_6;

import java.util.Scanner;

public class Trabajador {

    private static int numTrabajadores;
    private static double importeHoraExtra;


    private int horasExtra;
    private String nombre, DNI;
    private double sueldoBase,tipoIRPF;



    /* CONSTRUCTORES */
    public Trabajador(){
        numTrabajadores++;
    }

    public Trabajador(String nombre, String dni,  double sueldoBase, int horasExtra, double tipoIRPF) {
        this.DNI = dni;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.horasExtra = horasExtra;
        this.tipoIRPF = tipoIRPF;
        numTrabajadores++;
    }

    /* GETTERS Y SETTERS */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public double getSueldoBase() {
        return sueldoBase;
    }
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    public double getHorasExtra() {
        return horasExtra;
    }
    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
    public double getTipoIRPF() {
        return tipoIRPF;
    }
    public static int getNumTrabajadores() {
        return numTrabajadores;
    }
    public static void setNumTrabajadores(int numTrabajadores) {
        Trabajador.numTrabajadores = numTrabajadores;
    }

    /* OTROS METODOS */
    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public static double getImporteHoraExtra() {
        return importeHoraExtra;
    }

    public static void setImporteHoraExtra(double importeHoraExtra) {
        Trabajador.importeHoraExtra = importeHoraExtra;
    }

    public double calcularImporteHorasExtras(){
        return horasExtra *importeHoraExtra;
    }

    public double calcularSueldoBruto(){
        return sueldoBase+calcularImporteHorasExtras();
    }

    public double calcularRetencionIRPF(){
        return calcularSueldoBruto()*tipoIRPF/100;
    }

    public double calcularSueldo(){
        return calcularSueldoBruto()-calcularRetencionIRPF();
    }

    @Override
    public String toString() {
        return DNI+" "+nombre+
                "\nSueldo Base: "+sueldoBase+
                "\nHoras Extra: "+ horasExtra +
                "\nTipo IRPF: "+tipoIRPF+
                "\nSueldo Bruto: "+calcularSueldoBruto()+
                "\nRetencion por IRPF: "+calcularRetencionIRPF()+
                "\nSueldo Neto: "+calcularSueldo();
    }

    public void leerTrabajador(){

        Scanner input = new Scanner(System.in);


        System.out.print("Nombre: ");
        nombre=input.nextLine();

        // TODO: 13/01/2023 -Validar DNI (copiar de antes)
        System.out.print("DNI: ");
        DNI=input.nextLine();

        System.out.print("Sueldo Base: ");
        sueldoBase=input.nextDouble();

        // TODO: 13/01/2023 -Quitar negativos
        System.out.print("Horas Extra: ");
        horasExtra=input.nextInt();

        // TODO: 13/01/2023 -Poner limites
        System.out.print("Sueldo Base: ");
        tipoIRPF=input.nextDouble();

    }

}
