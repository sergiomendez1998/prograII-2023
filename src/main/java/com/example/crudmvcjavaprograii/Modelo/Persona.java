package com.example.crudmvcjavaprograii.Modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Persona {

    private int id;
    private String dpi;
    private String nom;

    private boolean activo;

    private Genero genero;

    public Persona(String dpi, String nom) {
        this.dpi = dpi;
        this.nom = nom;
    }
}
