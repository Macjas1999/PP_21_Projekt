package services;

import hibernate.model.Airport;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface AirportService {
    Airport saveAirport(Airport airport);

    Optional<Airport> getAirportById(Integer id);

    void deleteAirport(Integer id);

    Iterable<Airport> listAllAirports();

    Boolean checkExistance(Integer id);
}
