package com.catalogo.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.peliculas.model.Pelicula;
import com.catalogo.peliculas.repository.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repo;

    public List<Pelicula> listar(){
        return repo.findAll();
    }

    //buscar por titulo
    public Optional<Pelicula> buscarTitulo(String titulo){
        return repo.findByTituloIgnoreCase(titulo);
    }

    //buscar por id
    public Optional<Pelicula> buscarId(Integer id){
        return repo.findById(id);
    }

    //agregar pelicula
    public Pelicula guardarPelicula(Pelicula pelicula){
        return repo.save(pelicula);
    }

    //eli..
    public void eliminarPorId(Integer id){
        repo.deleteById(id);
    }

    //actualizar / modificar peli
    public Pelicula actualizarPelicula(Integer id, Pelicula pelicula){
        pelicula.setId(id);
        return repo.save(pelicula);
    }

}
