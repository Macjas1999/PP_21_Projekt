package com.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<com.entities.Aircraft, Integer> {
    @Query("select ac, count(ac) from Aircraft ac where ac.id = ?1")
    Integer checkExistance(Integer id);

}
