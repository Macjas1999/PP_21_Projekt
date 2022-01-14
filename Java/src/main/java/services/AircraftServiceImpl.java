package services;

import hibernate.model.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AircraftRepository;

import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Iterable<Aircraft> listAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Override
    public Optional<Aircraft> getAircraftById(Integer id) {
        return aircraftRepository.findById(id);
    }

    @Override
    public Aircraft saveAircraft(Aircraft Aircraft) {
        return aircraftRepository.save(Aircraft);
    }

    @Override
    public void deleteAircraft(Integer id) {
        aircraftRepository.deleteById(id);
    }
}
