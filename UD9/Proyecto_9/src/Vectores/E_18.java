/*

18. Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios
entre 0 y 9. Luego ordena los valores del array y los mostrará por pantalla.

*/

package Vectores;

import java.util.Arrays;


public class E_18 {

    public static void main(String[] args) {

        int[] nums = new int[30];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.floor(Math.random()*10);
        }

        Arrays.sort(nums);

        for (int num : nums) {
            System.out.print(num+"  ");
        }

    }

}
