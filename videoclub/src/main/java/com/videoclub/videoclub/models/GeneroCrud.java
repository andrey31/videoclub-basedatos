/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class GeneroCrud {

    private Conexion conexion = new Conexion();

    /* Elimina un genero por id */
    public Integer deleteGenero(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM generos WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        //Retorna 1 si se ejecuta correctamente
        int delete = ps.executeUpdate();
        conexion.closeConnection();

        return delete;
    }

    /* Busca un genero por id */
    public Genero findByIdGenero(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM generos WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Genero genero = new Genero(
                    rs.getInt("id"),
                    rs.getString("genero")
            );
            conexion.closeConnection();
            return genero;
        }
        conexion.closeConnection();
        return null;
    }

    /* Guarda genero  */
    public Integer saveGenero(Genero genero) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO generos (genero) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, genero.getGenero());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    /* Lista todo los generos */
    public List<Genero> findAllGenero() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM generos";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Genero> generos = new ArrayList<>();

        while (rs.next()) {
            Genero genero = new Genero(
                    rs.getInt("id"),
                    rs.getString("Genero")
            );
            generos.add(genero);
        }
        conexion.closeConnection();
        return generos;
    }

    /* Actualiza datos de genero por id */
    public Integer updateGenero(int id, Genero genero) throws SQLException {
        conexion.connect();

        Connection connection = conexion.getConnection();

        String query = "UPDATE generos SET genero = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, genero.getGenero());
        ps.setInt(2, id);
        /* Retorna 1 si se ejecuta correctamente */
        int update = ps.executeUpdate();
        conexion.closeConnection();

        return update;
    }
}
