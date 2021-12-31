package com.example.uber;

public class OfferEntity {
	private int rideId;
	private double price;
	private Driver driver;
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	public void setDriver(Driver driver)
	{
		this.driver = driver;
	}
	public Driver getDriver()
	{
		return driver;
	}
	

}
