package E_8;

public class Tienda {

    public static void main(String[] args) {


    }

    public static void menuPrincipal(){

        System.out.println("""
                Elige una operacion:
                
                1) Mostrar articulos
                2) Venta al cliente
                3) Compra a proveedor
                4) Gestionar articulos
                
                5) Salir
                """);

        switch (ValidateInput.readAndValidateOption()){

            case 1 -> mostrarArticulos();
            case 2 -> ventaAlCiente();


        }

    }


    public static void mostrarArticulos(){
        for (Articulo articulo : Articulo.getListaArticulos()) {
            System.out.println(articulo.infoArticulo());
        }
    }

    public static void ventaAlCiente(){

        System.out.println("Introduce el identificador del articulo");
        Articulo articulo = Articulo.findArticulo(ValidateInput.readAndValidateInt());

        if(articulo!=null){
            System.out.println("Introduce las unidades que desea vender");
            int uds = ValidateInput.readAndValidateInt();

            System.out.printf("""
                    Venta de %d unidades de %s.
                    Precio total: %f
                    
                    Por favor confirme la compra (Introduce 'Y' para confirmar, 'N' para cancelar.)
                    """,uds,articulo.getNombre(),articulo.getPrecioVenta()*uds);

            if (ValidateInput.readAndValidateYN() && articulo.vender(uds)){
                System.out.println("=== Venta realizada ===");
            } else {
                System.out.println("=== Venta cancelada ===");
            }

        } else {
            System.out.println("No existe un articulo con ese identificador");
        }




    }

}
