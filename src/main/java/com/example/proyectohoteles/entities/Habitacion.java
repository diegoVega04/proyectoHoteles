package com.example.proyectohoteles.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "numero_habitacion")
    private int numero_habitacion;

    @Column(name = "tamano")
    @Enumerated(EnumType.STRING)
    private Tamano tamano;

    @Column(name = "precio_noche")
    private double precio_noche;

    @Column(name = "desayuno")
    private boolean desayuno;

    @Column(name = "ocupada")
    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @JsonBackReference
    private Hotel hotel;


    public Habitacion (){}
    public enum Tamano {
        una_persona,
        dos_personas,
        cuatro_personas
    }

    public int getId() {
        return id;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
