package com.example.proyectohoteles.repository;

import com.example.proyectohoteles.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query("SELECT a FROM Hotel a WHERE a.localidad = :localidad")
    List<Hotel> findHotelesByLocalidad(String localidad);

    @Query("SELECT a FROM Hotel a WHERE a.categoria = :categoria")
    List<Hotel> findHotelesByCategoria(String categoria);
}
