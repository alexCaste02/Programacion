package E_4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Factura {

    static Scanner input = new Scanner(System.in);

    private final int identificador;
    private final LocalDate fechaFactura;
    private String numCliente;
    private static final int IVA = 21;
    private ArrayList<LineaFactura> lineas = new ArrayList<>();
    private double importeTotal;

    public Factura(int identificador, String numCliente) {
        this.identificador = identificador;
        this.fechaFactura = LocalDate.now();
        this.numCliente = numCliente;

    }

    public void addLineaFactura(){

        System.out.println("Introduce la descripcion de la linea");
        String desc = input.nextLine();

        System.out.println("Introduce la descripcion de la linea");
        double precioUD = input.nextDouble();




        lineas.add(new LineaFactura(desc,precioUD,lineas.size()));
    }

//    public void removeLineaFactura(){
//        lineas.remove();
//    }

    @Override
    public String toString() {
        return "Factura{" +
                "identificador=" + identificador +
                ", fechaFactura=" + fechaFactura +
                ", numCliente=" + numCliente +
                ", lineas=" + lineas +
                ", importeTotal=" + importeTotal +
                '}';
    }

    public void mostrarFactura(){

    }
}
