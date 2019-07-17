package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.LenguajeCrud;
import com.videoclub.videoclub.models.entities.Lenguaje;

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
 * LenguajeController
 */
@RestController
@RequestMapping("/lenguajes")
@CrossOrigin("*")
public class LenguajeController {

    LenguajeCrud LenguajeCrud = new LenguajeCrud();

    @GetMapping("/{id}")
    public Lenguaje getLenguaje(@PathVariable int id) throws SQLException { 
        return LenguajeCrud.findByIdLenguaje(id);
    }

    @GetMapping
    public List<Lenguaje> getAllLenguaje() throws SQLException {
        return LenguajeCrud.findAllLenguaje();
    }

    @PostMapping
    public Integer saveLenguaje(@RequestBody Lenguaje lenguaje) throws SQLException {
        return LenguajeCrud.saveLenguaje(lenguaje);
    }

    @DeleteMapping("/{id}")
    public Integer deleteLenguaje(@PathVariable int id) throws SQLException {
        return LenguajeCrud.deleteLenguaje(id);
    }

    @PutMapping("/{id}")
    public Integer editLenguaje(@PathVariable int id, @RequestBody Lenguaje lenguaje) throws SQLException {
        return LenguajeCrud.updateLenguaje(id, lenguaje);
    }
}