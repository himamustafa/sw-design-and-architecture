package app;

import java.util.ArrayList;

public class User  extends Person1   implements Observer
{
	public static ArrayList <Ride> UserHistory = new ArrayList <Ride>();	
	//public ArrayList <User> users = new ArrayList <User>(); 
	public ArrayList <Ride> rides = new ArrayList <Ride>();
	User(String x, String y) {
		super(x, y);
		username =x;
		password =y;
		// TODO Auto-generated constructor stub
	}
	String username;
	String mobile_number;
	String email;
	String password;
	Person1 person = new Person1(username,password);
	public void set_User(String u,String m,String e,String p)
	{
		username =u;
		mobile_number = m;
		email= e;
		password =p;

	}
	public void add(Ride r)
	{
		rides.add(r);
	}
	@Override
	public void update(Ride r) 
	{
		// TODO Auto-generated method stub
		rides.set(Ride.rideId-1,r);
	}
	public void print() 
	{
		for(int i =0;i<rides.size();i++) 
		{
			System.out.print(rides.get(i).source+" -> "+rides.get(i).Destination+"	");
			System.out.print("With Price: "+rides.get(i).price+"	");
			System.out.print("From Driver: "+rides.get(i).driver.username);
		}
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
		ride.RideRate = rate;
		update(ride);
	}
	public void start_ride(Ride ride)
	{
		
	}
	/*public void list_rides(User user)
	{
		for(int i=0;i<all_users.size();i++) 
		{
			if(all_users.get(i).username.equals(user.username)) 
			{
				
				if(all_users.get(i).password.equals(user.password)) 
				{
					all_users.get(i).print();
				}
			}
		}
	}*/
	
	
}
