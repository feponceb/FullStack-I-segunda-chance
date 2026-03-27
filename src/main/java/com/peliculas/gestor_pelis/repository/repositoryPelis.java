package com.peliculas.gestor_pelis.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class repositoryPelis {

    //La lista
    private List<String> peliculas = new ArrayList<>();

    public repositoryPelis() {
        // Usamos .add() para cargar datos de prueba
        peliculas.add("Inception");
        peliculas.add("The Matrix");
        peliculas.add("Interstellar");
        peliculas.add("Pulp Fiction");
        peliculas.add("Parasite");
    }

    //agregar
    public void agregar(String nombre){
        peliculas.add(nombre);
    }

    //Listar
    public List<String> listar(){
        return peliculas;
    }

    //busqueda por nombre
    public String buscarPorNombre(String nombre){
        if (peliculas.contains(nombre)) {
            return nombre;
        }
        return null;
    }   

    //Eliminar
    public void eliminar(String nombre){
        peliculas.remove(nombre);
    }

    //modificar
    public void modificar(String viejo, String nuevoNombre){
        int index = peliculas.indexOf(viejo);
        if (index != -1) {
            peliculas.set(index, nuevoNombre);
        }
    }
}
