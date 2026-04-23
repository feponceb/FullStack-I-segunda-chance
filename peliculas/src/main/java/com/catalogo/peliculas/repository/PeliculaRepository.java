package com.catalogo.peliculas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.peliculas.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{

    //Optional se usa porque puede o no haber un titulo
    //IgnoreCase ignora mayusculas y minusculas
    Optional<Pelicula> findByTituloIgnoreCase(String titulo);

}
