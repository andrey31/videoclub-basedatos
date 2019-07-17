package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.CantonCrud;
import com.videoclub.videoclub.models.entities.Canton;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CantonController
 */
@RestController
@RequestMapping("/cantones")
@CrossOrigin("*")
public class CantonController {

    CantonCrud cantonCrud = new CantonCrud();

    @GetMapping
    public List<Canton> getAllDistrito() throws SQLException {
        return cantonCrud.findAllCantones();
    }
    
}