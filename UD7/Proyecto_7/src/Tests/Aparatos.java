package Tests;

public class Aparatos {
    //atributos
    private String nombre;
    private boolean encendido=false;
    private int watios;
    private static int consumoInicial=0;

    //constructor
    public Aparatos(String nombre, int watios){
        this.nombre=nombre;
        this.watios=watios;
    }

    //metodo
    public void imprime(){
        System.out.println();
    }

    public void encenderYApagar(){
        encendido=!encendido;
    }







//    public int consumoTotal(){
//
//    }

    public static void main(String[] args) {

    }
}