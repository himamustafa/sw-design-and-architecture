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
	//ArrayList <Admin> admins = new ArrayList <Admin>();
	/*@Override
	public void Register(Person a) {
		// TODO Auto-generated method stub
		admins.add((Admin) a);
	}*/
	/*Admin(String u,String p)
	{
		username = u;
		password = p;
	}*/
}
