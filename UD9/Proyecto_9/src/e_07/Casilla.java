package e_07;

import java.util.ArrayList;

public abstract class Casilla {
    private static ArrayList<Casilla> casillas = new ArrayList<>();

    private final String nombre;
    private final int codigo;

    public Casilla(String nombre) {
        this.nombre = nombre;
        casillas.add(this);
        this.codigo = casillas.size();
    }

    public abstract int getPropietario();




    

}
