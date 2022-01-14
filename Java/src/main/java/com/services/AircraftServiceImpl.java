package com.services;

import com.entities.Aircraft;
import com.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Iterable<com.entities.Aircraft> listAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Override
    public Optional<com.entities.Aircraft> getAircraftById(Integer id) {
        return aircraftRepository.findById(id);
    }

    @Override
    public com.entities.Aircraft saveAircraft(Aircraft Aircraft) {
        return aircraftRepository.save(Aircraft);
    }

    @Override
    public void deleteAircraft(Integer id) {
        aircraftRepository.deleteById(id);
    }

    @Override
    public Boolean checkExistance(Integer id) {
        if (aircraftRepository.checkExistance(id) > 0)
            return true;
        else
            return false;
    }
}
