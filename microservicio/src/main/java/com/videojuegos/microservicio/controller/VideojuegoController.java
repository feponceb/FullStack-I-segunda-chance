package com.videojuegos.microservicio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videojuegos.microservicio.service.VideojuegoService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    

}
