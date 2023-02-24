package maraton.e_01;

public class MainFigura {
    public static void main(String[] args) {

        Triangulo tri = new Triangulo();

        tri.alto = 5;
        tri.ancho = 2;
        tri.estilo = "Isosceles";

        tri.verEstilo();
        tri.verDim();
        System.out.println("Area: "+tri.area());

    }
}
