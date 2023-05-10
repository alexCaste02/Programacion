package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Motor {

    private static final double G = 0.5;
    private static final int F = 1000; //frame de sim
    public static final int T = 3; //milis por frame (30 fps aprox)

    public static void calcularFisicas(AstroImagen a, ArrayList<AstroImagen> otros) {
        if (!a.isFijo()) {
            System.out.println(a);
            Point nucleoAstroImagen = new Point(
                    a.getX()+(a.getWidth()/2),
                    a.getY()+(a.getHeight()/2)
            );

            Point sumatorioFuerzas = new Point();
            for (AstroImagen otro : otros) {
                if (a.equals(otro)) continue;
                Point nucleObj = new Point(
                        otro.getX()+(otro.getWidth()/2),
                        otro.getY()+(otro.getHeight()/2)
                );

                double distX = nucleoAstroImagen.x - nucleObj.x;
                double distY = nucleoAstroImagen.y - nucleObj.y;

                double dist = Math.sqrt(distX * distX + distY * distY);
                double fuerza = G * a.getMasa() * otro.getMasa() / (1);

                double ang = Math.atan2(distY, distX);
                double fuerzaX = fuerza * Math.cos(ang);
                double fuerzaY = fuerza * Math.sin(ang);


                sumatorioFuerzas.translate(-(int) fuerzaX, -(int) fuerzaY);

            }
            sumatorioFuerzas = new Point(sumatorioFuerzas.x/F, sumatorioFuerzas.y/F);
            System.out.println("sumatorioFuerzas: " + sumatorioFuerzas);
            a.setVelocidad(sumatorioFuerzas);
        }
        Point nuevaPos = new Point(a.getX() + a.getVelocidad().x, a.getY() + a.getVelocidad().y);
        a.setPosicion(nuevaPos);
    }
}