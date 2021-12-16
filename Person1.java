package app;

import java.util.ArrayList;

public class Person1 
{
	String username;
	String password;
	public static ArrayList<User> all_users = new ArrayList  <User>();
	public static ArrayList<Admin> all_admins = new ArrayList  <Admin>();
	public static ArrayList<Driver> all_drivers = new ArrayList  <Driver>();
	public Subject s = new MessagePublisher();
	 Person1(String x, String y){
		 username=x;
		 password=y;
	 }
	
	public Boolean Login(Person1  f) 
	{
		if(f instanceof Driver) 
		{
			for(int i=0;i<all_drivers.size();i++) 
			{
				if(all_drivers.get(i).username.equals(f.username)) 
				{
					if(all_drivers.get(i).password.equals(f.password) && !(all_drivers.get(i).pending)) 
					{
						return true;
					}
					else 
						return false;
				}
			}
			return false;
		}
		else if(f instanceof User) 
		{
	
			for(int i=0;i<all_users.size();i++) 
			{
				if(all_users.get(i).username.equals(f.username)) 
				{
					
					if(all_users.get(i).password.equals(f.password)) 
					{
						return true;
					}
					else 
						return false;
				}
			}
			return false;
		}
		else if(f instanceof Admin) 
		{
			for(int i=0;i<all_admins.size();i++) 
			{
				if(all_admins.get(i).username.equals(f.username)) 
				{
					if(all_admins.get(i).password.equals(f.password)) 
					{
						return true;
					}
					else 
						return false;
				}
			}
			return false;
		}
		return null;
	}
	public ArrayList <Driver> list_allpending()
	{
		ArrayList<Driver> pendingdrivers = new ArrayList <Driver>();
		for(int i =0;i<all_drivers.size();i++) 
		{
			if(all_drivers.get(i).pending) 
			{
				pendingdrivers.add(all_drivers.get(i));
			}
		}
		return pendingdrivers;
	}
	public void verify(String driver_username,String driver_email) 
	{
		for(int i =0;i<all_drivers.size();i++) {
			if(all_drivers.get(i).username.equals(driver_username) && all_drivers.get(i).email.equals(driver_email) ) {
				all_drivers.get(i).pending=false;
			}
		}
	}
	public void add_to_favourites(Driver r,String area) 
	{
		r.favourite_areas.add(area);
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
}
