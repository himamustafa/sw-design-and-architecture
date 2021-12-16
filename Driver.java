package app;

import java.util.ArrayList;

public class Driver extends Person1 implements Observer {
	public ArrayList <Ride> rides = new ArrayList <Ride>();
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
	public Boolean pending;
	ArrayList <String> favourite_areas= new ArrayList<String>();
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
	}
	@Override
	public void update(Ride r) {
		// TODO Auto-generated method stub
		rides.add(r);
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
}
