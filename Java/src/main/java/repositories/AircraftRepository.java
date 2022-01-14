package repositories;

import hibernate.model.Aircraft;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Integer>
{
}
