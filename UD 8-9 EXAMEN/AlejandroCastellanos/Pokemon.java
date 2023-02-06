package AlejandroCastellanos;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Pokemon {


    //PODRIA SER ARRAY? MIRAR LUEGO
    static final int TIPO_PLANTA = 1;
    static final int TIPO_VENENO = 2;
    static final int TIPO_FUEGO = 3;
    static final int TIPO_AGUA = 4;
    private static int idTracker = 1;

    private final int identificador = idTracker;
    private final String nombre;
    private final int tipo;

    private int salud;
    private int ataque;
    private int defensa;
    private int velocidad;
    private boolean defendiendo = false;

    /**
     * CONSTRUCTOR DE POKEMON
     *
     * @param nombre    - nombre del pokemon
     * @param salud     - salud totat/inicial
     * @param ataque    - estadistica de ataque
     * @param defensa   - estadistica de defensa
     * @param velocidad - estadistica de velocidad
     * @param tipo      - tipo del pokemon
     */
    public Pokemon(String nombre, int salud, int ataque, int defensa, int velocidad, int tipo) {

        this.nombre = nombre;
        setSalud(salud);
        setAtaque(ataque);
        setDefensa(defensa);
        setVelocidad(velocidad);
        this.tipo = tipo;
        idTracker++;

    }

    /* GETTERS Y SETTERS */
    public void setSalud(int salud) {
        if (salud > 0) {
            this.salud = salud;
        } else {
            this.salud = 1;
        }
    }

    public void setAtaque(int ataque) {
        if (salud > 0) { //FIXME: ataque en vez de salud
            this.ataque = ataque;
        } else {
            this.ataque = 1;
        }
    }

    public void setDefensa(int defensa) {
        if (salud > 0) { //FIXME: defensa en vez de salud
            this.defensa = defensa;
        } else {
            this.defensa = 1;
        }
    }

    public void setVelocidad(int velocidad) {
        if (salud > 0) { //FIXME: velocidad en vez de salud
            this.velocidad = velocidad;
        } else {
            this.velocidad = 1;
        }
    }

    public void setDefender(boolean defendiendo) {
        this.defendiendo = defendiendo;
    }

    /**
     * Getter del tipo, pero que devuelve el nombre del tipo en lugar de el numero
     *
     * @return - tipo (en String)
     */
    public String getTipoName() {
        switch (tipo) {
            case 1 -> {
                return "PLANTA";
            }
            case 2 -> {
                return "VENENO";
            }
            case 3 -> {
                return "FUEGO";
            }
            case 4 -> {
                return "AGUA";
            }
            default -> {
                return "DESCONOCIDO";
            }
        }
    }

    public int getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getDefensa() {
        return defensa;
    }

    public boolean isDefendiendo() {
        return defendiendo;
    }

    /* OTROS METODOS */
    @Override
    public String toString() {
        return String.format("'%s' [id:%d, ps:%d, pa:%d, pd:%d, pv:%d] tipo:%s %s", nombre, identificador, salud, ataque, defensa, velocidad, getTipoName(), isDefendiendo() ? "se esta defendiendo" : "no se esta defendiendo");
    }

    /**
     * Metodo que calcula el daño del ataque de un pokemon a otro
     *
     * @param poke - pokemon que recibe el ataque
     * @return - daño causado
     */
    public int atacar(Pokemon poke) {
        this.defendiendo = false;

        int damage = (ataque * ThreadLocalRandom.current().nextInt(0, 3))
                - (poke.getDefensa() * (poke.isDefendiendo() ? 2 : 1));

        return Math.max(damage, 0); //FIXME: No le estoy quitando vida
                                    // - setSalud(salud-Math.max(damage, 0))

    }
}
