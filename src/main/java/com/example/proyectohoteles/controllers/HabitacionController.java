package com.example.proyectohoteles.controllers;

import com.example.proyectohoteles.entities.Habitacion;
import com.example.proyectohoteles.service.HabitacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {
    private final HabitacionService habitacionService;

    public HabitacionController (HabitacionService habitacionService) {this.habitacionService = habitacionService;}

    @GetMapping("/")
    public ResponseEntity<List<Habitacion>> habitaciones(){
        return ResponseEntity.ok(habitacionService.findAllHabitaciones());
    }

    @GetMapping("/{hotel_id}")
    public ResponseEntity<List<Habitacion>> habitacionesHotel(@PathVariable int hotel_id) {
        return ResponseEntity.ok(habitacionService.findHabitacionesByHotel(hotel_id));
    }

    @GetMapping("habitacion/{id}")
    public ResponseEntity<Habitacion> habitacion(@PathVariable int id) {
        return ResponseEntity.ok(habitacionService.findHabitacionById(id));
    }

    @GetMapping("/ciudad/{localidad}")
    public ResponseEntity<List<Habitacion>> habitacionesLocalidad(@PathVariable String localidad) {
        return ResponseEntity.ok(habitacionService.findHabitacionesByLocalidad(localidad));
    }

    @PutMapping("/ocupar/{id}")
    public Habitacion ocuparHabitacion(@PathVariable int id){
        habitacionService.ocuparHabitacion(id);
        return habitacionService.findHabitacionById(id);
    }

    @PutMapping("/liberar/{id}")
    public Habitacion liberarHabitacion(@PathVariable int id){
        habitacionService.liberarHabitacion(id);
        return habitacionService.findHabitacionById(id);
    }

}