package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Cajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CajerosCRUD {

    private Conexion conexion = new Conexion();

    public Integer deleteCajeros(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM cajeros WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        int delete = ps.executeUpdate();
        conexion.closeConnection();

        return delete;
    }

    public Cajero findByIdCajeros(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM cajeros WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Cajero cajero = new Cajero(
                    rs.getInt("id"),
                    rs.getString("cajeros")
            );
            conexion.closeConnection();
            return cajero;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveCajero(Cajero cajero) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO cajero (cajero) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, cajero.getCajero());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Cajero> findAllCajero() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM cajero";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Cajero> cajero = new ArrayList<>();

        while (rs.next()) {
            Cajero cajeros = new Cajero(
                    rs.getInt("id"),
                    rs.getString("cajero")
            );
            cajero.add(cajeros);
        }
        conexion.closeConnection();
        return cajero;
    }
}

