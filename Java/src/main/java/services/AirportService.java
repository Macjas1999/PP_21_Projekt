package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AirportRepository;

@Service

public interface AirportService {
    @Autowired
    AirportRepository airportRepository;
}
