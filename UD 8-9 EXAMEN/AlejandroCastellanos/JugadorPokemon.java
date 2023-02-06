package AlejandroCastellanos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class JugadorPokemon {

    String nombre; //FIXME: No es private
    ArrayList<Pokemon> mochila = new ArrayList<>(); //FIXME: No es private

    /* CONSTRUCTOR */
    public JugadorPokemon(String nombre) {
        this.nombre = nombre;
    }

    /* OTROS METODOS */

    /**
     * Calculo para ver si se captura un pokemon
     *
     * @param poke - Pokemon a capturar
     * @return - devuelve si se ha capturado o no
     */
    public boolean capturarPokemon(Pokemon poke) {
        int numJugador = ThreadLocalRandom.current().nextInt(0, 100);
        int numPokemon = ThreadLocalRandom.current().nextInt(0, 51) + poke.getVelocidad();//TODO: puede que este mal interpretado

        if (numJugador > numPokemon) {
            mochila.add(poke);
            return true;
        }
        return false;
    }

    /**
     * Metodo que busca un pokemon de la mochila con un nombre
     *
     * @param nombre - nombre del pokemon a elegir
     * @return - pokemon elegido / default: primer pokemon
     */
    public Pokemon elegirPokemon(String nombre) {
        for (Pokemon pokemon : mochila) {
            if (pokemon.getNombre().equals(nombre))
                return pokemon;
        }

        //Devolvemos null si no existe pokemon a elegir, para evitar exceptions
        if (mochila.size() == 0)
            return null;

        return mochila.get(0);
    }

    /**
     * Eliminan pokemons de la mochila que tengan la salud por debajo de un numero
     *
     * @param salud - salud minima para no ser eliminado
     * @return - numero de pokemons eliminados
     */
    public int eliminarPokemonBySalud(int salud) {
        int nElim = 0;
        for (int i = 0; i < mochila.size(); i++) {
            if (mochila.get(i).getSalud() < salud) {
                mochila.remove(mochila.get(i));
                i--;
                nElim++;
            }
        }
        // EXISTE MEJOR FORMA? FIXME: iter.remove() es como se borran elementos en Iterator
//        Iterator<Pokemon> iter = mochila.iterator();
//        while (iter.hasNext()){
//            if(iter.getSalud())
//            mochila.remove(iter.next());
//            nElim++;
//        }
        return nElim;
    }

    /**
     * Metodo que devuelve todos los pokemons de la mochila de un tipo especifico
     *
     * @param tipo - tipo de pokemon que queremos devolver
     * @return - Lista de Pokemons (Objeto Pokemon) del tipo correspondiente
     */
    public ArrayList<Pokemon> listaByTipo(int tipo) {
        ArrayList<Pokemon> pokemonsDeTipo = new ArrayList<>();
        for (Pokemon pokemon : mochila) {
            if (pokemon.getTipo() == tipo)
                pokemonsDeTipo.add(pokemon);
        }
        return pokemonsDeTipo;
    }

    /**
     * Enseña por pantalla la lista de Pokemons "mochila" (Pokemons capturados)
     */
    public void mostrarMochila() {
        System.out.println("Nombre del jugador: " + nombre);
        for (Pokemon pokemon : mochila) {
            System.out.println(pokemon);
        }
    }


}
