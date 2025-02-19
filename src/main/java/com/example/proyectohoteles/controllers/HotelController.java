package com.example.proyectohoteles.controllers;

import com.example.proyectohoteles.entities.Habitacion;
import com.example.proyectohoteles.entities.Hotel;
import com.example.proyectohoteles.service.HabitacionService;
import com.example.proyectohoteles.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
@Tag(name = "Hoteles y habitaciones", description = "Catalogo de hoteles y sus habitaciones")
public class HotelController {
    private final HotelService hotelService;
    private final HabitacionService habitacionService;

    public HotelController(HotelService hotelService, HabitacionService habitacionService) {this.hotelService = hotelService; this.habitacionService = habitacionService;}

    @GetMapping("/")
    @Operation(summary = "Obtener todos los hoteles", description = "Obtiene una lista de todos los hoteles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron hoteles")
    })
    public ResponseEntity<List<Hotel>> findAllHoteles(){
        return ResponseEntity.ok(hotelService.findAllHoteles());
    }

    @GetMapping("localidad/{localidad}")
    public ResponseEntity<List<Hotel>> getHotelesLocalidad(@PathVariable String localidad) {
        return ResponseEntity.ok(hotelService.findHotelesByLocalidad(localidad));
    }

    @GetMapping("categoria/{categoria}")
    public ResponseEntity<List<Hotel>> getHotelesCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(hotelService.findHotelesByCategoria(categoria));
    }

    @GetMapping("/{id_hotel}/habitaciones")
    public ResponseEntity<List<Habitacion>> buscarHabitaciones(
            @PathVariable int id_hotel,
            @RequestParam(required = false) Habitacion.Tamano tamano,
            @RequestParam(required = false) Double precio_min,
            @RequestParam(required = false) Double precio_max) {
        List<Habitacion> habitaciones = habitacionService.buscarHabitaciones(id_hotel, tamano, precio_min, precio_max);
        return habitaciones.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(habitaciones);
    }


    //darle seguridad a esto
    @PostMapping("guardarHotel")
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
        hotelService.guardarHotel(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("guardarHabitacion")
    public ResponseEntity<?> createHabitacion(@RequestBody Habitacion habitacion) {
        habitacionService.guardarHabitacion(habitacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
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

    @DeleteMapping("/borrarHabitacion/{id}")
    public void borrarHabitacion(@PathVariable int id){
        habitacionService.borrarHabitacion(id);
    }
}