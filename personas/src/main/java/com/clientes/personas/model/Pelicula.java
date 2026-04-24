package com.clientes.personas.model;


import lombok.Data;

//esto es para la comunicación con el microservicio de peliculas
//solo sirve como plantilla para recibir los datos del microservicio
//NO ES REAL
@Data
public class Pelicula {

    private Integer id;

    private String titulo;

    private String genero;

    private Integer anio;

    private String actorPrincipal;

}
