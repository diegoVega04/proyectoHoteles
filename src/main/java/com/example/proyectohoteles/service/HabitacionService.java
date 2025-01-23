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

    public Habitacion guardarHabitacion(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    public Habitacion findHabitacionById(int id){
        return habitacionRepository.findHabitacionById(id);
    }

    public List<Habitacion> buscarHabitaciones(int id_hotel, Habitacion.Tamano tamano, Double precio_min, Double precio_max) {
        return habitacionRepository.buscarHabitaciones(id_hotel, tamano, precio_min, precio_max);
    }

    public void borrarHabitacion(int id) {
        habitacionRepository.deleteById(id);
    }

    @Transactional
    public void ocuparHabitacion (int id){
        habitacionRepository.ocuparHabitacion(id);
    }

    @Transactional
    public void liberarHabitacion (int id){habitacionRepository.liberarHabitacion(id);
    }
}
