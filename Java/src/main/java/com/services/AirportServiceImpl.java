package com.services;

import entities.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AirportRepository;
import services.AirportService;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Iterable<Airport> listAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getAirportById(Integer id) {
        return airportRepository.findById(id);
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Integer id) {
        airportRepository.deleteById(id);
    }

    @Override
    public Boolean checkExistance(Integer id) {
        if (airportRepository.checkExistance(id) > 0)
            return true;
        else
            return false;
    }
}
