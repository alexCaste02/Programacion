package e_02;


public abstract class Mascotas {

    private String nombre;
    private int edad;
    private Estado estado;
    private String fechaNacimiento;

    public Mascotas(String nombre, int edad, Estado estado, String fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }



    public void cumple(){
        edad++;
    }

    public void morir(){
        estado = Estado.MUERTO;
    }

    public abstract void muestra();

    public abstract void habla();

    @Override
    public String toString() {
        return "Mascotas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estado=" + estado +
                ", fechaNacimiento='" + fechaNacimiento + '\'';
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
