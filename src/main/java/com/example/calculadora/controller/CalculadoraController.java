package com.example.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculadora.service.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService CalculadoraService;

    @GetMapping("/suma")
    public double suma(@RequestParam double a, @RequestParam double b) {
        return CalculadoraService.suma(a, b);
    }

    @GetMapping("/resta")
    public double resta(@RequestParam double a, @RequestParam double b) {
        return CalculadoraService.resta(a, b);
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        return CalculadoraService.dividir(a, b);
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return CalculadoraService.multiplicar(a, b);
    }

}
