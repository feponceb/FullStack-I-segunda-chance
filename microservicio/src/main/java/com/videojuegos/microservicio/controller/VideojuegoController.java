package com.videojuegos.microservicio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videojuegos.microservicio.service.VideojuegoService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/juegos")
public class VideojuegoController {

    private final VideojuegoService Service;

    public VideojuegoController(VideojuegoService Service){
        this.Service = Service;
    }

    @GetMapping("listar")
    public List<String> Listar() {
        return Service.Listar();
    }

    @PostMapping("agregar")
    public String agregarJuego(@RequestBody java.util.Map<String, String> body) {        
        String name = body.get("name");
        Service.agregar(name);
        return "Juego Agregado";
    }

    @DeleteMapping("/eliminar/{name}")
    public String eliminar(@PathVariable String name){
        Service.eliminar(name);
        return "Juego eliminado :(";
    }
    
    @PutMapping("/modificar")
    public String modificar(@RequestBody Map<String, String> body) {
        String old = body.get("old");
        String newName = body.get("newName");

        Service.actualizar(old, newName);
        return "Juego Modificado";
    }

    @GetMapping("/buscar/{name}")
    public String buscarPorNombre(@PathVariable String name) {
        return Service.buscarPorNombre(name);
    }
    

}
