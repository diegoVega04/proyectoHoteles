package com.example.proyectohoteles.repository;

import com.example.proyectohoteles.entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitacionRepository  extends JpaRepository<Habitacion, Integer> {

    @Query("""
    SELECT h 
    FROM Habitacion h 
    WHERE h.hotel.id = :id_hotel
    AND (:tamano IS NULL OR h.tamano = :tamano)
    AND (:precio_min IS NULL OR h.precio_noche >= :precio_min)
    AND (:precio_max IS NULL OR h.precio_noche <= :precio_max)
    """)
    List<Habitacion> buscarHabitaciones(
            @Param("id_hotel") int id_hotel,
            @Param("tamano") Habitacion.Tamano tamano,
            @Param("precio_min") Double precio_min,
            @Param("precio_max") Double precio_max);

    @Query("SELECT a FROM Habitacion a WHERE a.id = :id")
    Habitacion findHabitacionById(int id);

    @Modifying
    @Query("UPDATE Habitacion a set a.ocupada = true WHERE a.id = :id")
    void ocuparHabitacion (int id);

    @Modifying
    @Query("UPDATE Habitacion a set a.ocupada = false WHERE a.id = :id")
    void liberarHabitacion (int id);
}
