package E_04;

public class LineaFactura {
    private String descripcion;
    private double precioUD;
    private int cantidadUD;
    private int porcentajeDescuento;
    private double importeTotalLinea = precioUD-(precioUD*porcentajeDescuento/100);

    public LineaFactura(String descripcion, double precioUD, int cantidadUD) {
        this.descripcion = descripcion;
        this.precioUD = precioUD;
        this.cantidadUD = cantidadUD;
        comprobarMas10Uds();

    }

    @Override
    public String toString() {
        return "LineaFactura{" +
                "descripcion='" + descripcion + '\'' +
                ", precioUD=" + precioUD +
                ", cantidadUD=" + cantidadUD +
                ", porcentajeDescuento=" + porcentajeDescuento +
                ", importeTotalLinea=" + importeTotalLinea +
                '}';
    }

    public void calculoImporteTotal(){
        importeTotalLinea = precioUD-(precioUD*porcentajeDescuento/100);
    }

    public void comprobarMas10Uds(){
        if (cantidadUD>10)
            porcentajeDescuento=5;
    }
}
