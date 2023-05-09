package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Espacio {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Astro astro1 = new Astro("planetita",false,50,50);
                Astro fijo = new Astro("FIJO",true,150,100);

                ArrayList<Astro> astros = new ArrayList<>();
                astros.add(astro1);
                astros.add(fijo);
                while(true){
                    try {
                        Thread.sleep(1000);
                        for (Astro astro : astros) {
                            Motor.calcularFisicas(astro,astros);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }


            }
        });
    }
}
