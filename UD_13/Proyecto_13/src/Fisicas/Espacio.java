package Fisicas;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Espacio {

    private static ArrayList<AstroImagen> astros = new ArrayList<>();

    public static void main(String[] args) {
        astros.add(new AstroImagen("FIJO", 1, true, 700, 700, 200, 200));
        astros.add(new AstroImagen("planetita1", 100, false, 800, 400, 200, 200));

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            for (AstroImagen astro : astros) {
                Motor.calcularFisicas(astro, astros);
            }
        }, 0, Motor.T, TimeUnit.MILLISECONDS);
    }
}