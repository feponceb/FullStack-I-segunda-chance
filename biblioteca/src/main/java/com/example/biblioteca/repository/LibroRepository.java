package com.example.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Libro;

@Repository
public class LibroRepository {

    //Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //metodo que retora todo, un selectAll
    public List<Libro> obteneLibros() {
        return listaLibros;
    }

    //buscar libro por id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    //buscar libro por isbn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    //guardar libro y retornar libro
    public Libro guardar(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }

    

}
