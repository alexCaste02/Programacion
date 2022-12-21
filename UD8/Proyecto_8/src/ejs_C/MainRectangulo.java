package ejs_C;

/*
En el main de la clase principal instancia 2 objetos Rectangulo en (0,0)(5,5) y (7,9)(2,3).
Muestra por pantalla sus coordenadas, perímetros (suma de lados) y áreas (ancho x alto).
Modifica todas las coordenadas como consideres y vuelve a imprimir coordenadas,
perímetros y áreas.
*/

public class MainRectangulo {

    public static void main(String[] args) {

        Rectangulo rec1 = new Rectangulo(0,0,5,5);
        Rectangulo rec2 = new Rectangulo(7,9,2,3);



        System.out.println("x: "+rec1.getX1()+","+rec1.getY1()+"/"+rec1.getX2()+","+rec1.getY2());
        System.out.println("perimetro x: "+ ((rec1.getX2() - rec1.getX1())*2+(rec1.getY2() - rec1.getY1())*2));
        System.out.println("area x: "+(rec1.getX2() - rec1.getX1())*(rec1.getY2()- rec1.getY1()));

        System.out.println("x: "+rec2.getX1()+","+rec2.getY1()+"/"+rec2.getX2()+","+rec2.getY2());
        System.out.println("perimetro x: "+ ((rec2.getX2() - rec2.getX1())*2+(rec2.getY2() - rec2.getY1())*2));
        System.out.println("area x: "+(rec2.getX2() - rec2.getX1())*(rec2.getY2()- rec2.getY1()));

        System.out.println();

        rec1.setX1(rec1.getX1()+1);
        rec1.setY1(rec1.getY1()+1);
        rec1.setX2(rec1.getX2()-1);
        rec1.setY2(rec1.getY2()-1);

        rec2.setX1(rec1.getX1()+1);
        rec2.setY1(rec1.getY1()+1);
        rec2.setX2(rec1.getX2()-1);
        rec2.setY2(rec1.getY2()-1);


        System.out.println("x: "+rec1.getX1()+","+rec1.getY1()+"/"+rec1.getX2()+","+rec1.getY2());
        System.out.println("perimetro x: "+ ((rec1.getX2() - rec1.getX1())*2+(rec1.getY2() - rec1.getY1())*2));
        System.out.println("area x: "+(rec1.getX2() - rec1.getX1())*(rec1.getY2()- rec1.getY1()));

        System.out.println("x: "+rec2.getX1()+","+rec2.getY1()+"/"+rec2.getX2()+","+rec2.getY2());
        System.out.println("perimetro x: "+ ((rec2.getX2() - rec2.getX1())*2+(rec2.getY2() - rec2.getY1())*2));
        System.out.println("area x: "+(rec2.getX2() - rec2.getX1())*(rec2.getY2()- rec2.getY1()));

        
    }
}