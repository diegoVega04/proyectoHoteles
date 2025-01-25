package com.example.proyectohoteles.service;

import com.example.proyectohoteles.entities.Hotel;
import com.example.proyectohoteles.repository.HotelRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findAllHoteles(){return hotelRepository.findAll();}

    public List<Hotel> findHotelesByLocalidad (String localidad) {
        return hotelRepository.findHotelesByLocalidad(localidad);
    }

    public List<Hotel> findHotelesByCategoria (String categoria) {
        return hotelRepository.findHotelesByCategoria(categoria);
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
