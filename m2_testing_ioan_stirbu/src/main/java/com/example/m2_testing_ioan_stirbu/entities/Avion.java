package com.example.m2_testing_ioan_stirbu.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double carga;
    private Integer pasajeros;
    private Double alcance;

    public Avion(){}

    public Avion(Long id,String nombre,Double carga, Integer pasajeros, Double alcance){
        this.id = id;
        this.nombre = nombre;
        this.carga = carga;
        this.pasajeros = pasajeros;
        this.alcance = alcance;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Integer getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Integer pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Double getAlcance() {
        return alcance;
    }

    public void setAlcance(Double alcance) {
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carga=" + carga +
                ", pasajeros=" + pasajeros +
                ", alcance=" + alcance +
                '}' + "\n";
    }
}
