
package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Cliente;
import com.videoclub.videoclub.models.entities.Direccion;
import com.videoclub.videoclub.models.entities.Distrito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCrud {
    
    private Conexion conexion = new Conexion();
    DireccionCrud direccionCrud = new DireccionCrud();

    /* Elimina un cliente por id */
    public Integer deleteCliente(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE clientes, direcciones FROM clientes "
                + "INNER JOIN direcciones ON clientes.fk_direccion = direcciones.id "
                + "WHERE clientes.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        //Retorna 1 si se ejecuta correctamente
        int delete = ps.executeUpdate();
        conexion.closeConnection();

        return delete;
    }
    
     /* Busca un cliente por id */
    public Cliente findByIdCliente(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, "+
                "c.telefono, d.id as direccion_id, d.direccion, "+
                "dist.id as distrito_id, dist.distrito "+
                "FROM clientes as c " +
                "INNER JOIN direcciones as d ON d.id = c.fk_direccion "+
                "INNER JOIN distritos as dist ON dist.id = d.fk_distrito WHERE c.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido1(rs.getString("apellido1"));
            cliente.setApellido2(rs.getString("apellido2"));
            cliente.setCorreo(rs.getString("email"));
            cliente.setTel(rs.getString("telefono"));

            Direccion direccion = new Direccion();
            direccion.setId(rs.getInt("direccion_id"));
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setDistrito(new Distrito(
                rs.getInt("distrito_id"),
                rs.getString("distrito"), 
                null));
            cliente.setDireccion(direccion);

            conexion.closeConnection();
            return cliente;
        }
        conexion.closeConnection();
        return null;
    }

    /* Guarda lenguaje  */
    public Integer saveCliente(Cliente cliente) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        Direccion direccion = new Direccion( 0, cliente.getDireccion().getDireccion(), cliente.getDireccion().getDistrito());
        int idDireccion = direccionCrud.saveDireccion(direccion);

        if(idDireccion > 0 ){
            String query = "INSERT INTO clientes (nombre, apellido1, apellido2, email, telefono, fk_direccion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido1());
            ps.setString(3, cliente.getApellido2());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getTel());
            ps.setInt(6, idDireccion);

            int insert = ps.executeUpdate();
            conexion.closeConnection();

            return insert;
        }
        else {

            return 0;
        }

    }

    /* Lista todo los lenguajes */
    public List<Cliente> findAllCliente() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, "+
                "c.telefono, d.id as direccion_id, d.direccion, "+
                "dist.id as distrito_id, dist.distrito "+
                "FROM clientes as c " +
                "INNER JOIN direcciones as d ON d.id = c.fk_direccion "+
                "INNER JOIN distritos as dist ON dist.id = d.fk_distrito";
    
        System.out.println(query);
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Cliente> clientes = new ArrayList<>();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido1(rs.getString("apellido1"));
            cliente.setApellido2(rs.getString("apellido2"));
            cliente.setCorreo(rs.getString("email"));
            cliente.setTel(rs.getString("telefono"));

            Direccion direccion = new Direccion();
            direccion.setId(rs.getInt("direccion_id"));
            direccion.setDireccion(rs.getString("direccion"));
            direccion.setDistrito(new Distrito(
                rs.getInt("distrito_id"),
                rs.getString("distrito"), 
                null));
            cliente.setDireccion(direccion);
            clientes.add(cliente);
        }
        conexion.closeConnection();
        return clientes;
    }
    
    public Integer updateCliente(int id, Cliente cliente) throws SQLException {
        conexion.connect();
 
        Connection connection = conexion.getConnection();
        
        Direccion direccion = cliente.getDireccion();
        direccion.setDireccion(cliente.getDireccion().getDireccion());
        direccion.setDistrito(cliente.getDireccion().getDistrito());
        int updateDireccion = direccionCrud.updateDireccion(direccion.getId(), direccion);
 
        if (updateDireccion == 1) {
            
         String query = "UPDATE clientes SET nombre = ?, apellido1 = ?, "
                + "apellido2 = ?, email = ?, telefono = ?, fk_direccion = ? "
                + "WHERE id = ?";
        
         PreparedStatement ps = connection.prepareStatement(query);
 
         ps.setString(1, cliente.getNombre());
         ps.setString(2, cliente.getApellido1());
         ps.setString(3, cliente.getApellido2());
         ps.setString(4, cliente.getCorreo());
         ps.setString(5, cliente.getTel());
         ps.setInt(6, direccion.getId());
         ps.setInt(7, id);
         /* Retorna 1 si se ejecuta correctamente */
         int update = ps.executeUpdate();
         conexion.closeConnection();
         
         return update;
         }
         return 0;   
    }
    
    
    
    
    
}
