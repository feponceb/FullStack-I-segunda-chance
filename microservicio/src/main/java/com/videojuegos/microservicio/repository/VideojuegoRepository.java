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

    public void agregarJuego(String name){
        juegos.add(name);
    }

    public void eliminarJuego(String name){
        juegos.remove(name);
    }

    public void modificarJuego(String old, String newName){
        int index = juegos.indexOf(old);
        if (index != -1) {
            juegos.set(index, newName);
        }
    }

    public String buscarJuegoPorNombre(String name){
        if (juegos.contains(name)) {
            return name;
        }
        return "No tá ese juego :(";
    }
}
