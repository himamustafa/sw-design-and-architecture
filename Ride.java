package app;

public class Ride 
{
	String source;
	String Destination;
	User user;
	Driver driver;
	int price;
	Ride(String s,String d, User u)
	{
		source=s;
		Destination=d;
		user =u;
		price=-1;
	}
	Ride(String s,String d, Driver u)
	{
		source=s;
		Destination=d;
		driver =u;
		price=-1;
	}
	public void Set_price(int p) 
	{
		price =p;
	};
}
