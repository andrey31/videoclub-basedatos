package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FacturaCrud {

    private Conexion conexion = new Conexion();

    public Integer DeleteFactura(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "DELETE FROM Factura WHERE id=?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete = ps.executeUpdate();
        conexion.closeConnection();
        return delete;

    }

    public Factura findByIdFactura(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM Factura WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Factura factura = new Factura(
                    rs.getInt("id"),
                    rs.getTimestamp("fecha"),
                    rs.getDouble("monto")
            );
            conexion.closeConnection();
            return factura;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer saveFactura(Factura factura) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO Facturas (fecha, monto) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setTimestamp(1, factura.getFecha());
        ps.setDouble(2, factura.getMonto());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }
    public List<Factura> findAllFactura() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM Facturas";

        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Factura> facturas = new ArrayList<>();

        while (rs.next()) {
            Factura factura = new Factura(
                    rs.getInt("id"),
                    rs.getTimestamp("fecha"),
                    rs.getDouble("monto")
            );
            facturas.add(factura);

        }
        conexion.closeConnection();
        return facturas;
    }

}
