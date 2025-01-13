package com.example.proyectohoteles.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Getter
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private int id;

    @Getter @Setter
    @Column(name = "numero_habitacion")
    private int numero_habitacion;

    @Getter @Setter
    @Column(name = "tamano")
    @Enumerated(EnumType.STRING)
    private Tamano tamano;

    @Getter @Setter
    @Column(name = "precio_noche")
    private double precio_noche;

    @Getter @Setter
    @Column(name = "desayuno")
    private boolean desayuno;

    @Getter @Setter
    @Column(name = "ocupada")
    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @JsonManagedReference
    private Hotel hotel;


    public Habitacion (){}
    public enum Tamano {
        UNA_PERSONA,
        DOS_PERSONAS,
        CUATRO_PERSONAS
    }
}
