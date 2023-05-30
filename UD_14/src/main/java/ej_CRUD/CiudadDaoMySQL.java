package ej_CRUD;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CiudadDaoMySQL implements Dao<Ciudad>{

    private DataSource dataSource;

    public CiudadDaoMySQL() {
        // Configurar el BasicDataSource con los datos de la base de datos
        Properties datos = new Properties();
        try (InputStream configStream = MainCRUD.class.getClassLoader().getResourceAsStream("db_config.properties")) {
            datos.load(configStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://" + datos.getProperty("db.servidor") + ":3306/" + datos.getProperty("db.baseDatos"));
        basicDataSource.setUsername(datos.getProperty("db.usuario"));
        basicDataSource.setPassword(datos.getProperty("db.clave"));
        this.dataSource = basicDataSource;
    }

    @Override
    public Optional<Ciudad> obtener(String id) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM city WHERE code = ?")) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    String nombreCiudad = rs.getString("Name");
                    String distrito = rs.getString("District");
                    int poblacion = rs.getInt("Population");
                    String codigo = rs.getString("CountryCode");

                    return Optional.of(new Ciudad(id, nombreCiudad, distrito, poblacion, codigo));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Ciudad> obtenerTodos() {
        List<Ciudad> ciudadList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id FROM city")) {

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    String id = rs.getString(1);
                    Optional<Ciudad> ciudad = obtener(id);
                    ciudad.ifPresent(ciudadList::add);
//                    if (ciudad.isPresent()) ciudadList.add(ciudad.get());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ciudadList;
    }

    @Override
    public void guardar(Ciudad pais) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO country(codigo,nombre) VALUES (?,?)")) {

            ps.setString(1,pais.getCodigo());
            ps.setString(2,pais.getNombre());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Ciudad pais) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement("UPDATE country SET nombre=? WHERE id=?")) {

            pst.setString(1,pais.getNombre());
            pst.setString(2,pais.getCodigo());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void borrar(Ciudad pais) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement("delete from country where id=?")) {

            pst.setString(1,pais.getCodigo());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
