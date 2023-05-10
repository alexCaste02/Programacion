package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Espacio {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ArrayList<AstroImagen> astros = new ArrayList<>();


                astros.add(new AstroImagen("FIJO", 1,true,700,700,200,200));
                astros.add(new AstroImagen("planetita1",100,false,800,400,200,200));


//                astros.add(new AstroImagen("planetita2",2,false,500,500,50,50));
                while(true){
                    try {
                        Thread.sleep(Motor.T);
                        for (AstroImagen astro : astros) {
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
