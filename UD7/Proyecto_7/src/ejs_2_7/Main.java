package ejs_2_7;

public class Main {
    public static void main(String[] args) {

        //F al final del numero para que funcione como un Float
        MovilPrepago.setCosteConsumoMB(0.2F);
        MovilPrepago.setCosteMinutoLLamada(0.15F);
        MovilPrepago.setCosteEstableceLLamada(0.5F);

        //L al final del numero para que funcione como un Long
        MovilPrepago movil1 = new MovilPrepago(1234567890123L);
        MovilPrepago movil2 = new MovilPrepago(9999999999999L);
        MovilPrepago movil3 = new MovilPrepago(999999999999L);

        System.out.println("Saldo: "+movil1.consultarSaldo()+"\n");

        System.out.println(
                movil1.recargar(4)?
                        "Recarga completada":
                        "Recarga fallida"
        );

        System.out.println(
                movil1.recargar(5)?
                        ("Recarga completada"):
                        ("Recarga fallida")
        );

        System.out.println("Saldo: "+movil1.consultarSaldo()+"\n");

        movil1.efectuarLlamada(135);
        System.out.println("Saldo: "+movil1.consultarSaldo()+"\n");

        movil1.navegar(50);
        System.out.println("Saldo: "+movil1.consultarSaldo()+"\n");

        movil1.recargar(5);
        System.out.println("Saldo: "+movil1.consultarSaldo()+"\n");

    }
}
