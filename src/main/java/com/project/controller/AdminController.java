package com.project.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.RecordNotFoundException;
import com.project.exception.ScheduledFlightNotFoundException;
import com.project.entities.ScheduleFlight;
import com.project.service.ScheduleFlightService;

@RestController
@RequestMapping("/flight")
public class AdminController {
	@Autowired
	ScheduleFlightService scheduleFlightService;

	
	@PostMapping("/scheduledFlight/add")
	public ScheduleFlight addSF(@RequestBody ScheduleFlight scheduledFlight){
	  return scheduleFlightService.addScheduledFlight(scheduledFlight);
	}
		
	@PutMapping("/scheduledFlight//modify")
	public ScheduleFlight modifyScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) {
	
		return scheduleFlightService.modifyScheduledFlight(scheduleFlight);
	}
	
	@DeleteMapping("/scheduledFlight/delete")
	public String deleteSF(@RequestParam BigInteger flightId) throws RecordNotFoundException {
		return scheduleFlightService.removeScheduledFlight(flightId);
	}

	@GetMapping("/scheduledFlight/search")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<ScheduleFlight> viewSF(@RequestParam BigInteger flightId) throws ScheduledFlightNotFoundException {
		ScheduleFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
		if (searchSFlight == null) {
			return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ScheduleFlight>(searchSFlight, HttpStatus.OK);
		}
	}

	@GetMapping("/scheduledFlight/viewAll")
	public Iterable<ScheduleFlight> viewAllSF() {
		return scheduleFlightService.viewAllScheduledFlights();
	}
	
}

