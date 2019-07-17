package com.videoclub.videoclub.models;

import com.videoclub.videoclub.models.entities.Genero;
import com.videoclub.videoclub.models.entities.Lenguaje;
import com.videoclub.videoclub.models.entities.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaCrud {

    private Conexion conexion = new Conexion();

    public Integer deletePelicula(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE p, ap FROM peliculas as p "
                + "INNER JOIN autores_pelicula as ap ON ap.fk_pelicula = p.id "
                + "WHERE p.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete = ps.executeUpdate();
        conexion.closeConnection();
        return delete;

    }

    public Pelicula findByIdPelicula(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT p.id, p.titulo, p.descripcion, p.duracion, p.anio, p.img_url, "
                +"l.id as lenguaje_id, l.lenguaje, g.id as genero_id, g.genero "
                + "FROM peliculas as p INNER JOIN lenguajes as l ON l.id = p.fk_lenguaje "
                + "INNER JOIN generos as g ON g.id = p.fk_genero WHERE p.id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Pelicula pelicula = new Pelicula();
            pelicula.setId(rs.getInt("id"));
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setDescripcion(rs.getString("descripcion"));
            pelicula.setDuracion(rs.getString("duracion"));
            pelicula.setAnio(rs.getString("anio"));
            pelicula.setImgUrl(rs.getString("img_url"));
            Lenguaje lenguaje = new Lenguaje();
            lenguaje.setId(rs.getInt("lenguaje_id"));
            lenguaje.setLenguaje(rs.getString("lenguaje"));
            pelicula.setLenguaje(lenguaje);
            
            Genero genero = new Genero();
            genero.setGenero(rs.getString("genero"));
            genero.setId(rs.getInt("genero_id"));
            pelicula.setGenero(genero);
          
            conexion.closeConnection();
            return pelicula;
        }
        conexion.closeConnection();
        return null;
    }

    public Integer savePelicula(Pelicula pelicula) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO pelicula (titulo, descripcion, duracion, anio, img_url, fk_lenguaje, fk_genero) VALUES (?, ?,?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, pelicula.getTitulo());
        ps.setString(2, pelicula.getDescripcion());
        ps.setString(3, pelicula.getDuracion());
        ps.setString(4, pelicula.getAnio());
        ps.setString(5, pelicula.getImgUrl());
        ps.setInt(6, pelicula.getLenguaje().getId());
        ps.setInt(7, pelicula.getGenero().getId());
        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }
    public int findCountPeliculaByIdGenero(int idGenero) throws SQLException {
        conexion.connect();

        Connection connection = conexion.getConnection();

        String query = "SELECT COUNT(*) as count FROM `peliculas` WHERE fk_genero = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idGenero);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            return rs.getInt("count");
        }
        else {
            return 0;
        }
    }

    public int findCountPeliculaByIdLenguaje(int idLenguaje) throws SQLException {
        conexion.connect();

        Connection connection = conexion.getConnection();

        String query = "SELECT COUNT(*) as count FROM peliculas WHERE fk_lenguaje = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idLenguaje);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            return rs.getInt("count");
        }
        else {
            return 0;
        }
    }

    public Integer updatePelicula(int id, Pelicula pelicula) throws SQLException {
        conexion.connect();

        Connection connection = conexion.getConnection();

        String query = "UPDATE peliculas SET titulo = ?, descripcion = ?, "
                + "duracion = ?, anio = ?, img_url = ?, fk_lenguaje = ?, fk_genero = ? WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, pelicula.getTitulo());
        ps.setString(2, pelicula.getDescripcion());
        ps.setString(3, pelicula.getDuracion());
        ps.setString(4, pelicula.getAnio());
        ps.setString(5, pelicula.getImgUrl());
        ps.setInt(6, pelicula.getLenguaje().getId());
        ps.setInt(7, pelicula.getGenero().getId());
        ps.setInt(8, id);
        
        int update = ps.executeUpdate();
        conexion.closeConnection();

        return update;
    }

    public List<Pelicula> findAllPelicula() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT p.id, p.titulo, p.descripcion, p.duracion, p.anio, p.img_url, "+
                        "l.id as lenguaje_id, l.lenguaje, g.id as genero_id, g.genero " +
                        "FROM peliculas as p INNER JOIN lenguajes as l ON l.id = p.fk_lenguaje " +
                        "INNER JOIN generos as g ON g.id = p.fk_genero ORDER BY p.id";

        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Pelicula> Peliculas = new ArrayList<>();

        while (rs.next()) {
            
            Pelicula pelicula = new Pelicula();
            pelicula.setId(rs.getInt("id"));
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setDescripcion(rs.getString("descripcion"));
            pelicula.setDuracion(rs.getString("duracion"));
            pelicula.setAnio(rs.getString("anio"));
            pelicula.setImgUrl(rs.getString("img_url"));
            Lenguaje lenguaje = new Lenguaje();
            lenguaje.setId(rs.getInt("lenguaje_id"));
            lenguaje.setLenguaje(rs.getString("lenguaje"));
            pelicula.setLenguaje(lenguaje);
            
            Genero genero = new Genero();
            genero.setId(rs.getInt("genero_id"));
            genero.setGenero(rs.getString("genero"));
            pelicula.setGenero(genero);       
            
            Peliculas.add(pelicula);
        }
        conexion.closeConnection();
        return Peliculas;
    }
}
