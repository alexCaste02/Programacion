package ej_CRUD;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class PaisDaoMySQL implements Dao<Pais>{
    // TODO: pasar todo esto a pais

    // Un DataSource es un intermediario para obtener las conexiones con la base de datos
    private DataSource dataSource;

    public PaisDaoMySQL(){
        // Configurar el BasicDataSource con los datos de la base de datos
        Properties datos=new Properties();
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("db_config.properties")) {
            datos.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://"+datos.getProperty("db.servidor")+":3306/"+datos.getProperty("db.baseDatos"));
        basicDataSource.setUsername(datos.getProperty("db.usuario"));
        basicDataSource.setPassword(datos.getProperty("db.clave"));
        this.dataSource = basicDataSource;
    }

    @Override
    public Optional<Pais> obtener(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT nombre, direccion FROM clientes WHERE id = ?")) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");

//                    Pais cliente = new Pais(id, nombre, direccion);
//                    return Optional.of(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Pais> obtenerTodos() {
        List<Pais> clientes = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nombre, direccion FROM clientes")) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

//                Pais cliente = new Pais(id, nombre, direccion);
//                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void guardar(Pais pais) {
        try (Connection conn=dataSource.getConnection();
             PreparedStatement pst=conn.prepareStatement("insert into clientes(nombre,direccion) values (?,?)")) {

//            pst.setString(1,cliente.getNombre());
//            pst.setString(2,cliente.getDireccion());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Pais cliente) {
        try (Connection conn=dataSource.getConnection();
             PreparedStatement pst=conn.prepareStatement("update clientes set nombre=?, direccion=? where id=?")) {

//            pst.setString(1,cliente.getNombre());
//            pst.setString(2,cliente.getDireccion());
//            pst.setLong(3,cliente.getId());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(Pais cliente) {
        try (Connection conn=dataSource.getConnection();
             PreparedStatement pst=conn.prepareStatement("delete from clientes where id=?")) {

//            pst.setLong(1,cliente.getId());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

