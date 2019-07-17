package com.videoclub.videoclub.controllers;

import java.sql.SQLException;
import java.util.List;

import com.videoclub.videoclub.models.ClienteCrud;
import com.videoclub.videoclub.models.entities.Cliente;

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
 * ClienteController
 */
@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    ClienteCrud ClienteCrud = new ClienteCrud();

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable int id) throws SQLException { 
        return ClienteCrud.findByIdCliente(id);
    }

    @GetMapping
    public List<Cliente> getAllCliente() throws SQLException {
        return ClienteCrud.findAllCliente();
    }

    @PostMapping
    public Integer saveCliente(@RequestBody Cliente cliente) throws SQLException {
        return ClienteCrud.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public Integer deleteCliente(@PathVariable int id) throws SQLException {
        return ClienteCrud.deleteCliente(id);
    }

    @PutMapping("/{id}")
    public Integer editCliente(@PathVariable int id, @RequestBody Cliente cliente) throws SQLException {
        return ClienteCrud.updateCliente(id, cliente);
    }
}