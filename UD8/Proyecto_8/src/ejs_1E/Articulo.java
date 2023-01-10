package ejs_1E;

/*
Crea un programa con una clase llamada Articulo con los siguientes atributos: nombre,
precio (sin IVA), iva (siempre será 21) y cuantosQuedan (representa cuantos quedan en
el almacén).
 */

public class Articulo {

    private static final int IVAGeneral = 21;
    private static final int IVAReducido = 10;
    private static final int IVASuper = 4;
    private String nombre;
    private double precio;
    private int IVAProducto;
    private int cuantosQuedan;

    public Articulo(String nombre, double precio, int cuantosQuedan, char tipoIVA) {

        if ( (tipoIVA=='g' || tipoIVA=='r' || tipoIVA=='s') && precio>0 && cuantosQuedan>0){

            switch (tipoIVA){
                case 'g':
                    IVAProducto=IVAGeneral;
                    break;

                case 'r':
                    IVAProducto=IVAReducido;
                    break;

                case 's':
                    IVAProducto=IVASuper;
                    break;

            }
            this.nombre = nombre;
            this.precio = precio;
            this.cuantosQuedan = cuantosQuedan;
        } else {
            System.err.println("ERROR al instanciar Articulo...");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIVA() {
        return IVAProducto;
    }



    public int getCuantosQuedan() {
        return cuantosQuedan;
    }

    public void setCuantosQuedan(int cuantosQuedan) {
        this.cuantosQuedan = cuantosQuedan;
    }

    public void imprime(){
        System.out.printf("""
                Nombre: %s
                Precio: %.2f
                PVP: %.2f
                IVA: %d
                Quedan: %d
                
                """,nombre,precio,getPVP(),IVAProducto,cuantosQuedan);
    }

    public double getPVP(){
        return (precio+precio*IVAProducto/100);
    }

    public double getPVPDescuento(double descuento){
        return ( getPVP() * (1-(descuento/100)) );
        //hace falta comprobar que el descuento es de 0-100?
    }

    public boolean vender(int cantVendida){
        if (cantVendida>cuantosQuedan || cantVendida<1) {
            return false;
        }else{
            cuantosQuedan-=cantVendida;
            return true;
        }
    }

    public boolean almacenar(int cantAlmacenar){
        if (cantAlmacenar<1) {
            return false;
        }else{
            cuantosQuedan+=cantAlmacenar;
            return true;
        }
    }
}
