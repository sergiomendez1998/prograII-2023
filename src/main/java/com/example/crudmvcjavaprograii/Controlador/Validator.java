package com.example.crudmvcjavaprograii.Controlador;

import com.example.crudmvcjavaprograii.Modelo.Persona;

import java.util.HashMap;
import java.util.Map;

public class Validator {
   public static Map<String, String> errors = new HashMap<>();

    public static boolean hasErrors() {
        return !errors.isEmpty();
    }

    public static void clearErrors() {
        errors.clear();
    }

    public  void  validate(Persona persona) {
         clearErrors();
        if (persona.getNom().isEmpty()) {
            addError("nombre", "El nombre es requerido");
        }

        if(persona.getNom().length() > 20) {
            addError("nombre", "El nombre no puede tener mas de 20 caracteres");
        }

        if (persona.getDpi().isEmpty()) {
            addError("dpi", "El DPI es requerido");
        }

        if (persona.getGenero() == null) {
            addError("genero", "El genero es requerido");
        }

        if (!validarDPI(persona.getDpi())) {
            addError("dpi", "dpi solo puede contener numeros");
        }
    }

    public void addError(String key, String value) {
        errors.put(key, value);
    }
    public static boolean validarDPI(String dpi) {
        return dpi != null && dpi.matches("\\d+");
    }
}
