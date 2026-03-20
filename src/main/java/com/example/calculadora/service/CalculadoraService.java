package com.example.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    //fun suma
    public double suma(double a, double b) {
        return a + b;
    }

    //fun resta
    public double resta(double a, double b) {
        return a - b;
    }

    //fun multiplicar
    public double multiplicar(double a, double b) {
        return a * b;
    }

    //fun dividir
    public double dividir(double a, double b) {
        return a / b;
    }
}
