package com.example.uber;

public class Ride 
{
	private DistanceTime distance;
	static int rideId;
	int Id=0;
	static String source;
	static String Destination;
	static User user;
	Driver driver;
	static double price;
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
		price=-1;
		Id++;
		rideId = Id;
	}
static public void set_ride(String s,String d, User u)
{
	source=s;
	Destination=d;
	user =u;
	price=-1;
}
	public void Set_price(double p) 
	{
		price =p;
	};
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
	public void setDistance(DistanceTime distance) {
		   this.distance = distance;
		}
	
}
