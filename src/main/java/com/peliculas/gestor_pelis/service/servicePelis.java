package com.peliculas.gestor_pelis.service;

import org.springframework.stereotype.Service;

import com.peliculas.gestor_pelis.repository.repositoryPelis;

@Service
public class servicePelis {

    //1. No se pueden agregar películas repetidas. -----
    //2. No se puede eliminar una película que no exista.
    //3. No se puede modificar una película inexistente.
    //4. La búsqueda debe devolver un mensaje claro indicando si existe o no ----
    //5. El nombre de la película no puede ser vacío ni nulo ----

    private final repositoryPelis repo;

    public servicePelis(repositoryPelis repo){
        this.repo = repo;
    }

    //Agregar peliculas a la lista
    public String agregar(String nombre){
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Pelicula debe poseer nombre";
        }
        if (repo.buscarPorNombre(nombre) != null) {
            return "Pelicula existente";
        }
        repo.agregar(nombre);
        return "Pelicula agregada";
    }

    //listar peliculas
    public String buscarTodo(){
        if (repo.listar().isEmpty()) {
            return "Repertorio de peliculas vacio";
        }
        return "Repertorio: "+ repo.listar().toString();
    }

    //listar por nombre
    public String buscarNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Pelicula debe poseer nombre";
        }
        if (repo.buscarPorNombre(nombre) != null) {
            return "Pelicula: " + repo.buscarPorNombre(nombre);
        }
        return "No existe";
    }

    //eliminar pelicula
    public String eliminar(String nombre){
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Pelicula debe poseer nombre";
        }
        if (repo.buscarPorNombre(nombre) == null) {
            return "Pelicula no existe";
        }
        repo.eliminar(nombre);
        return "pelicula eliminada";
    }

    //modificar pelicula
    public String modificar(String viejo, String nuevoNombre){
        if (viejo == null || viejo.trim().isEmpty()) {
            return "Pelicula debe poseer nombre";
        }
        if (repo.buscarPorNombre(viejo) != null) {
            repo.modificar(viejo, nuevoNombre);
            return "Pelicula modificada, antiguo nombre: " + viejo + " nuevo nombre: " + nuevoNombre;
        }
        return "Pelicula no encontrada";
    }

}
