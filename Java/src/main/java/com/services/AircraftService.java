package com.services;

import com.entities.Aircraft;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface AircraftService {
    Aircraft saveAircraft(Aircraft aircraft);

    void deleteAircraft(Integer id);

    Optional<Aircraft> getAircraftById(Integer id);

    Iterable<Aircraft> listAllAircrafts();

    Boolean checkExistance(Integer id);
}
