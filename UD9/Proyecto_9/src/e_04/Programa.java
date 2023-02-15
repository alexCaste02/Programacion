package e_04;

public class Programa {
    public static void main(String[] args) {

        Empresa mpresa = new Empresa("Empresa 1","1234","911","Calle Alpha");

        Empleado empleado1 = new Empleado("Alex","DNI1",600);
        Empleado empleado2 = new Empleado("Vane","DNI2",1250.55);

        mpresa.showAllEmpleados();

        mpresa.addEmpleado(empleado1);
        mpresa.addEmpleado(empleado2);
        mpresa.showAllEmpleados();

        mpresa.removeEmpleado("DNI1");
        mpresa.showAllEmpleados();

        mpresa.addEmpleado(empleado1);
        mpresa.showAllEmpleados();

        mpresa.showSalarioAllEmpleados();
        System.out.println(mpresa.calcularSumaAllSueldosBrutos());
        System.out.println(mpresa.calcularSumaAllSueldosNetos());

    }
}
