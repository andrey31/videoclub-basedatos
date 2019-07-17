package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.CajeroCRUD;
import com.videoclub.videoclub.models.entities.Cajero;

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
 * CajeroContoller
 */
@RestController
@RequestMapping("/cajeros")
@CrossOrigin("*")
public class CajeroController {

    CajeroCRUD cajeroCrud = new CajeroCRUD();
    
    @GetMapping("/{id}")
    public Cajero getCajero(@PathVariable int id) throws SQLException { 
        return cajeroCrud.findByIdCajeros(id);
    }

    @GetMapping
    public List<Cajero> getAllCajero() throws SQLException {
        return cajeroCrud.findAllCajero();
    }

    @PostMapping
    public Integer saveCajero(@RequestBody Cajero cajero) throws SQLException {
        return cajeroCrud.saveCajero(cajero);
    }

    @DeleteMapping("/{id}")
    public Integer deleteCajero(@PathVariable int id) throws SQLException {
        return cajeroCrud.deleteCajeros(id);
    }

    @PutMapping("/{id}")
    public Integer editCajero(@PathVariable int id, @RequestBody Cajero cajero) throws SQLException {
        return cajeroCrud.updateCajero(id, cajero);
    }
}