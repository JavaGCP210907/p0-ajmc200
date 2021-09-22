package com.revature.dao;

import java.util.List;

import com.revature.models.Flight;

public interface FlightDaoInterface {

	// Display all flights and associated data to user
	public List<Flight> getFlight();
	
	// Display Flights based on their destination, user-input = select from flight where "destination"...
	public List<Flight> getFlightByDestination(String destination); 
}
