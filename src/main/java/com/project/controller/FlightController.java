package com.project.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.exception.RecordAlreadyPresentException;
import com.project.exception.RecordNotFoundException;
import com.project.entities.Flight;
import com.project.service.FlightService;


@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/airline/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	@GetMapping("/airline/getAllFlight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/airline/viewFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/airline/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
	}

	@DeleteMapping("/airline/deleteFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeFlight(@PathVariable("id") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
	}
}

