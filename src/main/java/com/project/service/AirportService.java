package com.project.service;

import org.springframework.http.ResponseEntity;

import com.project.entities.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();
	public Airport viewAirport(String airportCode);
	public ResponseEntity<Airport> addAirport(Airport airport);
	public Airport modifyAirport(Airport airport);
	public String removeAirport(String airportCode);
}
