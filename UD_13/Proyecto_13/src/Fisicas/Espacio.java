package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Espacio {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ArrayList<Astro> astros = new ArrayList<>();

                astros.add(new Astro("FIJO", 1000,true,700,700,200,200));

                astros.add(new Astro("planetita1",100,false,800,400,50,50));
                astros.add(new Astro("planetita1",100,false,800,400,50,50));
                astros.add(new Astro("planetita1",100,false,800,400,50,50));
                astros.add(new Astro("planetita1",100,false,800,400,50,50));



//                astros.add(new Astro("planetita2",1000,false,500,500,50,50));
                while(true){
                    try {
                        Thread.sleep(Motor.T);
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
