package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Genero;
import com.videoclub.videoclub.models.entities.Lenguaje;
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
        String query = "DELETE FROM peliculas WHERE id=?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete = ps.executeUpdate();
        conexion.closeConnection();
        return delete;

    }

    public Peliculas findByIdPeliculas(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT p.id, p.titulo, p.descripcion, p.duracion, p.anio, l.lenguaje, g.genero "
                + "FROM peliculas as p INNER JOIN lenguajes as l ON l.id = p.fk_lenguaje "
                + "INNER JOIN generos as g ON g.id = p.fk_genero WHERE p.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Peliculas pelicula = new Peliculas();
            pelicula.setId(rs.getInt("id"));
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setDescripcion(rs.getString("descripcion"));
            pelicula.setDuracion(rs.getString("duracion"));
            pelicula.setAnio(rs.getString("anio"));
            
            Lenguaje lenguaje = new Lenguaje();
            lenguaje.setLenguaje(rs.getString("lenguaje"));
            pelicula.setLenguaje(lenguaje);
            
            Genero genero = new Genero();
            genero.setGenero(rs.getString("genero"));
            pelicula.setGenero(genero);
          
            conexion.closeConnection();
            return pelicula;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer savePeliculas(Peliculas pelicula) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO pelicula (titulo, descripcion, duracion, anio, fk_lenguaje, fk_genero) VALUES (?, ?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, pelicula.getTitulo());
        ps.setString(2, pelicula.getDescripcion());
        ps.setString(3, pelicula.getDuracion());
        ps.setString(4, pelicula.getAnio());
        ps.setInt(5, pelicula.getLenguaje().getId());
        ps.setInt(6, pelicula.getGenero().getId());
        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }

    public List<Peliculas> findAllPelicula() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT p.id, p.titulo, p.descripcion, p.duracion, p.anio, l.lenguaje, g.genero " +
                      "FROM peliculas as p INNER JOIN lenguajes as l ON l.id = p.fk_lenguaje " +
                       "INNER JOIN generos as g ON g.id = p.fk_genero ORDER BY p.id";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Peliculas> Peliculas = new ArrayList<>();

        while (rs.next()) {
            
            Peliculas pelicula = new Peliculas();
            pelicula.setId(rs.getInt("id"));
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setDescripcion(rs.getString("descripcion"));
            pelicula.setDuracion(rs.getString("duracion"));
            pelicula.setAnio(rs.getString("anio"));
            
            Lenguaje lenguaje = new Lenguaje();
            lenguaje.setLenguaje(rs.getString("lenguaje"));
            pelicula.setLenguaje(lenguaje);
            
            Genero genero = new Genero();
            genero.setGenero(rs.getString("genero"));
            pelicula.setGenero(genero);       
            
            Peliculas.add(pelicula);
        }
        conexion.closeConnection();
        return Peliculas;
    }
}
