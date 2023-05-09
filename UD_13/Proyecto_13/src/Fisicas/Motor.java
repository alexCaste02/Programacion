package Fisicas;

import java.awt.*;
import java.util.ArrayList;

public class Motor {

    private static final int G = 5;
    public static void calcularFisicas(Astro a, ArrayList<Astro> otros){

        if(!a.isFijo()){
            Point cambioVel=new Point();

            for (Astro otro : otros) {
                Point dist = new Point(a.getX()-otro.getX(),a.getY()-otro.getY());
                if(dist.x==0){
                    dist.x=1;
                }
                if(dist.y==0){
                    dist.y=1;
                }

                System.out.println("Dist:"+dist);

                int varX = G*(a.getMasa()*otro.getMasa())/(dist.x*dist.x);
                int varY = G*(a.getMasa()*otro.getMasa())/(dist.y*dist.y);

                if(!otro.equals(a)){
                    cambioVel.translate(varX,varY);

                }
            }

            a.getVelocidad().translate(cambioVel.x,cambioVel.y);

            Point nuevaPos = new Point(a.getPosicion().x+a.getVelocidad().x,a.getPosicion().y+a.getVelocidad().y);
            a.setPosicion(nuevaPos);
            System.out.println(a);
        }
    }
}
