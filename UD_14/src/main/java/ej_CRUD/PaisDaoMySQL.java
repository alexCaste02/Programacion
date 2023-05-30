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

public class PaisDaoMySQL implements Dao<Pais> {
    // TODO: pasar todo esto a pais

    private final DataSource dataSource;

    public PaisDaoMySQL() {
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
    public Optional<Pais> obtener(String codigo) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps1 = con.prepareStatement("SELECT * FROM country WHERE code = ?")) {

            ps1.setString(1, codigo);

            try (ResultSet rs1 = ps1.executeQuery()) {
                if (rs1.next()) {

                    String nombrePais = rs1.getString("Name");

                    Dao<Ciudad> daoCiudades = new CiudadDaoMySQL();
                    List<Ciudad> ciudades = daoCiudades.obtenerTodos();

                    return Optional.of(new Pais(codigo, nombrePais, ciudades));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Pais> obtenerTodos() {
        List<Pais> paisList = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT code FROM country")) {

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    String codigo = rs.getString(1);
                    Optional<Pais> pais = obtener(codigo);
                    pais.ifPresent(paisList::add);
//                    if (obtener(codigo).isPresent()) paisList.add(obtener(codigo).get());
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paisList;
    }

    @Override
    public void guardar(Pais pais) {
        try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement("INSERT INTO country(code,name) VALUES (?,?)")) {

            ps.setString(1, pais.getCodigo());
            ps.setString(2, pais.getNombre());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Pais pais) {
        try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement("UPDATE country SET name=? WHERE code=?")) {

            ps.setString(1, pais.getNombre());
            ps.setString(2, pais.getCodigo());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void borrar(Pais pais) {
        try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM country WHERE code=?")) {

            ps.setString(1, pais.getCodigo());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

