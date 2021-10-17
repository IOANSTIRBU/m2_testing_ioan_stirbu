package com.example.m2_testing_ioan_stirbu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nave {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double dimension;
    private Double precio;

    public Nave() {
    }


    public Nave(Long id, String nombre, Double dimension, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.dimension = dimension;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDimension() {
        return dimension;
    }

    public void setDimension(Double dimension) {
        this.dimension = dimension;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dimension=" + dimension +
                ", precio=" + precio +
                '}' + "\n" ;
    }
}
