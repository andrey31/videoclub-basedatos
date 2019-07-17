package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Cajero;
import com.videoclub.videoclub.models.entities.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CajeroCRUD {

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

            
        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, c.telefono, "
                + "c.usuario, c.contrasena, d.direccion "
                + "FROM cajeros as c "
                + "INNER JOIN direcciones as d ON d.id = c.fk_direccion WHERE d.id = ?";

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
            direccion.setDireccion(rs.getString("direccion"));
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

        String query = "INSERT INTO cajero (nombre, apellido1, apellido2, email,"
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
        ps.setInt(8, cajero.getDireccion().getId());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Cajero> findAllCajero() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, c.telefono, "
                + "c.usuario, c.contrasena, d.direccion "
                + "FROM cajeros as c "
                + "INNER JOIN direcciones as d ON d.id = c.fk_direccion WHERE d.id = ?";
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
            direccion.setDireccion(rs.getString("direccion"));
            cajero.setDireccion(direccion);
            cajeros.add(cajero);
        }
        conexion.closeConnection();
        return cajeros;
    }
    
    public Integer updateCajero(int id, Cajero cajero) throws SQLException {
       conexion.connect();

       Connection connection = conexion.getConnection();

       String query = "UPDATE cajero SET nombre = ?, apellido1 = ?, "
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
       ps.setInt(8, cajero.getDireccion().getId());
       ps.setInt(9, id);
       /* Retorna 1 si se ejecuta correctamente */
       int update = ps.executeUpdate();
       conexion.closeConnection();
    
       return update;
   }
}

