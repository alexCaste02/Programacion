package maraton.e_02;

public class MainFigura_v2 {
    public static void main(String[] args) {

        Triangulo_v2 tri = new Triangulo_v2();

        tri.setAlto(5);
        tri.setAncho(2);
        tri.estilo = "Isosceles";

        tri.verEstilo();
        tri.verDim();
        System.out.println("Area: "+tri.area());

    }
}
