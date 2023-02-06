package AlejandroCastellanos;

public class Main {

    public static void main(String[] args) {

        Pokemon bulbasaur = new Pokemon("alcachofa", 20, 14, 30, 5, Pokemon.TIPO_PLANTA);
        Pokemon charmander = new Pokemon("cerilla", 40, 20, 10, 30, Pokemon.TIPO_FUEGO);
        Pokemon meowth = new Pokemon("cara pincho", 30, 15, 15, 40, Pokemon.TIPO_FUEGO);
        Pokemon caterpie = new Pokemon("bicho", 30, 45, 5, 4, Pokemon.TIPO_VENENO);

        JugadorPokemon pepito = new JugadorPokemon("pepito");

        //Bucle para que se encuentre al menos un pokemon
        do {
            if (pepito.capturarPokemon(charmander))
                System.out.println("Pokemon capturado");
            else System.out.println("El pokemon se escapó");

            if (pepito.capturarPokemon(bulbasaur))
                System.out.println("Pokemon capturado");
            else System.out.println("El pokemon se escapó");

            if (pepito.capturarPokemon(meowth))
                System.out.println("Pokemon capturado");
            else System.out.println("El pokemon se escapó");
        } while (pepito.mochila.size() == 0); //FIXME: getMochila, porque deberia ser privado

        pepito.mostrarMochila();
        caterpie.setDefender(true);
        ataque(pepito.elegirPokemon("cerilla"), caterpie);

        System.out.println("Pokemon de fuego: " + pepito.listaByTipo(Pokemon.TIPO_FUEGO));
        pepito.eliminarPokemonBySalud(30);
        pepito.mostrarMochila();

    }

    public static void ataque(Pokemon p1, Pokemon p2) {
        System.out.println(p1.getNombre() + " ataca a " + p2.getNombre() + " y le quita " + p1.atacar(p2) + " de salud");
    }
}
