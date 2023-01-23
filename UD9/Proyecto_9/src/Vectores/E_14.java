package Vectores;

/*

14. Crea un programa que cree un array de enteros e introduzca la siguiente secuencia
de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego
la muestre por pantalla.

*/



public class E_14 {


    public static void main(String[] args) {

        // debemos contar 55 o programarlo?
        int t=0;
        for (int i = 1; i <= 10; i++) {
            t+=i;
        }

        int[] arrayEnteros = new int[t];
        int indice=0;

        for(int num=1;num<=10;num++){
            for (int rep=1;rep<=num;rep++){
                arrayEnteros[indice]=num;
                indice++;
            }

        }



        for (int valor : arrayEnteros) {
            System.out.print(valor+"  ");
        }

    }
}
