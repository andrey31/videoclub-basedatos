
package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Cliente;
import com.videoclub.videoclub.models.entities.Direccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCrud {
    
    private Conexion conexion = new Conexion();

    /* Elimina un cliente por id */
    public Integer deleteCliente(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM clientes WHERE id = ?";

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

        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, "
                + "c.telefono, d.direccion FROM clientes as c " +
                "INNER JOIN direcciones as d ON d.id = c.fk_direccion WHERE c.id = ?";

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
            direccion.setDireccion(rs.getString("direccion"));
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

        String query = "INSERT INTO clientes (nombre, apellido1, apellido2, email, telefono, fk_direccion) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getApellido1());
        ps.setString(3, cliente.getApellido2());
        ps.setString(4, cliente.getCorreo());
        ps.setString(5, cliente.getTel());
        ps.setInt(6, cliente.getDireccion().getId());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    /* Lista todo los lenguajes */
    public List<Cliente> findAllCliente() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT c.id, c.nombre, c.apellido1, c.apellido2, c.email, "
                + "c.telefono, d.direccion FROM clientes as c " +
                "INNER JOIN direcciones as d ON d.id = c.fk_direccion";
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
            direccion.setDireccion(rs.getString("direccion"));

            clientes.add(cliente);
        }
        conexion.closeConnection();
        return clientes;
    }
    
    
    
    
    
    
    
    
    
}
