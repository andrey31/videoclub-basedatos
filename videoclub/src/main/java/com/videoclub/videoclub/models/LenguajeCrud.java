/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Lenguaje;
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
public class LenguajeCrud {

    private Conexion conexion = new Conexion();
    private PeliculaCrud peliculaCrud = new PeliculaCrud();

    /* Elimina un lenguaje por id */
    public Integer deleteLenguaje(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        int peliculaContainLenguaje = peliculaCrud.findCountPeliculaByIdLenguaje(id);
        System.out.println(peliculaContainLenguaje);

        int delete = 0;
        if(peliculaContainLenguaje == 0) {
            String query = "DELETE FROM lenguajes WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);
            //Retorna 1 si se ejecuta correctamente
            delete = ps.executeUpdate();
        }
        conexion.closeConnection();
        //Si lenguaje tiene peliculas asignadas no se puede borrar
        return delete;
    }

    /* Busca un lenguaje por id */
    public Lenguaje findByIdLenguaje(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM lenguajes WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Lenguaje lenguaje = new Lenguaje(
                    rs.getInt("id"),
                    rs.getString("lenguaje")
            );
            conexion.closeConnection();
            return lenguaje;
        }
        conexion.closeConnection();
        return null;
    }

    /* Guarda lenguaje  */
    public Integer saveLenguaje(Lenguaje lenguaje) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO lenguajes (lenguaje) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, lenguaje.getLenguaje());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    /* Lista todo los lenguajes */
    public List<Lenguaje> findAllLenguaje() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM lenguajes";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Lenguaje> lenguajes = new ArrayList<>();

        while (rs.next()) {
            Lenguaje lenguaje = new Lenguaje(
                    rs.getInt("id"),
                    rs.getString("lenguaje")
            );
            lenguajes.add(lenguaje);
        }
        conexion.closeConnection();
        return lenguajes;
    }

    /* Actualiza los datos de lenguajes por id */
    public Integer updateLenguaje(int id, Lenguaje lenguaje) throws SQLException {
        conexion.connect();

        Connection connection = conexion.getConnection();

        String query = "UPDATE lenguajes SET lenguaje = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, lenguaje.getLenguaje());
        ps.setInt(2, id);
        /* Retorna 1 si se ejecuta correctamente */
        int update = ps.executeUpdate();
        conexion.closeConnection();

        return update;
    }
}
