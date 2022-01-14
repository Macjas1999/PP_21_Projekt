package com.services;

import entities.Aircraft;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface AircraftService {
    Aircraft saveAircraft(Aircraft aircraft);

    Optional<Aircraft> getAircraftById(Integer id);

    void deleteAircraft(Integer id);

    Iterable<Aircraft> listAllAircrafts();

    Boolean checkExistance(Integer id);
}
