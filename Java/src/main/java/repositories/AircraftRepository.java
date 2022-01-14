package repositories;

import hibernate.model.Aircraft;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Integer> {
    @Query("select count(*) from Aircraft ac where ac.id = ?1")
    Integer checkExistance(Integer id);

}
