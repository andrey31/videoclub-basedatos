
package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Cliente;
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

        String query = "SELECT * FROM clientes WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("cliente")
            );
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

        String query = "INSERT INTO clientes (cliente) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1,cliente.getCliente());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    /* Lista todo los lenguajes */
    public List<Cliente> findAllCliente() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM clientes";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Cliente> clientes = new ArrayList<>();

        while (rs.next()) {
            Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("cliente")
            );
            clientes.add(cliente);
        }
        conexion.closeConnection();
        return clientes;
    }
    
    
    
    
    
    
    
    
    
}
