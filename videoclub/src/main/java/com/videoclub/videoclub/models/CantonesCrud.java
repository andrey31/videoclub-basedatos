package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Canton;
import com.videoclub.videoclub.models.entities.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CantonesCrud {
    
     private Conexion conexion = new Conexion();

    public Integer deleteCantones(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM cantones WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        int delete = ps.executeUpdate();
        conexion.closeConnection();

        return delete;
    }

    public Canton findByIdCantones(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

            
        String query = "SELECT d.id, d.canton FROM cantones as d INNER JOIN provincias as 1 ON l.id = p.fk_provincia WHERE d.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
  
        if (rs.next()) {
            Canton canton = new Canton();
           canton.setId(rs.getInt("id"));
           canton.setCanton(rs.getString("Canton"));
                    
            Provincia provincia = new Provincia();
            provincia.setProvincia(rs.getString("provincia"));
            canton.setProvincia(provincia);
            
            conexion.closeConnection();
            return canton;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveCantones(Canton canton) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO cantones (canton, fk_provincia) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, canton.getCanton());
        ps.setInt(2, canton.getProvincia().getId());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Canton> findAllCantones() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT d.id, d.canton FROM cantones as d INNER JOIN provincias as 1 ON l.id = p.fk_provincia WHERE d.id = ?";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Canton> cantones = new ArrayList<>();

        while (rs.next()) {
           Canton canton = new Canton();
           canton.setId(rs.getInt("id"));
           canton.setCanton(rs.getString("canton"));
                    
            Provincia provincia = new Provincia();
            provincia.setProvincia(rs.getString("provincia"));
            canton.setProvincia(provincia);
        }
        conexion.closeConnection();
        return cantones;
    }
    
    public Integer updateCantones(int id, Canton canton) throws SQLException {
       conexion.connect();

       Connection connection = conexion.getConnection();

       String query = "UPDATE cantones SET canton = ? WHERE id = ?";
       PreparedStatement ps = connection.prepareStatement(query);

       ps.setString(1, canton.getCanton());
       ps.setInt(2, id);
       /* Retorna 1 si se ejecuta correctamente */
       int update = ps.executeUpdate();
       conexion.closeConnection();
    
       return update;
   }
    
}

