package com.project.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, BigInteger> {

}
