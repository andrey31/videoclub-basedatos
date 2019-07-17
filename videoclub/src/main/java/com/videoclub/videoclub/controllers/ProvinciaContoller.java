package com.videoclub.videoclub.controllers;

import com.videoclub.videoclub.models.entities.Provincia;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.ProvinciaCrud;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProvinciaContoller
 */
@RestController
@RequestMapping("/provincias")
@CrossOrigin("*")
public class ProvinciaContoller {

    ProvinciaCrud provinciaCrud = new ProvinciaCrud();

    @GetMapping
    public List<Provincia> getAllProvincias() throws SQLException {
        return provinciaCrud.findAllProvincia();
    }
}