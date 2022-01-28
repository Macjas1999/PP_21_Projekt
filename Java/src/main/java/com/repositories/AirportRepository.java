package com.repositories;

import com.entities.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Integer> {
    @Query("select ap, count(ap) from Airport ap where ap.id = ?1")
    Integer checkExistance(Integer id);
}
