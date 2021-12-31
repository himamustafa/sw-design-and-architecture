package com.example.uber;

import java.util.ArrayList;

public class Driver extends Actor implements Observer {
	public ArrayList <Ride> rides = new ArrayList <Ride>();
	public ArrayList <Ride> DriverHistory = new ArrayList <Ride>();
	Driver(String x, String y) {
		super(x, y);
		username=x;
		password=y;
		// TODO Auto-generated constructor stub
	}
	Driver()
	{
		
	}
	private Subject subject;
	Driver(Driver driver)
	{
		
	}
	String username;
	String mobile_number;
	String email;
	String password;
	String driving_license;
	String national_id;
	String fav_area;
	public Boolean pending;
	double balance=0;
	ArrayList <String> favourite_areas= new ArrayList<String>();

	public void add(Ride r)
	{
		rides.add(r);
	}
	public void updateride(Ride r) {
		// TODO Auto-generated method stub
		rides.set(Ride.rideId-1,r);
	}
	public void print() 
	{
		for(int i =0;i<rides.size();i++) 
		{
			System.out.print(this.username+"	");
			System.out.print(rides.get(i).source+" -> "+rides.get(i).Destination+"	");
			System.out.print("From User: "+rides.get(i).user.username);
			System.out.println();
		}
		System.out.println();
	}
	
	public void add_to_favourites(Driver r,String area) 
	{
		r.favourite_areas.add(area);
	}
	DriverEntity driverentity;
	public Boolean login(Driver driver)
	{
		for(int i=0;i<all_drivers.size();i++) 
		{
			if(all_drivers.get(i).username.equals(driver.username)) 
			{
				if(all_drivers.get(i).password.equals(driver.password) && !(all_drivers.get(i). driverentity.getPending())) 
				{
					return true;
				}
				else 
					return false;
			}
		}
		return false;
		
	}
	public void set_Driver(DriverEntity entity)
	{
		entity.setUsername(entity.username);
		entity.setMobile_number(entity.mobile_number);
		entity.setEmail(entity.email);
		entity.setPassword(entity.password);
		entity.setDriving_license(entity.driving_license);
		entity.setNational_id(entity.national_id);
		entity.setPending(true);
		favourite_areas.add(entity.fav_area);
		balance=0;
	}
	public void register(Driver driver) 
	{
		all_drivers.add(driver);
	}
	
		@Override
		public void update() 
		{
			// TODO Auto-generated method stub
			System.out.println("notified");
		}

		@Override
		public void attachSubject(Subject j) 
		{
			// TODO Auto-generated method stub
			subject = j;
		}
	
	}
