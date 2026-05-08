package com.clientes.personas.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.clientes.personas.dto.ErrorDTO;

import jakarta.servlet.http.HttpServletRequest;

//captura los errores de la app de manera global
//evita la realizacion de try catchs en el controller
@RestControllerAdvice
public class ManejadorErrores {

    //manejo de errores de validacion, la ejecucion de los @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //indica que se ejecuta de manera automatica al recibir la ejecucion de la validacion
    public ResponseEntity<ErrorDTO> manejarErroresValidacion(
        MethodArgumentNotValidException ex,     //tiene el detalle de los errores de validacion
        HttpServletRequest request              //permite obtener informacion del request
    ) {
        //mapa para almacenar los errores por campo
        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        //se crea el objeto con la info del error
        ErrorDTO errorDTO = new ErrorDTO(
            LocalDateTime.now(),
            400,
            "Error de validación",
            errores,
            request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(errorDTO);

    }

    //manejo de errores de BD
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> manejarErroresBaseDatos(
        DataIntegrityViolationException ex,
        HttpServletRequest request
    ) {
        ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(),
            400,
            "El email ya está registrado",
            null,
            request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(errorDTO);
    }

}
