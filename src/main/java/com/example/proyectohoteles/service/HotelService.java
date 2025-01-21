package com.example.proyectohoteles.service;

import com.example.proyectohoteles.entities.Hotel;
import com.example.proyectohoteles.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findHotelesByLocalidad (String localidad) {
        return hotelRepository.findHotelesByLocalidad(localidad);
    }

    public List<Hotel>findAllHoteles() {
        return hotelRepository.findAll();
    }

    public Hotel guardarHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Boolean borrarHotel(int id) {
        try {
            if (hotelRepository.existsById(id)) {
                hotelRepository.deleteById(id);
                return true;
            } else {return false;}
        } catch (Exception e) {
            return false;
        }
    }
}
