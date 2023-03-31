package AlejandroCastellanosExamenT11;

public class Mago extends Personaje{

    /**
     * Constructor que crea un mago a partir de un nombre y una fuerza
     *
     * @param nombre - Nombre del mago
     * @param fuerza - Fuerza del mago
     */
    public Mago(String nombre, int fuerza) {
        super(nombre);

        if(comprobarFuerza(fuerza))
            this.fuerza=fuerza;
        else
            this.fuerza=FUERZA_PORDEFECTO;
    }

    /**
     * Metodo que "retira" magos segun su estado de sus atributos
     *
     * @return - Devuelve 'true' si el mago esta herido (y por lo tanto, no muerto)
     * @throws Exception - Lanza exceptiones con mensaje diferente
     * en caso de que el mago este muerto o no herido
     */
    @Override
    public boolean retirarse() throws Exception {
        if(isHerido())
            return true;
        else if (isMuerto()) {
            throw new Exception("El mago esta muerto");
        }
        throw new Exception("El mago no esta herido");
    }
}
