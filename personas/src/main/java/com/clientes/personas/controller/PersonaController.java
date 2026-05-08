package com.clientes.personas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.personas.model.Pelicula;
import com.clientes.personas.model.Persona;
import com.clientes.personas.service.PersonaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service){
        this.service = service;
    }

    //agregar persona
    //update de "agregar" utiliznado ResponseEntity
    @PostMapping("/agregar")
    public ResponseEntity<Persona> crearPersona(@Valid @RequestBody Persona persona){

        //guardar la persona en la BD
        Persona nueva = service.guardarPersona(persona);

        //Retorna codigo de creacion correcta 201 junto al objeto que se creó
        return ResponseEntity.status(201).body(nueva);
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
