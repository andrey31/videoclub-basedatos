package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.DistritoCrud;
import com.videoclub.videoclub.models.entities.Distrito;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Distritos
 */
@RestController
@RequestMapping("/distritos")
@CrossOrigin("*")
public class DistritoController {

    DistritoCrud distritoCrud = new DistritoCrud();
    
    @GetMapping("/{id}")
    public Distrito getDistrito(@PathVariable int id) throws SQLException { 
        return distritoCrud.findByIdDistrito(id);
    }

    @GetMapping
    public List<Distrito> getAllDistrito() throws SQLException {
        return distritoCrud.findAllDistrito();
    }

    @PostMapping
    public Integer saveDistrito(@RequestBody Distrito distrito) throws SQLException {
        return distritoCrud.saveDistrito(distrito);
    }

    @DeleteMapping("/{id}")
    public Integer deleteDistrito(@PathVariable int id) throws SQLException {
        return distritoCrud.deleteDistrito(id);
    }

  /*   @PutMapping("/{id}")
    public Integer editDistrito(@PathVariable int id, @RequestBody Distrito distrito) throws SQLException {
        return distritoCrud.updateDistrito(id, distrito);
    } */
}