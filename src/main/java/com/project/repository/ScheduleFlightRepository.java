package com.project.repository;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.entities.ScheduleFlight;

@Repository
public interface ScheduleFlightRepository extends CrudRepository<ScheduleFlight, BigInteger>{

}