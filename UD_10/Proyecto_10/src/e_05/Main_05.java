package e_05;


public class Main_05 {

    public static void main(String[] args) {

        try {
            imprimePositivo(5);
            imprimePositivo(-5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }


        try {
            imprimeNegativo(-5);
            imprimeNegativo(5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }


    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("Valor no es positivo");
        }
        System.out.println("+" + p);
    }

    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("Valor no es negativo");
        }
        System.out.println(n);
    }
}
