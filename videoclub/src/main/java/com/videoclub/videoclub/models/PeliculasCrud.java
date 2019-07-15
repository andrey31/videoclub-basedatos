package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Peliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculasCrud {

    private Conexion conexion = new Conexion();

    public Integer DeletePeliculas(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query= "DELETE FROM peliculas WHERE id=?";
        
        PreparedStatement ps= connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete= ps.executeUpdate();
        conexion.closeConnection();
        return delete;
        
    }
public Peliculas findByIdPeliculas(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM peliculas WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Peliculas peliculas = new Peliculas(
                    rs.getInt("id"),
                    rs.getString("peliculas")
            );
            conexion.closeConnection();
            return peliculas;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer savePeliculas(Peliculas pelicula) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO pelicula (pelicula) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, pelicula.getPeliculas());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Peliculas> findAllCajero() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM peliculas";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Peliculas> Peliculas = new ArrayList<>();

        while (rs.next()) {
            Peliculas pelicula= new Peliculas(
                    rs.getInt("id"),
                    rs.getString("peliculas")
            );
            Peliculas.add(pelicula);
        }
        conexion.closeConnection();
        return Peliculas;
    }
}
