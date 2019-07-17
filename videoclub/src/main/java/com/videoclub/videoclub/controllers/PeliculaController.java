package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.PeliculaCrud;
import com.videoclub.videoclub.models.entities.Pelicula;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PeliculaController
 */
@RestController
@RequestMapping("/peliculas")
@CrossOrigin("*")
public class PeliculaController {

    private PeliculaCrud peliculaCrud = new PeliculaCrud();

    @GetMapping("/{id}")
    public Pelicula getPelicula(@PathVariable int id) throws SQLException {
        return peliculaCrud.findByIdPelicula(id);
    }

    @GetMapping
    public List<Pelicula> getAllPelicula() throws SQLException {
        return peliculaCrud.findAllPelicula();
    }

    @PostMapping
    public Integer savePelicula(@RequestBody Pelicula pelicula) throws SQLException {
        return peliculaCrud.savePelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public Integer deletePelicula(@PathVariable int id) throws SQLException {
        return peliculaCrud.deletePelicula(id);
    }

    @PutMapping("/{id}")
    public Integer editPelicula(@PathVariable int id, @RequestBody Pelicula pelicula) throws SQLException {
        return peliculaCrud.updatePelicula(id, pelicula);
    }
    
}