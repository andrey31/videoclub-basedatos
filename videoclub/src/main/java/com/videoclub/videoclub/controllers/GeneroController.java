package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.GeneroCrud;
import com.videoclub.videoclub.models.entities.Genero;

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
 * GeneroController
 */
@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
public class GeneroController {

    GeneroCrud GeneroCrud = new GeneroCrud();

    @GetMapping("/{id}")
    public Genero getGenero(@PathVariable int id) throws SQLException { 
        return GeneroCrud.findByIdGenero(id);
    }

    @GetMapping
    public List<Genero> getAllGenero() throws SQLException {
        return GeneroCrud.findAllGenero();
    }

    @PostMapping
    public Integer saveGenero(@RequestBody Genero genero) throws SQLException {
        return GeneroCrud.saveGenero(genero);
    }

    @DeleteMapping("/{id}")
    public Integer deleteGenero(@PathVariable int id) throws SQLException {
        return GeneroCrud.deleteGenero(id);
    }

    @PutMapping("/{id}")
    public Integer editGenero(@PathVariable int id, @RequestBody Genero genero) throws SQLException {
        return GeneroCrud.updateGenero(id, genero);
    }
}