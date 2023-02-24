package maraton.e_04;

public class MainFigura_v4 {
    public static void main(String[] args) {

        Triangulo_v4 tri1 = new Triangulo_v4("Isosceles",5,2);
        Triangulo_v4 tri2 = new Triangulo_v4("Escaleno",3.3,7);

        tri1.verEstilo();
        tri1.verDim();
        System.out.println("Area: "+tri1.area());

        tri2.verEstilo();
        tri2.verDim();
        System.out.println("Area: "+tri2.area());

    }
}
