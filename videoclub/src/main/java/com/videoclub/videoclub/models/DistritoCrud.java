package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Distrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistritoCrud {

    private Conexion conexion = new Conexion();

    public Integer DeleteDistrito(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query= "DELETE FROM distrito WHERE id=?";
        
        PreparedStatement ps= connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete= ps.executeUpdate();
        conexion.closeConnection();
        return delete;
        
    }
public Distrito findByIdDistrito(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM distrito WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Distrito distrito = new Distrito(
                    rs.getInt("id"),
                    rs.getString("Distrito")
            );
            conexion.closeConnection();
            return distrito;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveDistrito(Distrito distrito) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO distrito (distrito) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, distrito.getDistrito());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Distrito> findAllCajero() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM distrito";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Distrito> Distrito = new ArrayList<>();

        while (rs.next()) {
            Distrito distrito= new Distrito(
                    rs.getInt("id"),
                    rs.getString("distrito")
            );
            Distrito.add(distrito);
        }
        conexion.closeConnection();
        return Distrito;
    }
}

