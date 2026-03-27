package com.peliculas.gestor_pelis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peliculas.gestor_pelis.service.servicePelis;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/peliculas")
public class controllerPelis {

    private final servicePelis service;

    public controllerPelis(servicePelis service){
        this.service = service;
    }

    //buscar todo
    @GetMapping("/listar")
    public String buscarTodo() {
        return service.buscarTodo();
    }

    //buscar por nombre
    @GetMapping("/buscar/{nombre}")
    public String buscarPorNombre(@PathVariable String nombre) {
        return service.buscarNombre(nombre);
    }
    

    //agregar pelis
    @PostMapping("/agregar")
    public String agregar(@RequestBody Map<String, String> body) {

        String nombre = body.get("nombre");
        return service.agregar(nombre);
        
    }

    //ELiminar pelis
    @DeleteMapping("/borrar/{nombre}")
    public String borrar(@PathVariable String nombre){
        return service.eliminar(nombre);
    }

    //Modificar pelis
    @PutMapping("/modificar")
    public String modificar(@RequestBody Map<String, String> Body) {
        String viejo = Body.get("viejo");
        String nuevoNombre = Body.get("nuevoNombre");

        return service.modificar(viejo, nuevoNombre);
    }
    
    

}
