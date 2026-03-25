package com.videojuegos.microservicio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.videojuegos.microservicio.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

    private final VideojuegoRepository repository;

    public VideojuegoService(VideojuegoRepository repository){
        this.repository = repository;
    }

    public List<String> Listar(){
        return repository.obtenerJuegos();
    }

    public void agregar(String name){
        repository.agregarJuego(name);
    }
}
