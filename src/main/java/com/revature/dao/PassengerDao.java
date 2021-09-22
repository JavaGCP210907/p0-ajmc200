package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.revature.models.Passenger;
import com.revature.utils.ConnectionUtil;

public class PassengerDao implements PassengerDaoInterface{
	@Override
	public void addPassenger(Passenger passenger) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//This is my quick/dirty solution to get the current date in appropriate format 
			//Surely there's a more elegant solution... feel free to find one (or just don't use dates in your P0)
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this will format my dates to be SQL acceptable 
			Date date = new Date(); //from java.util - we will convert it into a java.sql Date 
			String currentDate = dateFormat.format(date); //this will format our date based on the format we gave above
			
			//the rest should proceed as normal
			
			//you can line break a sql statement in Java by concatenation (not the +)
			String sql = "insert into passenger (fname, lname, fldeparture, flight_id)" +
						 "values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, passenger.getFname());
			ps.setString(2, passenger.getLname());
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, passenger.getFlight_id());
			
			ps.executeUpdate(); //for anything that is NOT a SELECT statement, we use executeUpdate();
			
			//send confirmation to the console if successful
			System.out.println("Passenger " + passenger.getFname() + " created. Welcome aboard!");
			
		} catch (SQLException e) {
			System.out.println("add passenger failed :(");
			e.printStackTrace();
		}
	}
	
	@Override
	public void removePassenger(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from passenger where passenger_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Get outta here Passenger number: " + id +", No Refunds!");
			
		} catch (SQLException e) {
			System.out.println("you can't fire me I QUIT");
			e.printStackTrace();
		}
		
	}

}
