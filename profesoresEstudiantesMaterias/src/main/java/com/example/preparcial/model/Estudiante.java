package com.example.preparcial.model;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {
    public Estudiante(String codigo, String nombre, String apellido, String sexo, int edad, String correoElectronico, String telefono) {
        super(codigo, nombre, apellido, sexo, edad, correoElectronico, telefono);
    }

    public Estudiante() {
    }
}
