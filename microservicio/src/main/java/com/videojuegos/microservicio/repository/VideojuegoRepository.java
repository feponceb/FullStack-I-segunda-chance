package com.videojuegos.microservicio.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class VideojuegoRepository {

    private List<String> juegos = new ArrayList<>();

    public VideojuegoRepository() {
        juegos.add("FIFA");
        juegos.add("Minecraft");
        juegos.add("Mario Kart");
        juegos.add("Mortal Kombat");
    }

    public List<String> obtenerJuegos(){
        return juegos;
    }
}
