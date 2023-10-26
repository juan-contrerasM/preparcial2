package com.example.preparcial.model;

import java.io.Serializable;

public class Materia implements Serializable {
    private String codigo;
    private String nombre;
    private String intensidadHoraria;
    private TipoMateria tipoMateria;

    public Materia(String codigo, String nombre, String intensidadHoraria, TipoMateria tipoMateria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.intensidadHoraria = intensidadHoraria;
        this.tipoMateria = tipoMateria;
    }

    public Materia() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(String intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    public TipoMateria getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(TipoMateria tipoMateria) {
        this.tipoMateria = tipoMateria;
    }
}