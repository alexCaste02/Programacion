package ArrayList.E_4;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private int identificador;
    private Date fechaFactura;
    private int numCliente;
    private static final int IVA = 21;
    private ArrayList<LineaFactura> listaLF = new ArrayList<>();
    private double importeTotal;

}
