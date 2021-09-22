package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Flight;
import com.revature.utils.ConnectionUtil;

public class FlightDao implements FlightDaoInterface {

	@Override
	public List<Flight> getFlight() {
		
		try(Connection conn = ConnectionUtil.getConnection()) { //getConnection() comes from our ConnectionUtil Class
			
			ResultSet rs = null;
			String sql = "select * from flight";			
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			//All the code above makes a call to our database... Now we need to store the data in a List	
			//create an empty List to be filled with the data from the database
			List<Flight> flightList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				//Use the all args Constructor to create a new Employee object from each returned row...
				Flight e = new Flight(
						//we want to use rs.getXYZ for each column in the record
						rs.getInt("flight_id"),
						rs.getBoolean("international"),
						rs.getString("country_from"),
						rs.getString("state_from"),
						rs.getString("city_from"),
						rs.getString("country_to"),
						rs.getString("state_to"),
						rs.getString("city_to"),
						rs.getInt("availability"),
						rs.getDouble("price")
						);
				
				//and populate the ArrayList with each new Employee object
				flightList.add(e); //e is the new Employee object we created above
			}
			
			//when there are no more results in the ResultSet the while loop will break...
			//return the populated List of Employees
			return flightList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); //generic console message
			e.printStackTrace(); //stack trace so we actually know what went wrong
		}
		
		return null; //we add this after the try/catch so Java won't yell.
					 //(Since there is no guarantee the try with resources block will run)
	}
	
	@Override
	public List<Flight> getFlightByDestination(String destination) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			ResultSet rs = null;			
			String sql = "select * from flight where flight.country_to = ?";			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, destination); //insert the method's argument as the first (and only) variable in the query
			rs = ps.executeQuery();	
			
			List<Flight> flightList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				Flight e = new Flight( //create a new Employee Object from each returned row..
						rs.getInt("flight_id"),
						rs.getBoolean("international"),
						rs.getString("country_from"),
						rs.getString("state_from"),
						rs.getString("city_from"),
						rs.getString("country_to"),
						rs.getString("state_to"),
						rs.getString("city_to"),
						rs.getInt("availability"),
						rs.getDouble("price")
						);
				
				flightList.add(e); //and populate the ArrayList with each created Role Object
			}
			
			return flightList; //Finally, return the populated List of Roles.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
