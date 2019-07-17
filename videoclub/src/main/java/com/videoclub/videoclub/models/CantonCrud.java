package com.videoclub.videoclub.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.videoclub.videoclub.models.entities.Canton;
import com.videoclub.videoclub.models.entities.Provincia;

/**
 * CantonCrud
 */
public class CantonCrud {
    private Conexion conexion = new Conexion();
    
    public List<Canton> findAllCantones() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT cant.id, cant.canton, prov.provincia FROM cantones"
                + " as cant INNER JOIN provincias as prov ON prov.id = cant.fk_provincia";
        System.out.println(query);
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        List<Canton> cantones = new ArrayList<>();

        while (rs.next()) {
            Canton canton = new Canton();
            canton.setId(rs.getInt("id"));
            canton.setCanton(rs.getString("canton"));
            
            Provincia provincia = new Provincia();
            provincia.setProvincia(rs.getString("provincia"));

            canton.setProvincia(provincia);

            cantones.add(canton);
        }
        conexion.closeConnection();
        return cantones;
    }
}