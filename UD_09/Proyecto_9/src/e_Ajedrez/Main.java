package e_Ajedrez;

public class Main {
    public static void main(String[] args) {

        Pieza peon1 = new Peon(ColorPieza.BLANCO,1,1);
        System.out.println(peon1);

        Pieza peon2 = new Peon(ColorPieza.BLANCO,0,0);
        System.out.println(peon2);

        peon2.mover(1,1);
        System.out.println(peon2);

        peon2.mover(0,1);
        System.out.println(peon2);

        peon2.mover(0,2);
        System.out.println(peon2);

        peon2.mover(0,2);
        System.out.println(peon2);

        Pieza torre1 = new Torre(ColorPieza.BLANCO,1,1);
        Pieza torre2 = new Torre(ColorPieza.BLANCO,10,10);
        System.out.println(torre1);
        System.out.println(torre2);


    }
}
