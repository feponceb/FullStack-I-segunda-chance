package com.example.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Data permite facilitar el crear los getter y setters
//ToString y entre otras funciones más.
//Los demas generan automaticamente los
//constructores vacios y completos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion; //posible date?
    private String autor;

}
