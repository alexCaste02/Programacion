package e_AgendaTelefonica;

public record Registro(String nombre, String telefono) {

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Telefono: "+telefono;
    }

}
