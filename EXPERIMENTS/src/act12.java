import java.util.Scanner;

public class act12 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int hora = 0;
        int minutos = 0;
        int segundos = 0;
        int incremento = 0;
        try {
            System.out.print("Introduce la hora: ");
            hora = input.nextInt();
            System.out.print("Introduce los minutos: ");
            minutos = input.nextInt();
            System.out.print("Introduce los segundos: ");
            segundos = input.nextInt();
            System.out.print("Introduce el incremento en segundos: ");
            incremento = input.nextInt();
        } catch (Exception e){
            System.out.println("Valor no valido");
        }


        int segundosTotales = hora * 3600 + minutos * 60 + segundos + incremento;
        hora = segundosTotales / 3600 % 24;
        minutos = segundosTotales % 3600 / 60;
        segundos = segundosTotales % 60;

        // Imprimir la nueva hora con el incremento
        System.out.printf("La nueva hora es %02d:%02d:%02d%n", hora, minutos, segundos);

    }
}

