package com.example.proyectohoteles.controllers;

import com.example.proyectohoteles.entities.Hotel;
import com.example.proyectohoteles.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public List<Hotel> getAllHoteles() {
        try {
            return hotelService.findAllHoteles();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los agricultores", e);
        }
    }

    @GetMapping("{localidad}")
    public ResponseEntity<List<Hotel>> getHoteles(@PathVariable String localidad) {
        return ResponseEntity.ok(hotelService.findHotelesByLocalidad(localidad));
    }

    @PostMapping("guardar")
    public ResponseEntity<?> createAgricultor(@RequestBody Hotel hotel) {
        hotelService.guardarHotel(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
