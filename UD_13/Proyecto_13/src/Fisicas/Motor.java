package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Motor {
    private static int FPS = 60;

    private static final double G = 1;
    private static final int F = 500; //frame de sim
    //NO TOQUES
    public static final int MILS_X_FRAME = 1000/FPS; //milis por frame (3 ms = 30 fps aprox)

    public static void calcularFisicas(AstroImagen a, ArrayList<AstroImagen> otros) {
        if (!a.isFijo()) {
            System.out.println(a);
            Point sumatorioFuerzas = new Point();

            for (AstroImagen otro : otros) {
                if (a.equals(otro)) continue;
                calcularFuerza(a, otro, sumatorioFuerzas);
//                calcularChoque(a, otro);

            }

            sumatorioFuerzas = new Point(sumatorioFuerzas.x/F-1, sumatorioFuerzas.y/F-1);
            System.out.println("sumatorioFuerzas: " + sumatorioFuerzas);
            a.setVelocidad(sumatorioFuerzas);
            Point nuevaPos = new Point(a.getX() + a.getVelocidad().x, a.getY() + a.getVelocidad().y);
            a.setPosicion(nuevaPos);
        }
    }

    private static void calcularChoque(AstroImagen a, AstroImagen otro) {
        if(a.getBounds().intersects(otro.getBounds()))
            a.setVelocidad(new Point(-a.getVelocidad().x,-a.getVelocidad().y));
    }

    private static void calcularFuerza(AstroImagen a, AstroImagen otro, Point sumatorioFuerzas){
        Point nucleoAstroImagen = new Point(
                a.getX() + (a.getWidth() / 2),
                a.getY() + (a.getHeight() / 2)
        );

        Point nucleObj = new Point(
                otro.getX()+(otro.getWidth()/2),
                otro.getY()+(otro.getHeight()/2)
        );

        double distX = nucleoAstroImagen.x - nucleObj.x;
        double distY = nucleoAstroImagen.y - nucleObj.y;

        double dist = Math.sqrt(distX * distX + distY * distY);
        double fuerza = G * a.getMasa() * otro.getMasa() / (1); // (dist^2) es demasiado

        double ang = Math.atan2(distY, distX);
        double fuerzaX = fuerza * Math.cos(ang);
        double fuerzaY = fuerza * Math.sin(ang);


        sumatorioFuerzas.translate(-(int) fuerzaX, -(int) fuerzaY);



    }

}