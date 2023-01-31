package E_9;


import java.util.ArrayList;
import java.util.Arrays;

public class MainE_9 {

    public static void main(String[] args) {

        int[][] tablero={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,3},{0,2,2,0,3},{2,2,1,1,3},{0,3,2,2,1},{1,3,2,2,1},{3,3,1,2,1}};
        ArrayList <int[]> lineas = lineas(tablero);

        for (int[] linea : lineas) {
            System.out.println(Arrays.toString(linea));
        }

    }

    public static ArrayList<int[]> lineas(int[][] tablero){
        ArrayList<int[]> lineasCompletas = new ArrayList<>();

        boolean eslineaCompleta;
        for (int[] linea : tablero) {
            eslineaCompleta = true;

            for (int casilla : linea) {
                if (casilla==0) {
                    eslineaCompleta = false;
                    break;
                }
            }

            if (eslineaCompleta){
                lineasCompletas.add(linea);
            }
        }
        return lineasCompletas;
    }
}
