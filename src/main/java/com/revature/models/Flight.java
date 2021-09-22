package com.revature.models;

public class Flight {

	private int flight_id;
	private boolean international;
	private String country_from;
	private String state_from;
	private String city_from;
	private String country_to; 
	private String state_to;
	private String city_to;
	private int availability;
	private double price;
	
	//no args constructor
	public Flight() {
		super();
	}
	//all args constructor
	public Flight(int flight_id, boolean international, String country_from, String state_from, String city_from,
			String country_to, String state_to, String city_to, int availability, double price) {
		super();
		this.flight_id = flight_id;
		this.international = international;
		this.country_from = country_from;
		this.state_from = state_from;
		this.city_from = city_from;
		this.country_to = country_to;
		this.state_to = state_to;
		this.city_to = city_to;
		this.availability = availability;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", International=" 
				+ international + ", departing from " + country_from + " " +state_from +" "+ city_from 
				+ ", Arriving to " + country_to +" "+ state_to +" "+ city_to 
				+", Availability=" + availability + ", Price=" + price + "]";
	}
	
	//***************************************** Setters and Getters *************************************
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public boolean isInternational() {
		return international;
	}
	public void setInternational(boolean international) {
		this.international = international;
	}
	public String getCountry_from() {
		return country_from;
	}
	public void setCountry_from(String country_from) {
		this.country_from = country_from;
	}
	public String getState_from() {
		return state_from;
	}
	public void setState_from(String state_from) {
		this.state_from = state_from;
	}
	public String getCity_from() {
		return city_from;
	}
	public void setCity_from(String city_from) {
		this.city_from = city_from;
	}
	public String getCountry_to() {
		return country_to;
	}
	public void setCountry_to(String country_to) {
		this.country_to = country_to;
	}
	public String getState_to() {
		return state_to;
	}
	public void setState_to(String state_to) {
		this.state_to = state_to;
	}
	public String getCity_to() {
		return city_to;
	}
	public void setCity_to(String city_to) {
		this.city_to = city_to;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//*************************************** Hash Code and Equals *************************************
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availability;
		result = prime * result + ((city_from == null) ? 0 : city_from.hashCode());
		result = prime * result + ((city_to == null) ? 0 : city_to.hashCode());
		result = prime * result + ((country_from == null) ? 0 : country_from.hashCode());
		result = prime * result + ((country_to == null) ? 0 : country_to.hashCode());
		result = prime * result + flight_id;
		result = prime * result + (international ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state_from == null) ? 0 : state_from.hashCode());
		result = prime * result + ((state_to == null) ? 0 : state_to.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (availability != other.availability)
			return false;
		if (city_from == null) {
			if (other.city_from != null)
				return false;
		} else if (!city_from.equals(other.city_from))
			return false;
		if (city_to == null) {
			if (other.city_to != null)
				return false;
		} else if (!city_to.equals(other.city_to))
			return false;
		if (country_from == null) {
			if (other.country_from != null)
				return false;
		} else if (!country_from.equals(other.country_from))
			return false;
		if (country_to == null) {
			if (other.country_to != null)
				return false;
		} else if (!country_to.equals(other.country_to))
			return false;
		if (flight_id != other.flight_id)
			return false;
		if (international != other.international)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (state_from == null) {
			if (other.state_from != null)
				return false;
		} else if (!state_from.equals(other.state_from))
			return false;
		if (state_to == null) {
			if (other.state_to != null)
				return false;
		} else if (!state_to.equals(other.state_to))
			return false;
		return true;
	}
	
	
	
	
}
