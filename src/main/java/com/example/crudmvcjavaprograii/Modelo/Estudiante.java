package com.example.crudmvcjavaprograii.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estudiante {
    private int id;
    private String carnet;
    private String nombre;
    private String apellido;
    private int edad;
    private Sede sede;
}
