package AlejandroCastellanosExamenT11;

public class Troll extends Personaje{

    //Atributo que cuenta el numero de trolls creados
    private static int nTrollsCreados = 1;

    /**
     * Constructor que crea un troll con un nombre predefinido segun la cantidad de trolls
     * creados y con una fuerza aleatoria
     * (no se le pasan parametros)
     */
    public Troll() {
        super("Troll_"+nTrollsCreados);
        setFuerzaAleatoria();
        nTrollsCreados++;
    }

    /**
     * Metodo que "retira" trolls segun su estado de sus atributos
     * En este caso, nunca los retira
     *
     * @return - No devuelve nada
     * @throws Exception - Siempre lanza una exception con el mensaje correspondiente
     */
    @Override
    public boolean retirarse() throws Exception {
        throw new Exception("Un troll no puede retirarse");
    }


}
