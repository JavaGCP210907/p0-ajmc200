package com.revature.dao;

import com.revature.models.Passenger;

public interface PassengerDaoInterface {

	public void addPassenger(Passenger passenger); //Create passenger and add data (user input)
	public void removePassenger(int id); 
												 	 
}
