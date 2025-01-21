package com.example.proyectohoteles.service;

import com.example.proyectohoteles.entities.Habitacion;
import com.example.proyectohoteles.repository.HabitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;
    public HabitacionService(HabitacionRepository habitacionRepository) {this.habitacionRepository = habitacionRepository;}

    public List<Habitacion> findAllHabitaciones(){
        return habitacionRepository.findAll();
    }

    public Habitacion findHabitacionById(int id){
        return habitacionRepository.findHabitacionById(id);
    }

    public List<Habitacion> findHabitacionesByHotel(int hotel_id){
        return habitacionRepository.findHabitacionesByHotel(hotel_id);
    }

    public List<Habitacion> findHabitacionesByLocalidad(String localidad){
        return habitacionRepository.findHabitacionesByLocalidad(localidad);
    }

    @Transactional
    public void ocuparHabitacion (int id){
        habitacionRepository.ocuparHabitacion(id);
    }

    @Transactional
    public void liberarHabitacion (int id){habitacionRepository.liberarHabitacion(id);
    }
}
