package com.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.entities.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport, String> {

}
