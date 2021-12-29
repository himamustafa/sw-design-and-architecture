package app;

import java.util.ArrayList;

public class Admin extends Person1 {
	Admin(String x, String y) {
		
		super(x, y);
		username=x;
		password=y;
	}
	String username;
	String password;


public void verify(String driver_username,String driver_email) 
{
	for(int i =0;i<all_drivers.size();i++) {
		if(all_drivers.get(i).username.equals(driver_username) && all_drivers.get(i).email.equals(driver_email) ) {
			all_drivers.get(i).pending=false;
		}
	}
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

public Boolean login(Admin admin) 
{
for(int i=0;i<all_admins.size();i++) 
{
	if(all_admins.get(i).username.equals(admin.username)) 
	{
		if(all_admins.get(i).password.equals(admin.password)) 
		{
			return true;
		}
		else 
			return false;
	}
}
return false;

}

public void register(Admin admin) 
{
	all_admins.add(admin);
}




}
