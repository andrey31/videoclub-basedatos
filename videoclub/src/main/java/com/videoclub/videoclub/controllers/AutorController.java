package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.AutorCrud;
import com.videoclub.videoclub.models.entities.Autor;

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
 * AutorController
 */
@RestController
@RequestMapping("/autores")
@CrossOrigin("*")
public class AutorController {

    AutorCrud autorCrud = new AutorCrud();

    @GetMapping("/{id}")
    public Autor getAutor(@PathVariable int id) throws SQLException { 
        return autorCrud.findByIdAutor(id);
    }

    @GetMapping
    public List<Autor> getAllAutor() throws SQLException {
        return autorCrud.findAllAutor();
    }

    @PostMapping
    public Integer saveAutor(@RequestBody Autor autor) throws SQLException {
        return autorCrud.saveAutor(autor);

    }
    @DeleteMapping("/{id}")
    public Integer deleteAutor(@PathVariable int id) throws SQLException {
        return autorCrud.deleteAutor(id);
    }

    @PutMapping("/{id}")
    public Integer editAutor(@PathVariable int id, @RequestBody Autor autor) throws SQLException {
        return autorCrud.updateAutor(id, autor);
    }
}