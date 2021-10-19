package com.project.service;

import java.math.BigInteger;
import com.project.exception.RecordNotFoundException;
import com.project.exception.ScheduledFlightNotFoundException;
import com.project.entities.ScheduleFlight;

public interface ScheduleFlightService {
	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight);
	public ScheduleFlight modifyScheduledFlight(ScheduleFlight scheduledFlight);
	public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;
	public Iterable<ScheduleFlight> viewAllScheduledFlights();
	public ScheduleFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	

}