package com.catalogo.peliculas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//permite definir configuraciones y beans en srping

import com.catalogo.peliculas.model.Pelicula;
import com.catalogo.peliculas.repository.PeliculaRepository;

@Configuration
public class DataLoader {

    @Bean //da prioridad para que se ejecute al correr la app
    CommandLineRunner init(PeliculaRepository repo){

        //inyección del repo automaticamente
        return args -> {
            //esto lee si el repo tiene o no peliculas
            if (repo.count() == 0) {
                repo.save(new Pelicula(null, "Gladiador", "Acción", 2000, "Russell Crowne"));
                repo.save(new Pelicula(null, "Men in Black", "Acción", 2005, "Will Smith"));
                repo.save(new Pelicula(null, "Avengers", "Acción", 2012, "Robert Downey Jr"));
                repo.save(new Pelicula(null, "Batman: El caballero de la noche", "Acción", 2008, "Christian algo"));
                repo.save(new Pelicula(null, "Interestellar", "Ciencia Ficción", 2014, "Mattwey McConaughey"));
            }
        };
    }

}
