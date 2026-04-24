package com.clientes.personas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.personas.model.Pelicula;
import com.clientes.personas.model.Persona;
import com.clientes.personas.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service){
        this.service = service;
    }

    //agregar persona
    @PostMapping("/agregar")
    public Persona crearPersona(@RequestBody Persona persona){
        return service.guardarPersona(persona);
    }

    //listar personas
    @GetMapping("/listar")
    public List<Persona> listaPersonas(){
        return service.listarPersonas();
    }

    //endpoint para obtener peliculas
    @GetMapping("/{id}/peliculas")
    public List<Pelicula> obtenerPeliculas(@PathVariable Integer id){
        return service.obtenerPeliculas(id);
    }

}
