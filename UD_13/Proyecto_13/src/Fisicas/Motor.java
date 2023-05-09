package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Motor {

    private static final double G = 100000;

    //FIXME: ARREGLAR NEGATIVOS OTRA VEZ
    public static void calcularFisicas(Astro a, ArrayList<Astro> otros) {
        if (!a.isFijo()) {
            System.out.println(a);

            Point sumatorioFuerzas = new Point();
            for (Astro otro : otros) {
                if(a.equals(otro)) continue;

                double distX = a.getX()-otro.getX();
                double distY = a.getY()-otro.getY();
                double ang = Math.tan(distY/distX);
                double dist = Math.sqrt(Math.pow(distX,2)+Math.pow(distY,2));
                double fuerza = G*((a.getMasa()*otro.getMasa()/(dist*dist)));

                double fuerzaX = fuerza*Math.cos(ang);
                double fuerzaY = fuerza*Math.sin(ang);

                sumatorioFuerzas.translate((int) fuerzaX, (int) fuerzaY);

            }

            a.getVelocidad().translate(sumatorioFuerzas.x, sumatorioFuerzas.y);


        }
        Point nuevaPos = new Point(a.getX()+a.getVelocidad().x,a.getY()+a.getVelocidad().y);
        a.setPosicion(nuevaPos);

    }
}