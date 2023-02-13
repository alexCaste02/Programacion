package e_01;

// porque me ha dado por usar Estrella como un objeto astros
// esto es subjetiva y objetivamente peor, pero xd

import java.util.ArrayList;

public class Estrella extends Astros {

    protected static final Astros SOL = new Estrella("Sol", 1.0,Math.pow(1.9891*10,30), 1391016.0, 0.0,0.0,null, new ArrayList<>());

    public Estrella(String nombre, Double masaKG, Double diametroKM, Double periodoRotacionDias, Double periodoTranslacionDias, Double distanciaMediaOrbitaKM, Astros cuerpoOrbitado, ArrayList<Astros> esOrbitadoPor) {
        super(nombre, masaKG, diametroKM, periodoRotacionDias, periodoTranslacionDias, distanciaMediaOrbitaKM, cuerpoOrbitado, esOrbitadoPor);
    }

}
