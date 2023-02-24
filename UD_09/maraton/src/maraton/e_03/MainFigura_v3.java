package maraton.e_03;

public class MainFigura_v3 {
    public static void main(String[] args) {

        Triangulo_v3 tri1 = new Triangulo_v3("Isosceles",5,2);
        Triangulo_v3 tri2 = new Triangulo_v3("Escaleno",3.3,7);

        tri1.verEstilo();
        tri1.verDim();
        System.out.println("Area: "+tri1.area());

        tri2.verEstilo();
        tri2.verDim();
        System.out.println("Area: "+tri2.area());

    }
}
