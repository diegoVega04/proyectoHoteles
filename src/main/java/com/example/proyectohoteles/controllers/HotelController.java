package com.example.proyectohoteles.controllers;

import com.example.proyectohoteles.entities.Habitacion;
import com.example.proyectohoteles.entities.Hotel;
import com.example.proyectohoteles.service.HabitacionService;
import com.example.proyectohoteles.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class Controller {
    private final HotelService hotelService;
    private final HabitacionService habitacionService;

    public Controller(HotelService hotelService, HabitacionService habitacionService) {
        this.hotelService = hotelService;
        this.habitacionService = habitacionService;
    }

    @GetMapping("/")
    public List<Hotel> getAllHoteles() {
        try {
            return hotelService.findAllHoteles();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los hoteles", e);
        }
    }

    @GetMapping("{localidad}")
    public ResponseEntity<List<Hotel>> getHoteles(@PathVariable String localidad) {
        return ResponseEntity.ok(hotelService.findHotelesByLocalidad(localidad));
    }

    @PostMapping("guardar")
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
        hotelService.guardarHotel(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> borrarHotel(@PathVariable int id) {
        boolean resultado = hotelService.borrarHotel(id);
        if (resultado) {
            return ResponseEntity.ok("Hotel eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hotel no encontrado");
        }
    }

    @GetMapping("/{hotel_id}/habitaciones")
    public ResponseEntity<List<Habitacion>> habitaciones(@PathVariable int hotel_id) {
        return habitacionService.findHabitacionesByHotel(hotel_id);
    }
}