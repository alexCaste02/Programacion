package Fisicas;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Espacio {

    private static ArrayList<AstroImagen> astros = new ArrayList<>();
    private static int milisPasados = 0;
    private static int i=0;

    public static void main(String[] args) {
        astros.add(new AstroImagen("FIJO", 1000, true, 700, 700, 200, 200));
        astros.add(new AstroImagen("planetita1", 10, false, 800, 400, 200, 200));

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            for (AstroImagen astro : astros) {
                Motor.calcularFisicas(astro, astros);
                milisPasados++;
            }
            int x = ThreadLocalRandom.current().nextInt(1920+1);
            int y = ThreadLocalRandom.current().nextInt(1080+1);


            i++;

            if(i<100)
                astros.add(new AstroImagen("planetita"+milisPasados,10, false, x, y, 200, 200));


        }, 0, Motor.MILS_X_FRAME, TimeUnit.MILLISECONDS);
    }
}