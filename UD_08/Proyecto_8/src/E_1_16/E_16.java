/*

16. Crea un programa que cree un array de enteros e introduzca la siguiente secuencia
de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego
la muestre por pantalla. En esta ocasión has de utilizar Arrays.fill().

*/

package E_1_16;

import java.util.Arrays;

public class E_16 {


    public static void main(String[] args) {

        int t=0;
        for (int i = 1; i <= 10; i++) {
            t+=i;
        }

        int[] arrayEnteros = new int[t];
        int indice=0;

        for(int num=1;num<=10;num++){
            Arrays.fill(arrayEnteros,indice,indice+num,num);
            indice+=num;
        }

        for (int valor : arrayEnteros) {
            System.out.print(valor+"  ");
        }

    }
}
