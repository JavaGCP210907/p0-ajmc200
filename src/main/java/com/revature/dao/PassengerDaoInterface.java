package com.revature.dao;

import java.util.List;

import com.revature.models.Flight;
import com.revature.models.Passenger;

public interface PassengerDaoInterface {

	public void addPassenger(Passenger passenger); //Create passenger and add data (user input)
	public void removePassenger(int id); 
	public void updateDate(int passengerId, String dateInput);
	public List<Passenger> getPassenger();
}
