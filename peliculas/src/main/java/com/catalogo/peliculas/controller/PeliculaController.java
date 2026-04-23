package com.catalogo.peliculas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.peliculas.model.Pelicula;
import com.catalogo.peliculas.service.PeliculaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService service;

    @GetMapping("/listar")
    public List<Pelicula> listar() {
        return service.listar();
    }

    //buscar por titulo endPoint
    @GetMapping("/buscar/{titulo}")
    public Optional<Pelicula> buscarTitulo(@PathVariable String titulo){        
        return service.buscarTitulo(titulo);
    }

    //buscar por id
    @GetMapping("/buscarId/{id}")
    public Optional<Pelicula> buscarId(@PathVariable Integer id){
        return service.buscarId(id);
    }

    //agregar peli
    @PostMapping("/agregar")
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula){
        return service.guardarPelicula(pelicula);
    }

    //no más
    @DeleteMapping("/Eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        Optional<Pelicula> pelicula = service.buscarId(id);

        if (pelicula.isPresent()) {
            service.eliminarPorId(id);
            return "Pelicula eliminada correctamente";
        } else {
            return "Pelicula no encontrada con id: " + id;
        }
    }

    //actualizar
    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @RequestBody Pelicula pelicula){

        Optional<Pelicula> existente = service.buscarId(id);

        if (existente.isPresent()) {
            service.actualizarPelicula(id, pelicula);
            return "Pelicula actualizada correctamente";
        } else {
            return "Pelicula no encontrada con id: " + id;
        }
    }

}
