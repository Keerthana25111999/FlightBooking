package com.project.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.ScheduleRepository;
import com.project.repository.ScheduleFlightRepository;
import com.project.exception.RecordNotFoundException;
import com.project.exception.ScheduledFlightNotFoundException;
import com.project.entities.ScheduleFlight;

@Service
public class ScheduleFlightServiceImpl implements ScheduleFlightService {
	@Autowired
	ScheduleFlightRepository repository;

	@Autowired
	ScheduleRepository scheduleRepository;

	@Autowired
	BookingService bookingService;

	
	@Override
	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight) {
		return repository.save(scheduledFlight);
	}

	@Override
	public ScheduleFlight modifyScheduledFlight(ScheduleFlight scheduleFlight) {
		return repository.save(scheduleFlight);
	}

	@Override
	public String removeScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
		if (flightId == null)
			throw new RecordNotFoundException("Enter flight Id");
		Optional<ScheduleFlight> scheduleFlight = repository.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new RecordNotFoundException("Enter a valid Flight Id");
		else {
			repository.deleteById(flightId);
		}
		return "Scheduled flight with ID " + flightId + " is deleted";
	}

	
	@Override
	public Iterable<ScheduleFlight> viewAllScheduledFlights() {
		return repository.findAll();
	}

	@Override
	public ScheduleFlight viewScheduledFlight(BigInteger flightId) throws ScheduledFlightNotFoundException {
		if (flightId == null)
			throw new ScheduledFlightNotFoundException("Enter flight Id");
		Optional<ScheduleFlight> scheduleFlight = repository.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
		else
			return scheduleFlight.get();
	}

}