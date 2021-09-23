package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.FlightDao;
import com.revature.dao.PassengerDao;

public class Menu {

	FlightDao eDao = new FlightDao(); //so we can use the EmployeeDao methods
	PassengerDao rDao = new PassengerDao(); //so we can use the RoleDao methods
	public void displayMenu() {
		
		boolean displayMenu = true; //to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //creating Scanner object to parse user input
		
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("              Welcome to Scuffed Airlines             ");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
	
			while(displayMenu) {
			
			System.out.println("----------------------");
			System.out.println("How can we help you.");
			System.out.println("----------------------");
			
			//menu options
			System.out.println("viewFlightsAll        -> View all flights");
			System.out.println("viewFlightDestination -> View flights to specific destination");
			System.out.println("viewBookings          -> View booked flights");
			System.out.println("bookFlight            -> Book a flight");
			//System.out.println("updateBooking         -> Update departure date");
			System.out.println("deleteBooking         -> Remove your booked flight");
			System.out.println("exit                  -> exit application");
			
			String input = scan.nextLine();
			switch(input) {
			
			
			case "viewFlightsAll": {
				
				//get the List of employees from the DAO layer
				List<Flight> flight = eDao.getFlight();
				
				//enhanced for loop to print out the Employees one by one
				for(Flight emp : flight) {
					System.out.println(emp);
				}
				
				//log.info("USER RETRIEVED LIST OF ALL EMPLOYEES");
				
				break;
			}
			
			case "viewFlightDestination": {
				
				System.out.println("Enter Destination to Search: (Case Sensitive! e.g. \"Brazil\")");
				String destinationInput = scan.nextLine(); //get user's input for Role to search by
				
				List<Flight> flight = eDao.getFlightByDestination(destinationInput); //get the List of Employees from the dao
				
				for(Flight e : flight)
				{
					System.out.println(e); //print them out one by one via the enhanced for loop
				}
				break;				
				
			}
			
			case "bookFlight": {
				
				System.out.println("Enter Passenger First Name");
				String fName = scan.nextLine();
				
				System.out.println("Enter Passenger Last Name");
				String lName = scan.nextLine();
				
				System.out.println("Enter departure date (YYYY-MM-DD)");
				String fldeparture = scan.nextLine();
				
				//Not the best design... the user doesn't techinally know the role ids...
				//You could have a getAllRoles method in the RoleDao to display before this
				//OR you could display the different roles in another print statement like I did
				System.out.println("Enter Passenger Flight Id");
				//System.out.println("Manager = 1 | Fry Cook = 2 | Cashier = 3 | Marketing = 4 | Nepotism = 5");
				
				int flightId = scan.nextInt(); 
				scan.nextLine();
				
				//create a new Employee based on these inputs
				Passenger emp = new Passenger(fName, lName, fldeparture , flightId);
				///why xxx for hire_date??? We input the current date in the DAO. the "xxx" will go unused.
				
				rDao.addPassenger(emp);
				
				break;
			}
			
			/*case "updateBooking": {
				
				System.out.println("Enter Role Title to change");
				int passangerId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter departure date (YYYY-MM-DD)");
				String dateInput = scan.nextLine();
				
				scan.nextLine();
				
				rDao.updateDate(passangerId, dateInput);
				break;
			}*/
			
			case "deleteBooking": {
				
				System.out.println("Enter the passenger id to delete");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				rDao.removePassenger(id);
				
				//log.warn("USER DELETED EMPLOYEE " + id);
				
				break;
			}
			
			case "viewBookings": {
				
				List<Passenger> passenger = rDao.getPassenger();
				
				//enhanced for loop to print out the Employees one by one
				for(Passenger emp : passenger) {
					System.out.println(emp);
				}
				
				//log.info("USER RETRIEVED LIST OF ALL EMPLOYEES");
				
				
				break;
			}
			
			case "exit": {
				displayMenu = false; //this is how we break out of the while loop, ending the menu display
				System.out.println("Thank you for using Scuffed Airlines.");
				break;
			}
			
			//this default block will catch anything that doesn't match a menu option
			default: {
				System.out.println("Sorry please try again");
				break;
			}
			
			} //end switch
		}//end while
		System.out.println("Thank you please come again soon");
		scan.close();
	}
}
