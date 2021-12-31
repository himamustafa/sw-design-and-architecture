package com.example.uber;

import java.util.ArrayList;

public class Ride 
{
	OfferEntity offer;
	OfferModel model;
	private DistanceTime distance;
	static int rideId;
	int Id=0;
	static String source;
	static String Destination;
	static User user;
	Driver driver;
	Actor person;
	//static double price;
	boolean Ride_Completed= false;
	double RideRate=0;
	Ride()
	{
		
	}
	Ride(String s,String d, User u)
	{
		source=s;
		Destination=d;
		user =u;
		Id++;
		rideId = Id;
	}
static public void set_ride(String s,String d, User u)
{
	source=s;
	Destination=d;
	user =u;
}
	public Ride getbyusername(String username) 
	{
		Ride r =null;
		for(int i =0;i<user.rides.size();i++) 
		{
			if(user.rides.get(i).user.username.equals(username)) 
			{
				r=user.rides.get(i);
			}
		}
		return r;
	}
	public void EndRide(Ride ride)
	{
		Ride_Completed=true;
		driver.balance+=model.getOffer(ride.rideId).getPrice();
		driver.DriverHistory.add(ride);
		user.UserHistory.add(ride);
	}
	MessagePublisher subject1 = new MessagePublisher();
	public void selectRide(String username)
	{
		Driver driver = null;
		for(int p=0;p<person.all_drivers.size();p++)
		{
			if(person.all_drivers.get(p).username.equals(username))
			{
				driver = person.all_drivers.get(p);
				subject1.attach(driver);
				driver.attachSubject(subject1);
				subject1.notifyUpdate();
			}
		}
		
		for(int i=0;i<model.offers.size();i++)
		{
			if(model.offers.get(i).getDriver().equals(driver))
			{
				for(int y=0;y<driver.rides.size();y++)
				{
					if(driver.rides.get(y).rideId==model.offers.get(i).getRideId())
					{
						StartRide(driver.rides.get(y));
					}
				}
			}
		}
	}
	public void StartRide(Ride ride)
	{
			offer = model.getOffer(ride.rideId);
			user.rides.add(ride);
			driver.rides.add(ride);
	}
	public void setDistance(DistanceTime distance) 
		{
		   this.distance = distance;
		}
	ArrayList<OfferEntity> useroffers = new ArrayList<OfferEntity>();
	public ArrayList<OfferEntity> listOffers(int rideId)
	{
		for(int i=0;i<model.offers.size();i++)
		{
			if(rideId==model.offers.get(i).getRideId())
			{
				 useroffers.add(model.offers.get(i));
			}
		}
		return useroffers; 
	}
	
}
