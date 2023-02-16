package e_07;

import java.util.ArrayList;

public class Casilla {
    private static ArrayList<Casilla> casillas = new ArrayList<>();

    private final String nombre;
    private final int codigo;

    public Casilla(String nombre, int codigo) {
        this.nombre = nombre;
        casillas.add(this);
        this.codigo = casillas.size();
    }




    

}
