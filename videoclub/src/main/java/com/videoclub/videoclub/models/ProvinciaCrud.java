package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaCrud {

    private Conexion conexion = new Conexion();

    public Integer DeleteProvincia(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query= "DELETE FROM provincia WHERE id=?";
        
        PreparedStatement ps= connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete= ps.executeUpdate();
        conexion.closeConnection();
        return delete;
        
    }
public Provincia findByIdProvincia(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM provincia WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Provincia provincia = new Provincia(
                    rs.getInt("id"),
                    rs.getString("provincia")
            );
            conexion.closeConnection();
            return provincia;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveProvincia(Provincia provincia) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO provincia (provincia) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, provincia.getProvincia());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Provincia> findAllProvincia() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM provincia";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Provincia> Provincia = new ArrayList<>();

        while (rs.next()) {
            Provincia provincia= new Provincia(
                    rs.getInt("id"),
                    rs.getString("provincia")
            );
            Provincia.add(provincia);
        }
        conexion.closeConnection();
        return Provincia;
    }
}

