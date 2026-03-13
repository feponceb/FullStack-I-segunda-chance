package com.test.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class llamada {

    @GetMapping("llamada")
    public String Llamada() {
        return "Chimichangas";
    }
    
}
