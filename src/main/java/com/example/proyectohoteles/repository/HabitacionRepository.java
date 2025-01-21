package com.example.proyectohoteles.repository;

import com.example.proyectohoteles.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitacionRepository  extends JpaRepository<Habitacion, Integer> {

    @Query("SELECT a FROM Habitacion a WHERE a.hotel.id = :hotel_id")
    List<Habitacion> findHabitacionesByHotel (int hotel_id);

    @Query("SELECT a FROM Habitacion a WHERE a.id = :id")
    Habitacion findHabitacionById(int id);

    @Query("SELECT a FROM Habitacion a WHERE a.hotel.localidad = :localidad")
    List<Habitacion> findHabitacionesByLocalidad (String localidad);

    @Modifying
    @Query("UPDATE Habitacion a set a.ocupada = true WHERE a.id = :id")
    void ocuparHabitacion (int id);

    @Modifying
    @Query("UPDATE Habitacion a set a.ocupada = false WHERE a.id = :id")
    void liberarHabitacion (int id);
}
