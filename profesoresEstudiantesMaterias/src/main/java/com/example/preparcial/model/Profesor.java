package com.example.preparcial.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Profesor extends Persona implements Serializable {
    private String progama;
    private String profesion;

    public Profesor(String codigo, String nombre, String apellido, String sexo, int edad, String correoElectronico, String telefono, String progama, String profesion) {
        super(codigo, nombre, apellido, sexo, edad, correoElectronico, telefono);
        this.progama = progama;
        this.profesion = profesion;
    }

    public Profesor(String progama, String profesion) {
        this.progama = progama;
        this.profesion = profesion;
    }

    public Profesor() {
    }

    public String getProgama() {
        return progama;
    }

    public void setProgama(String progama) {
        this.progama = progama;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}