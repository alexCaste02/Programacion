package e_01;

// porque me ha dado por usar Estrella como un objeto astros
// esto es subjetiva y objetivamente peor, pero xd

import java.util.ArrayList;

public class Estrella extends Astros {

    //sistema solar

    protected static final Astros SOL = new Estrella(
            "Sol",
            Math.pow(1.9891*10,30),
            1391016.0,
            0.0,
            0.0,
            null,
            new ArrayList<>(),
            true
    );

    public Estrella(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTraslacionDias, Astros cuerpoOrbitado, ArrayList<Astros> orbitadoPor, boolean Orbitable) {
        super(nombre, masaKG, diametroKM, periodoRotacionDias, periodoTraslacionDias, cuerpoOrbitado, orbitadoPor, Orbitable);
    }


}
