package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Facturas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FacturasCrud {

    private Conexion conexion = new Conexion();

    public Integer DeleteFacturas(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query= "DELETE FROM Facturas WHERE id=?";
        
        PreparedStatement ps= connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete= ps.executeUpdate();
        conexion.closeConnection();
        return delete;
        
    }
public Facturas findByIdFacturas(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM Facturas WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Facturas facturas = new Facturas(
                    rs.getInt("id"),
                    rs.getTimestamp("fecha"),
                    rs.getDouble("monto"),
                    rs.getString("facturas")
            );
            conexion.closeConnection();
            return facturas;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveFacturas(Facturas facturas) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO provincia (provincia) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, facturas.getFacturas());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }


}


