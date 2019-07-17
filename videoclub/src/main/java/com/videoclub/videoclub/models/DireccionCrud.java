package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Direccion;
import com.videoclub.videoclub.models.entities.Distrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DireccionCrud {
    
     private Conexion conexion = new Conexion();

    public Integer deleteDireccion(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM direcciones WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        int delete = ps.executeUpdate();
        conexion.closeConnection();

        return delete;
    }

    public Direccion findByIdDirecciones(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

            
        String query = "SELECT d.id, d.direccion, dis.distrito FROM direcciones as d "
                + "INNER JOIN distritos as dis ON dis.id = d.fk_distrito WHERE d.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
  
        if (rs.next()) {
            Direccion direccion = new Direccion();
            direccion.setId(rs.getInt("id"));
            direccion.setDireccion(rs.getString("direccion"));
                    
            Distrito distrito = new Distrito();
            distrito.setDistrito(rs.getString("distrito"));
            direccion.setDistrito(distrito);
            
            conexion.closeConnection();
            return direccion;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveDireccion(Direccion direccion) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO direcciones (direccion, fk_distrito) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, direccion.getDireccion());
        ps.setInt(2, direccion.getDistrito().getId());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    /* public List<Direccion> findAllDireccion() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT d.id, d.direccion FROM direccion as d INNER JOIN distrito as 1 ON l.id = p.fk_distrito WHERE d.id = ?";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Direccion> direcciones = new ArrayList<>();

        while (rs.next()) {
           Direccion direccion = new Direccion();
            direccion.setId(rs.getInt("id"));
            direccion.setDireccion(rs.getString("Direccion"));
                    
            Distrito distrito = new Distrito();
            distrito.setDistrito(rs.getString("distrito"));
            direccion.setDistrito(distrito);
            direcciones.add(direccion);
        }
        conexion.closeConnection();
        return direcciones;
    } */
    
    public Integer updateDireccion(int id, Direccion direccion) throws SQLException {
       conexion.connect();

       Connection connection = conexion.getConnection();

       String query = "UPDATE direcciones SET direccion = ?, fk_distrito = ? WHERE id = ?";
       PreparedStatement ps = connection.prepareStatement(query);

       ps.setString(1, direccion.getDireccion());
       ps.setInt(2, direccion.getDistrito().getId());
       ps.setInt(3, id);
       /* Retorna 1 si se ejecuta correctamente */
       int update = ps.executeUpdate();
       conexion.closeConnection();
    
       return update;
   }
    
}

