package com.videoclub.videoclub.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.videoclub.videoclub.models.entities.Autor;

/**
 * AutorCrud
 */

public class AutorCrud {
    
    private Conexion conexion = new Conexion();
    
    public Integer deleteAutor(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM autores WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        //Retorna 1 si se ejecuta correctamente
        int delete = ps.executeUpdate();
        conexion.closeConnection();
        
        return delete;
    }
    /* Busca un autor por id */
    public Autor findByIdAutor(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "SELECT * FROM autores WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            Autor autor = new Autor(
                rs.getInt("id"),
                rs.getString("autor")
            );
            conexion.closeConnection();
            return autor;
        }
        conexion.closeConnection();
        return null;
    }
    /* Guarda autor  */
    public Integer saveAutor(Autor autor) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "INSERT INTO autores (autor) VALUES (?)";
        
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, autor.getAutor());

        int insert = ps.executeUpdate();

        conexion.closeConnection();

        return insert;

    }
    /* Lista todo los autores */
    public List<Autor> findAllAutor() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT * FROM autores";
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Autor> autores = new ArrayList<>();

        while(rs.next()){
            Autor autor = new Autor(
                rs.getInt("id"),
                rs.getString("autor")
            );
            autores.add(autor);
        }
        conexion.closeConnection();
        return autores;
   }
   /* Actualiza datos de autor por id */
   public Integer updateAutor(int id, Autor autor) throws SQLException {
       conexion.connect();

       Connection connection = conexion.getConnection();

       String query = "UPDATE autores SET autor = ? WHERE id = ?";
       PreparedStatement ps = connection.prepareStatement(query);

       ps.setString(1, autor.getAutor());
       ps.setInt(2, id);
       /* Retorna 1 si se ejecuta correctamente */
       int update = ps.executeUpdate();
       conexion.closeConnection();
    
       return update;
   }
}