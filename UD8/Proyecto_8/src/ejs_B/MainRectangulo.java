package ejs_B;

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



        System.out.println("x: "+rec1.x1+","+rec1.y1+"/"+rec1.x2+","+rec1.y2);
        System.out.println("perimetro x: "+ ((rec1.x2 - rec1.x1)*2+(rec1.y2 - rec1.y1)*2));
        System.out.println("area x: "+(rec1.x2 - rec1.x1)*(rec1.y2- rec1.y1));

        System.out.println("y: "+rec2.x1+","+rec2.y1+"/"+rec2.x2+","+rec2.y2);
        System.out.println("perimetro y: "+ ((rec2.x2 - rec2.x1)*2+(rec2.y2- rec2.y1)*2));
        System.out.println("area y: "+(rec2.x2 - rec2.x1)*(rec2.y2- rec2.y1));

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
        System.out.println("perimetro x: "+ ((rec1.x2 - rec1.x1)*2+(rec1.y2- rec1.y1)*2));
        System.out.println("area x: "+(rec1.x2 - rec1.x1)*(rec1.y2- rec1.y1));

        System.out.println("y: "+rec2.x1+","+rec2.y1+"/"+rec2.x2+","+rec2.y2);
        System.out.println("perimetro y: "+ ((rec2.x2 - rec2.x1)*2+(rec2.y2- rec2.y1)*2));
        System.out.println("area y: "+(rec2.x2 - rec2.x1)*(rec2.y2- rec2.y1));

        
    }
}