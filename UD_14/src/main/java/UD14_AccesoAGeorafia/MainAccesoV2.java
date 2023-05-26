package UD14_AccesoAGeorafia;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MainAccesoV2 {
    public static void main(String[] args) {

        //Direccion de la base de datos local
        String url = "jdbc:mysql://localhost:3306/geografia";

        //Conexion a la base de datos, con el usuario y contraseña correspondiente
        try (Connection conn = DriverManager.getConnection(url, "root", "");
             Statement st = conn.createStatement();
             //Consulta para obtener todos los campos de todos los paises
             ResultSet rs = st.executeQuery("SELECT * FROM country"))
        {

            //Mapa - Clave: Codigo del pais - Valor: Instancia de Pais
            Map<String, Pais> mapaPaises = new HashMap<>();

            //Se obtienen las columnas necesarias para crear el objeto de clase Pais
            // y guardamos los datos correspondientes en el mapa
            while (rs.next()) {

                // (Uso de variables para facilitar lectura)
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String continent = rs.getString("Continent");
                double surface = rs.getDouble("SurfaceArea");
                int population = rs.getInt("Population");

                mapaPaises.put(code, new Pais(code, name, continent, surface, population));
            }

            //Titulo de las columnas con el mismo formato del toString de  la clase paises
            System.out.printf("%-50s - %-3s - %-15s - %-15s - %-15s %n",
                    "Nombre", "Codigo", "Continente", "Superficie", "Poblacion"
            );
            System.out.println("============================================================================================================");
            mapaPaises.values().forEach(System.out::println);

            //Cantidad de paises guardados para facilitar comprobacion
            System.out.println("\nMap size = " + mapaPaises.size());

        } catch (SQLException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}