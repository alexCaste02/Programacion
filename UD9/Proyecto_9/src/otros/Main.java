package otros;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String[][] tabla = new String[2][5];

        tabla[0][0] = "F0 C0";
        tabla[0][1] = "F0 C0";
        tabla[0][2] = "F0 C0";
        tabla[0][3] = "F0 C0";
        tabla[0][4] = "F0 C0";
        tabla[1][0] = "F0 C0";
        tabla[1][1] = "F0 C0";
        tabla[1][2] = "F0 C0";
        tabla[1][3] = "F0 C0";
        tabla[1][4] = "F0 C0";


        for(String[] fila : tabla){
            System.out.println("Fila "+fila);
            for(String col: fila){

            }
        }


    }
}
