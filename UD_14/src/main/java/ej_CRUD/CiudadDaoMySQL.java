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

public class CiudadDaoMySQL implements Dao<Ciudad> {

    private final DataSource dataSource;

    public CiudadDaoMySQL() {
        // Configurar el BasicDataSource con los datos de la base de datos
        Properties datos = new Properties();
        try (InputStream configStream = CiudadDaoMySQL.class.getClassLoader().getResourceAsStream("db_config.properties")) {
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
             PreparedStatement ps = con.prepareStatement("SELECT * FROM city WHERE id = ?"))
        {
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
             PreparedStatement ps = con.prepareStatement("SELECT * FROM city")) {

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String id = rs.getString("Id");
                    String nombreCiudad = rs.getString("Name");
                    String distrito = rs.getString("District");
                    int poblacion = rs.getInt("Population");
                    String codigo = rs.getString("CountryCode");

                    ciudadList.add(new Ciudad(id,nombreCiudad,distrito,poblacion,codigo));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ciudadList;
    }

    @Override
    public void guardar(Ciudad ciudad) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO city(id,name,district,population,countrycode) VALUES (?,?,?,?,?)")) {
            ps.setString(1, ciudad.getId());
            ps.setString(2, ciudad.getNombre());
            ps.setString(3, ciudad.getDistrito());
            ps.setInt(4, ciudad.getPoblacion());
            ps.setString(5, ciudad.getCodigoPais());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Ciudad ciudad) {
        try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement("UPDATE city SET name=?,district=?,population=?,countrycode=? WHERE id=?")) {
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getDistrito());
            ps.setInt(3, ciudad.getPoblacion());
            ps.setString(4, ciudad.getCodigoPais());

            ps.setString(5, ciudad.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void borrar(Ciudad pais) {
        try (Connection conn = dataSource.getConnection(); PreparedStatement pst = conn.prepareStatement("DELETE FROM country WHERE id=?")) {
            pst.setString(1, pais.getId());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
