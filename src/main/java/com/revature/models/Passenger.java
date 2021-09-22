package com.revature.models;

public class Passenger {

	private int passenger_id;
	private String fname;
	private String lname;
	private String fldeparture;
	private int flight_id;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(int passenger_id, String fname, String lname, String fldeparture, int flight_id) {
		super();
		this.passenger_id = passenger_id;
		this.fname = fname;
		this.lname = lname;
		this.fldeparture = fldeparture;
		this.flight_id = flight_id;
	}
	public Passenger(String fname, String lname, String fldeparture, int flight_id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.fldeparture = fldeparture;
		this.flight_id = flight_id;
	}
	@Override
	public String toString() {
		return "Passenger [passenger_id=" + passenger_id + ", fname=" + fname + ", lname=" + lname + ", fldeparture="
				+ fldeparture + ", flight_id=" + flight_id + "]";
	}
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFldeparture() {
		return fldeparture;
	}
	public void setFldeparture(String fldeparture) {
		this.fldeparture = fldeparture;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fldeparture == null) ? 0 : fldeparture.hashCode());
		result = prime * result + flight_id;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + passenger_id;
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
		Passenger other = (Passenger) obj;
		if (fldeparture == null) {
			if (other.fldeparture != null)
				return false;
		} else if (!fldeparture.equals(other.fldeparture))
			return false;
		if (flight_id != other.flight_id)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (passenger_id != other.passenger_id)
			return false;
		return true;
	}
	
	
}
