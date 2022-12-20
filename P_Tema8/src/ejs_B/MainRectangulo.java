package ejs_B;

/*
En el main de la clase principal instancia 2 objetos Rectangulo en (0,0)(5,5) y (7,9)(2,3).
Muestra por pantalla sus coordenadas, perímetros (suma de lados) y áreas (ancho x alto).
Modifica todas las coordenadas como consideres y vuelve a imprimir coordenadas,
perímetros y áreas.
*/

public class MainRectangulo {

    public static void main(String[] args) {
        Rectangulo rec1 = new Rectangulo();
        Rectangulo rec2 = new Rectangulo();

        rec1.x1=0;
        rec1.y1=0;
        rec1.x2=5;
        rec1.y2=5;

        rec2.x1=7;
        rec2.y1=9;
        rec2.x2=2;
        rec2.y2=3;


        System.out.println("x: "+rec1.x1+","+rec1.y1+"/"+rec1.x2+","+rec1.y2);
        System.out.println("perimetro x: "+ (Math.abs(rec1.x1 - rec1.x2)*2+Math.abs(rec1.y1- rec1.y2)*2));
        System.out.println("area x: "+Math.abs(rec1.x1- rec1.x2)*Math.abs(rec1.y1- rec1.y2));

        System.out.println("y: "+rec2.x1+","+rec2.x2+"/"+rec2.y1+","+rec2.y2);
        System.out.println("perimetro y: "+ (Math.abs(rec2.x1 - rec2.x2)*2+Math.abs(rec2.y1- rec2.y2)*2));
        System.out.println("area y: "+Math.abs(rec2.x1- rec2.x2)*Math.abs(rec2.y1- rec2.y2));

        System.out.println();


        rec1.x1+=1;
        rec1.y1+=1;
        rec1.x2-=1;
        rec1.y2-=1;

        rec2.x1+=1;
        rec2.y1+=1;
        rec2.x2-=1;
        rec2.y2-=1;


        System.out.println("x: "+rec1.x1+","+rec1.y1+"/"+rec1.x2+","+rec1.y2);
        System.out.println("perimetro x: "+ (Math.abs(rec1.x1 - rec1.x2)*2+Math.abs(rec1.y1- rec1.y2)*2));
        System.out.println("area x: "+Math.abs(rec1.x1- rec1.x2)*Math.abs(rec1.y1- rec1.y2));

        System.out.println("y: "+rec2.x1+","+rec2.x2+"/"+rec2.y1+","+rec2.y2);
        System.out.println("perimetro y: "+ (Math.abs(rec2.x1 - rec2.x2)*2+Math.abs(rec2.y1- rec2.y2)*2));
        System.out.println("area y: "+Math.abs(rec2.x1- rec2.x2)*Math.abs(rec2.y1- rec2.y2));

        
    }
}