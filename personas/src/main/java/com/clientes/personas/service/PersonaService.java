package com.clientes.personas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientes.personas.model.Pelicula;
import com.clientes.personas.model.Persona;
import com.clientes.personas.repository.PersonaRepository;

@Service
public class PersonaService {

    //Repo para crear la BD
    private final PersonaRepository repo;

    //constructor para inyectar el repo
    public PersonaService(PersonaRepository repo){
        this.repo = repo;
    }

    //crear persona
    public Persona guardarPersona(Persona persona){
        return repo.save(persona);
    }

    //listar personas
    public List<Persona> listarPersonas(){
        return repo.findAll();
    }

    //comunicacion con microservicio Peliculas
    public List<Pelicula> obtenerPeliculas(Integer id) {
        
        //buscar persona
        Optional<Persona> personaOpt = repo.findById(id);
        
        //sino existe devuelve una lista vacía
        if (personaOpt.isEmpty()) {
            return new ArrayList<>();
        }
        Persona persona = personaOpt.get();

        //lista donde se guardan las peliculas completas
        List<Pelicula> peliculas = new ArrayList<>();

        //cliente HTTP para llamar al microservicio
        RestTemplate restTemplate = new RestTemplate();

        //recorrer ids de peliculas favoritas
        for(Integer peliculaId : persona.getPeliculasFavoritas()){

            //URL de microservicio peliculas
            String url = "http://localhost:8080/peliculas/buscarId/" + peliculaId;

            //llamada HTTP para obtener pelicula
            Pelicula pelicula = restTemplate.getForObject(url, Pelicula.class);

            //agregar pelicula
            peliculas.add(pelicula);
        }
        return peliculas;
    }

}
