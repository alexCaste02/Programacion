package e_07;

public class Terreno extends Propiedad{

    private int precioAlquiler;
    private ColorTerreno color;

    public Terreno(String nombre, int precio, int hipoteca, int precioAlquiler, ColorTerreno color) {
        super(nombre, precio, hipoteca);
        this.precioAlquiler = precioAlquiler;
        this.color = color;
    }

    @Override
    public int getAlquiler(int modificacion) {
        return (modificacion>4)?
                precioAlquiler*10:
                precioAlquiler+(precioAlquiler*modificacion);

    }

//    public int getPrecioAlquiler() {
//        return precioAlquiler;
//    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public ColorTerreno getColor() {
        return color;
    }

    public void setColor(ColorTerreno color) {
        this.color = color;
    }

}
