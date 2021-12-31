package com.example.uber;

import java.util.ArrayList;

public class User extends Actor implements Observer
{
	private Subject subject;
	public ArrayList <Ride> UserHistory = new ArrayList <Ride>();	
	OfferEntity offer;
	public ArrayList <Ride> rides = new ArrayList <Ride>();
	User(String x, String y) {
		super(x, y);
		username =x;
		password =y;
		// TODO Auto-generated constructor stub
	}
	User()
	{
		
	}
	User(User user)
	{
		
	}
	Actor person = new Actor(username,password);
	public void set_User(UserEntity entity)
	{
		entity.setUsername(entity.username);
		entity.setMobile_number(entity.mobile_number);
		entity.setEmail(entity.email);
		entity.setPassword(entity.password);

	}
	public void add(Ride r)
	{
		rides.add(r);
	}
	@Override
	public void update(Ride r) {
		// TODO Auto-generated method stub
		rides.set(Ride.rideId-1,r);
	}
	public void print() 
	{
		for(int i =0;i<rides.size();i++) 
		{
			System.out.print(rides.get(i).source+" -> "+rides.get(i).Destination+"	");
			System.out.print("With Price: "+rides.get(i).offer.getPrice()+"	");
			System.out.print("From Driver: "+rides.get(i).driver.username);
		}
	}
	public ArrayList<Ride> listRides()
	{
			return UserHistory;
	}
	public Boolean login(User user)
	{
		for(int i=0;i<all_users.size();i++) 
		{
			if(all_users.get(i).username.equals(user.username)) 
			{
				
				if(all_users.get(i).password.equals(user.password)) 
				{
					return true;
				}
				else 
					return false;
			}
		}
		return false;
		
	}
	
	public void register(User user) 
	{
		all_users.add(user);
	}
	public void rate(Ride ride, double rate)
	{
		for(int i=0;i<UserHistory.size();i++)
		{
			if(ride.rideId == UserHistory.get(i).rideId)
			{
				ride.RideRate = rate;
				update(ride);
			}
		}
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
