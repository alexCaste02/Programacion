package e_07;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casilla> listaCasillas = new ArrayList<>();

    public Tablero() {
        listaCasillas.add(new Terreno("terreno verde 1",300,200,100,ColorTerreno.VERDE));
        listaCasillas.add(new Terreno("terreno verde 2",600,400,200,ColorTerreno.VERDE));
        listaCasillas.add(new Estaciones("Norte"));
        listaCasillas.add(new Terreno("terreno rojo",100,500,250,ColorTerreno.ROJO));
        listaCasillas.add(new Estaciones("Sur"));
    }

    public void mostrarTablero(){
        for (Casilla casilla : listaCasillas) {

        }
    }

    public void listaTerrenos(int jugador){
        ArrayList<Casilla> listaCasillasJugador;
        for (Casilla casilla : listaCasillas) {
            if (casilla.getPropietario()==jugador);

        }
    }
}
