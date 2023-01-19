package otros;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String[][] tabla = new String[2][5];

        tabla[0][0] = "F0 C0";
        tabla[0][1] = "F0 C1";
        tabla[0][2] = "F0 C2";
        tabla[0][3] = "F0 C3";
        tabla[0][4] = "F0 C4";
        tabla[1][0] = "F1 C0";
        tabla[1][1] = "F1 C1";
        tabla[1][2] = "F1 C2";
        tabla[1][3] = "F1 C3";
        tabla[1][4] = "F1 C4";


        for(String[] fila : tabla){
            System.out.println("Fila "+ Arrays.toString(fila));
            for(String columna: fila){
                System.out.println(columna);
            }
        }


    }
}
