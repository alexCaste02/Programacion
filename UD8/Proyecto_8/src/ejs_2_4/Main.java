package ejs_2_4;

public class Main {
    public static void main(String[] args) {

        EjemplarLibro libro1 = new EjemplarLibro("1984");
        EjemplarLibro libro2 = new EjemplarLibro("Don Quijote");
        EjemplarLibro libro3 = new EjemplarLibro(libro1);
        EjemplarLibro libro4 = new EjemplarLibro(libro2);

        System.out.println(libro1.prestar());
        System.out.println(libro3.prestar());
        System.out.println(libro1.devolver());

        System.out.println(libro3.prestar());
        System.out.println(libro1.devolver());

        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(libro4);


    }
}
