package E_8;

import java.util.Scanner;

public class Tienda {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (menuPrincipal());

    }

    public static boolean menuPrincipal(){

        System.out.println("""
                
                =======================
                    Menu Principal
                =======================
                Elige una operacion:
                
                1) Mostrar articulos
                2) Venta al cliente
                3) Compra a proveedor
                4) Gestionar articulos
                
                5) Salir
                """);

        switch (Input.readAndValidateOption()){
            case 1 -> mostrarArticulos();
            case 2 -> ventaAlCiente();
            case 3 -> compraAlProveedor();
            case 4 -> {while (menuGestionarArticulos());}
            case 5 -> {return false;}
            default -> System.out.println("Numero de operacion no valido");
        }
        return true;
    }

    public static void mostrarArticulos(){
        System.out.println("====== Articulos ======");
        for (Articulo articulo : Articulo.getListaArticulos()) {
            System.out.println(articulo.infoArticulo());
        }
        System.out.println("=======================");
    }

    public static void ventaAlCiente(){

        System.out.println("Introduce el identificador del articulo");
        Articulo articulo = Articulo.findArticulo(Input.readAndValidateInt());

        if(articulo!=null){

            System.out.println("Introduce las unidades que desea vender");
            int uds = Input.readAndValidateInt();
            System.out.println("Introduce el nombre del cliente");
            String cliente = input.nextLine();

            System.out.printf("""
                    Venta de %d unidades de %s.
                    Precio total: %f
                    
                    Por favor confirme la compra (Introduce 'Y' para confirmar, 'N' para cancelar.)
                    """,uds,articulo.getNombre(),articulo.getPrecioVenta()*uds);

            if (Input.readAndValidateYN() && articulo.vender(uds)){
                System.out.println("=== Venta realizada ===");
            } else {
                System.out.println("=== Venta cancelada ===");
            }

        } else {
            System.out.println("No existe un articulo con ese identificador");
        }
    }

    public static void compraAlProveedor(){
        System.out.println("=======================");
        System.out.println("Introduce el identificador del articulo");
        Articulo articulo = Articulo.findArticulo(Input.readAndValidateInt());

        if(articulo!=null){

            System.out.println("Introduce las unidades que desea comprar");
            int uds = Input.readAndValidateInt();
            System.out.println("Introduce el nombre del proveedor");
            String proveedor = input.nextLine();

            System.out.printf("""
                    Venta de %d unidades de %s.
                    Precio total: %f
                    
                    Por favor confirme la compra (Introduce 'Y' para confirmar, 'N' para cancelar.)
                    """,uds,articulo.getNombre(),articulo.getPrecioVenta()*uds);

            if (Input.readAndValidateYN() && articulo.vender(uds)){
                System.out.println("=== Compra realizada ===");
            } else {
                System.out.println("=== Compra cancelada ===");
            }

        } else {
            System.out.println("No existe un articulo con ese identificador");
        }
    }

    public static boolean menuGestionarArticulos(){

        System.out.println("""
                =======================
                 Gestion de articulos
                =======================
                Elige una operacion:
                
                1) Añadir articulo
                2) Editar articulo
                3) Eliminar articulo
                
                4) Volver
                """);

        switch (Input.readAndValidateOption()){
            case 1 -> addArticulo();
            case 2 -> editArticulo();
            case 3 -> removeArticulo();
            case 4 -> {return false;}
            default -> System.out.println("Numero de operacion no valido");
        }
        return true;
    }

    public static void addArticulo(){
        System.out.println("Introduce el nombre del nuevo articulo");
        String nombre = input.nextLine();
        System.out.println("Introduce el precio de venta");
        double precioV = Input.readAndValidateDouble();
        System.out.println("Introduce el precio de compra al proveedor");
        double precioC = Input.readAndValidateDouble();
        System.out.println("Introduce el stock inicial");
        int stock = Input.readAndValidateInt();

        new Articulo(nombre,precioV,precioC,stock);
        System.out.println("=== Articulo añadido correctamente ===");
    }

    public static void editArticulo(){
        System.out.println("Introduce el identificador del articulo a editar");
        Articulo articulo = Articulo.findArticulo(Input.readAndValidateInt());

        if(articulo!=null){

            System.out.println("Introduce el nuevo precio de venta al cliente");
            double precioV = Input.readAndValidateDouble();
            System.out.println("Introduce el nuevo precio de compra al proveedor");
            double precioC = Input.readAndValidateDouble();
            System.out.println("Introduce el nuevo stock");
            int stock = Input.readAndValidateInt();

            if (articulo.validateAll(precioV, precioC, stock)) {
                articulo.setPrecioVenta(precioV);
                articulo.setPrecioCompraProveedor(precioC);
                articulo.setStock(stock);
                System.out.println("=== Articulo modificado correctamente ===");
            } else {
                System.out.println("=== Articulo no ha sido modificado ===");
            }

        } else {
            System.out.println("No existe un articulo con ese identificador");
        }
    }

    public static void removeArticulo(){
        System.out.println("Introduce el identificador del articulo a editar");
        Articulo articulo = Articulo.findArticulo(Input.readAndValidateInt());

        if(articulo!=null){
            Articulo.getListaArticulos().remove(articulo);
            System.out.println("=== Articulo eliminado correctamente ===");
        } else {
            System.out.println("No existe un articulo con ese identificador");
        }
    }

}
