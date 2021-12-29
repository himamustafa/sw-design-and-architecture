package app;

import java.util.ArrayList;

public class Driver extends Person1 implements Observer {
	public ArrayList <Ride> rides = new ArrayList <Ride>();
	public ArrayList <Ride> DriverHistory = new ArrayList <Ride>();
	Driver(String x, String y) {
		super(x, y);
		username=x;
		password=y;
		// TODO Auto-generated constructor stub
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
	@Override
	public void update(Ride r) {
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
	public Ride getbyusername(String username) 
	{
		//Ride r = rides.get(0);
		Ride r =null;
		for(int i =0;i<rides.size();i++) 
		{
			if(rides.get(i).user.username.equals(username)) 
			{
				r=rides.get(i);
			}
		}
		return r;
	}
	public void add_to_favourites(Driver r,String area) 
	{
		r.favourite_areas.add(area);
	}
	public Boolean login(Driver driver)
	{
		for(int i=0;i<all_drivers.size();i++) 
		{
			if(all_drivers.get(i).username.equals(driver.username)) 
			{
				if(all_drivers.get(i).password.equals(driver.password) && !(all_drivers.get(i).pending)) 
				{
					return true;
				}
				else 
					return false;
			}
		}
		return false;
		
	}
	public void set_Driver(String u,String p,String m,String e,String n,String d,String a)
	{
		username=u; 
		mobile_number = m;
		email=e;
		password=p;
		driving_license=d;
		national_id=n;
		pending=true;
		favourite_areas.add(a);
		balance=0;
	}
	public void register(Driver driver) 
	{
		
		all_drivers.add(driver);
	}
	public void EndRide(Ride ride)
	{
		ride.Ride_Completed=true;
		balance+=ride.price;
		update(ride);
		
	}
}
