package app;

import java.util.ArrayList;

public class User  extends Person1   implements Observer
{
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
	public void set_User(String u,String m,String e,String p)
	{
		username =u;
		mobile_number = m;
		email= e;
		password =p;
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
			System.out.print(rides.get(i).source+" -> "+rides.get(i).Destination+"	");
			System.out.print("With Price: "+rides.get(i).price+"	");
			System.out.print("From Driver: "+rides.get(i).driver.username);
			System.out.println();
		}
		System.out.println();
	}
}
