package ejs_2_7;

public class MovilPrepago {

    //no podemos usar int para un numero de 13 digitos
    private final long numeroMovil;
    private static float costeEstableceLLamada, costeMinutoLLamada, costeConsumoMB;
    private float saldo=0;

    /* CONSTRUCTORES */
    public MovilPrepago(long numeroMovil) {
        if ( (numeroMovil+"").length()==13 ) {
            this.numeroMovil=numeroMovil;
        } else {
            System.err.println("Formato de numero invalido");
            this.numeroMovil=0;
        }
    }


    /* GETTERS Y SETTERS */

    public static float getCosteEstableceLLamada() {
        return costeEstableceLLamada;
    }
    public static void setCosteEstableceLLamada(float costeEstableceLLamada) {
        MovilPrepago.costeEstableceLLamada = costeEstableceLLamada;
    }
    public static float getCosteMinutoLLamada() {
        return costeMinutoLLamada;
    }
    public static void setCosteMinutoLLamada(float costeMinutoLLamada) {
        MovilPrepago.costeMinutoLLamada = costeMinutoLLamada;
    }
    public static float getCosteConsumoMB() {
        return costeConsumoMB;
    }
    public static void setCosteConsumoMB(float costeCostumoMB) {
        MovilPrepago.costeConsumoMB = costeCostumoMB;
    }


    /* OTROS */

    public void efectuarLlamada (int segundos){

//        saldo-= (costeEstableceLLamada+costeMinutoLLamada*(segundos/60));
//
//        if(saldo<0) {
//            System.out.println("Saldo insuficiente, llamada cortada");
//            saldo=0;
//        }


        int duracion = segundos;
        saldo -= costeEstableceLLamada;

        while(segundos > 0){

            saldo-=costeMinutoLLamada;

            if (saldo<=0){
                System.out.println("Saldo insuficiente, llamada cortada");
                saldo=0;
                duracion-=segundos;
                break;
            }

            segundos -= 60;

        }

        System.out.println("Duracion de la llamada: "+(duracion/60)+" minutos y "+(duracion%60)+" segundos.");

    }

    public void navegar (int mb){

        //A lo mejor hay una forma mas limpia pero que pereza xd, uso la de llamada.


        int mbNavegados = mb;

        while(mb > 0){

            saldo-=costeMinutoLLamada;

            if (saldo<=0){
                System.out.println("Saldo insuficiente, navegacion cortada");
                saldo=0;
                mbNavegados-=mb;
                break;
            }

            mb -= 1;

        }

        System.out.println("MB navegados: "+mbNavegados);

    }

    public boolean recargar (int importe){
        if (importe%5==0) {
            saldo+=importe;
            return true;
        }
        return false;
    }

    public float consultarSaldo(){
        return saldo;
    }





}
