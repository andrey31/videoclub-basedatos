package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Canton;
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
        String query= "DELETE FROM distritos WHERE id=?";
        
        PreparedStatement ps= connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete= ps.executeUpdate();
        conexion.closeConnection();
        return delete;
        
    }
public Distrito findByIdDistrito(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT dist.id, dist.distrito, cant.canton FROM distritos"
        + " as dist INNER JOIN cantones as cant ON cant.id = dist.id WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Distrito distrito = new Distrito();
            distrito.setId(rs.getInt("id"));
            distrito.setDistrito(rs.getString("distrito"));
            
            Canton canton = new Canton();
            canton.setCanton(rs.getString("canton"));

            distrito.setCanton(canton);

            conexion.closeConnection();
            return distrito;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveDistrito(Distrito distrito) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO distrito (distrito, fk_canton) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, distrito.getDistrito());
        ps.setInt(2, distrito.getCanton().getId());
        
        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Distrito> findAllDistrito() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT dist.id, dist.distrito, cant.canton FROM distritos"
                + " as dist INNER JOIN cantones as cant ON cant.id = dist.id WHERE id = ?";

        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Distrito> distritos = new ArrayList<>();

        while (rs.next()) {
            Distrito distrito = new Distrito();
            distrito.setId(rs.getInt("id"));
            distrito.setDistrito(rs.getString("distrito"));
            
            Canton canton = new Canton();
            canton.setCanton(rs.getString("canton"));

            distrito.setCanton(canton);

            distritos.add(distrito);
        }
        conexion.closeConnection();
        return distritos;
    }
}

