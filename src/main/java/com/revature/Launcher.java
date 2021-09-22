package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		//Connecting to postgres database schema flight
		try(Connection conn = ConnectionUtil.getConnection()) {
			//System.out.println("Hello, connection was successful!!");
		} catch (SQLException e) {
			System.out.println("Failed Connection D:");
			e.printStackTrace();
		}
		
		//Create menu and let it do its thing
		Menu menu = new Menu();
		menu.displayMenu();
	}

}
