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
	
	@Override
	public List<Passenger> getPassenger() {
		
		try(Connection conn = ConnectionUtil.getConnection()) { //getConnection() comes from our ConnectionUtil Class
			
			ResultSet rs = null;
			String sql = "select * from passenger";			
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			//All the code above makes a call to our database... Now we need to store the data in a List	
			//create an empty List to be filled with the data from the database
			List<Passenger> passengerList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				//Use the all args Constructor to create a new Employee object from each returned row...
				Passenger e = new Passenger(
						//we want to use rs.getXYZ for each column in the record
						rs.getInt("passenger_id"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getString("fldeparture"),
						rs.getInt("flight_id")
						);
				
				//and populate the ArrayList with each new Employee object
				passengerList.add(e); //e is the new Employee object we created above
			}
			
			//when there are no more results in the ResultSet the while loop will break...
			//return the populated List of Employees
			return passengerList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); //generic console message
			e.printStackTrace(); //stack trace so we actually know what went wrong
		}
		
		return null; //we add this after the try/catch so Java won't yell.
					 //(Since there is no guarantee the try with resources block will run)
	}
	
	@Override
	public void updateDate(int passengerId, String dateInput) {
		try(Connection conn = ConnectionUtil.getConnection()){
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this will format my dates to be SQL acceptable 
		//Date dateDeparture = new Date(); //from java.util - we will convert it into a java.sql Date 
		//String currentDate = dateFormat.format(dateDeparture);
	
		String sql = "update passenger set fldeparture = ? where passenger_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
	
		ps.setDate(1, java.sql.Date.valueOf(dateInput));
		ps.setInt(2, passengerId);
		
		ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("update departure date failed :(");
			e.printStackTrace();
		}
	}

}
