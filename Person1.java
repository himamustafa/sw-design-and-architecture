package com.example.uber;

import java.util.ArrayList;

public class Actor 
{
	String username;
	String password;
	public static ArrayList<User> all_users = new ArrayList  <User>();
	public static ArrayList<Admin> all_admins = new ArrayList  <Admin>();
	public static ArrayList<Driver> all_drivers = new ArrayList  <Driver>();
	public Subject s = new MessagePublisher();
	
	Actor()
	{
		
	}
	Actor(String x, String y){
		 username=x;
		 password=y;
	 }
	public Boolean login(Actor  person) 
	{
		return true;
	}
	
	public void register(Actor person) 
	{
		
	}
	
	public void adding_Observers(ArrayList <User>u,ArrayList<Driver> d) 
	{
		for(int i=0;i<u.size();i++) 
		{
			s.attach(u.get(i));
		}
		for(int j=0;j<u.size();j++) 
		{
			s.attach(d.get(j));
		}
	}
	public void update(Ride r) {
		// TODO Auto-generated method stub
		
	}
}
	
