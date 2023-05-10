package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Motor {

    private static final double G = 1;
    private static final int F = 300; //frame de sim
    public static final int T = 10; //milis por frame

    public static void calcularFisicas(Astro a, ArrayList<Astro> otros) {
        if (!a.isFijo()) {
            System.out.println(a);
            Point nucleoAstro = new Point(
                    a.getX()+(a.getWidth()/2),
                    a.getY()+(a.getHeight()/2)
            );

            Point sumatorioFuerzas = new Point();
            for (Astro otro : otros) {
                if (a.equals(otro)) continue;
                Point nucleObj = new Point(
                        otro.getX()+(otro.getWidth()/2),
                        otro.getY()+(otro.getHeight()/2)
                );

                double distX = nucleoAstro.x - nucleObj.x;
                double distY = nucleoAstro.y - nucleObj.y;

                double dist = Math.sqrt(distX * distX + distY * distY);
                double fuerza = G * a.getMasa() * otro.getMasa() / (1); // (dist^2) es demasiado

                double ang = Math.atan2(distY, distX);
                double fuerzaX = fuerza * Math.cos(ang);
                double fuerzaY = fuerza * Math.sin(ang);


                sumatorioFuerzas.translate(-(int) fuerzaX, -(int) fuerzaY);
                System.out.println("sumatorioFuerzas: " + sumatorioFuerzas);
            }
            sumatorioFuerzas= new Point(sumatorioFuerzas.x/ F, sumatorioFuerzas.y/ F);
            a.setVelocidad(sumatorioFuerzas);
        }
        Point nuevaPos = new Point(a.getX() + a.getVelocidad().x, a.getY() + a.getVelocidad().y);
        a.setPosicion(nuevaPos);
    }
}