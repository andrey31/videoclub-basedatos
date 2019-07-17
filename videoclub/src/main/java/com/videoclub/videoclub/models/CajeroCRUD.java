package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Cajero;
import com.videoclub.videoclub.models.entities.Direccion;
import com.videoclub.videoclub.models.entities.Distrito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CajeroCRUD {

    private Conexion conexion = new Conexion();
    DireccionCrud direccionCrud = new DireccionCrud();

    public Integer deleteCajeros(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE cajeros, direcciones FROM cajeros "
                + "INNER JOIN direcciones ON cajeros.fk_direccion = direcciones.id "
                + "WHERE cajeros.id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        int delete = ps.executeUpdate();
        conexion.closeConnection();

        return delete;
    }

    public Cajero findByIdCajeros(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

            
        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, c.telefono, "
        + "c.usuario, c.contrasena, d.id as direccion_id, d.direccion, "
        + "dist.id as distrito_id, dist.distrito "
        + "FROM cajeros as c "
        + "INNER JOIN direcciones as d ON d.id = c.fk_direccion "
        + "INNER JOIN distritos as dist ON dist.id = d.fk_distrito WHERE c.id = ?";
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
  
        if (rs.next()) {
            Cajero cajero = new Cajero();
            cajero.setId(rs.getInt("id"));
            cajero.setNombre(rs.getString("nombre"));
            cajero.setApellido1(rs.getString("apellido1"));
            cajero.setApellido2(rs.getString("apellido2"));
            cajero.setEmail(rs.getString("email"));
            cajero.setTelefono(rs.getString("telefono"));
            cajero.setUsuario(rs.getString("usuario"));
            cajero.setContrasena(rs.getString("contrasena"));
                    
            Direccion direccion = new Direccion();
            direccion.setId(rs.getInt("direccion_id"));
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setDistrito(new Distrito(
                rs.getInt("distrito_id"),
                rs.getString("distrito"), 
                null));
            cajero.setDireccion(direccion);
            
            conexion.closeConnection();
            return cajero;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveCajero(Cajero cajero) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        Direccion direccion = new Direccion( 0, cajero.getDireccion().getDireccion(), cajero.getDireccion().getDistrito());
        int idDireccion = direccionCrud.saveDireccion(direccion);
        
        if (idDireccion > 0){

            String query = "INSERT INTO cajeros (nombre, apellido1, apellido2, email,"
                + " telefono, usuario, contrasena, fk_direccion) "
                + "VALUES (?, ?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, cajero.getNombre());
            ps.setString(2, cajero.getApellido1());
            ps.setString(3, cajero.getApellido2());
            ps.setString(4, cajero.getEmail());
            ps.setString(5, cajero.getTelefono());
            ps.setString(6, cajero.getUsuario());
            ps.setString(7, cajero.getContrasena());
            ps.setInt(8, idDireccion);

            int insert = ps.executeUpdate();

            conexion.closeConnection();

            return insert;
        }
        else {
            return 0;
        }

    }

    public List<Cajero> findAllCajero() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, c.telefono, "
                + "c.usuario, c.contrasena, d.id as direccion_id, d.direccion, "
                + "dist.id as distrito_id, dist.distrito "
                + "FROM cajeros as c "
                + "INNER JOIN direcciones as d ON d.id = c.fk_direccion "
                + "INNER JOIN distritos as dist ON dist.id = d.fk_distrito";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Cajero> cajeros = new ArrayList<>();

        while (rs.next()) {
           Cajero cajero = new Cajero();
            cajero.setId(rs.getInt("id"));
            cajero.setNombre(rs.getString("nombre"));
            cajero.setApellido1(rs.getString("apellido1"));
            cajero.setApellido2(rs.getString("apellido2"));
            cajero.setEmail(rs.getString("email"));
            cajero.setTelefono(rs.getString("telefono"));
            cajero.setUsuario(rs.getString("usuario"));
            cajero.setContrasena(rs.getString("contrasena"));
                    
            Direccion direccion = new Direccion();
            direccion.setId(rs.getInt("direccion_id"));
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setDistrito(new Distrito(
                rs.getInt("distrito_id"),
                rs.getString("distrito"), 
                null));

            cajero.setDireccion(direccion);
            cajeros.add(cajero);
        }
        conexion.closeConnection();
        return cajeros;
    }
    
    public Integer updateCajero(int id, Cajero cajero) throws SQLException {
       conexion.connect();

       Connection connection = conexion.getConnection();
    
       Direccion direccion = cajero.getDireccion();
       direccion.setDireccion(cajero.getDireccion().getDireccion());
       direccion.setDistrito(cajero.getDireccion().getDistrito());
       int updateDireccion = direccionCrud.updateDireccion(direccion.getId(), direccion);

       if (updateDireccion == 1) {
           
        String query = "UPDATE cajeros SET nombre = ?, apellido1 = ?, "
               + "apellido2 = ?, email = ?, telefono = ?, usuario = ?, "
               + "contrasena = ?, fk_direccion = ? WHERE id = ?";
               
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, cajero.getNombre());
        ps.setString(2, cajero.getApellido1());
        ps.setString(3, cajero.getApellido2());
        ps.setString(4, cajero.getEmail());
        ps.setString(5, cajero.getTelefono());
        ps.setString(6, cajero.getUsuario());
        ps.setString(7, cajero.getContrasena());
        ps.setInt(8, direccion.getId());
        ps.setInt(9, id);
        /* Retorna 1 si se ejecuta correctamente */
        int update = ps.executeUpdate();
        conexion.closeConnection();
        
        return update;
        }
        return 0;   
   }
}

