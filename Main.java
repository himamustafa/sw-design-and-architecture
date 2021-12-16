package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Person1 p= new Person1("" , "");
		Scanner in =new Scanner(System.in);
		System.out.println("Welcome to Uber");
		Boolean x =true;
		while(x == true) 
		{
			System.out.println("Login Or Register Or Quit");
			String choice = in.nextLine();
			if(choice.contains("l")) 
			{
				System.out.println("Are u Driver Or Admin Or User");
				String choice2 = in.nextLine();
				if(choice2.contains("v")) 
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					Person1 v = new Driver(username,password);
					if(p.Login(v)) 
					{
						System.out.println("Login Successfully as a driver :)");
						System.out.println("Do u want to add in ur favourite areas list OR List all Rides?");
						Driver t = null;
						for(int i=0;i<p.all_drivers.size();i++) 
						{
							if(p.all_drivers.get(i).username.equals(v.username)) 
							{
								if(p.all_drivers.get(i).password.equals(v.password) && !(p.all_drivers.get(i).pending)) 
								{
									t=p.all_drivers.get(i);
								}
							}
						}
						String choice3=in.nextLine();
						if(choice3.equals("add")) 
						{
							int index = p.all_drivers.indexOf(t);
							System.out.println("Please Enter the area");
							String area=in.nextLine();//nafs tari2et el login hat5osh tedawar 3ala 3l driver
							t.add_to_favourites(t, area);
							p.all_drivers.set(index, t);
						}
						else if(choice3.equals("list")) 
						{
							t.print();
							System.out.println("Please Enter the username of user u want to suggest him a price");
							String u = in.nextLine();
							Ride r =t.getbyusername(u);
							System.out.println(t.getbyusername(u).Destination+"	"+t.getbyusername(u).source+"	"+t.getbyusername(u).user.username);
							int index = t.rides.indexOf(r);
							int index2 = p.all_drivers.indexOf(t);
							System.out.println("Please Enter the Price");
							int price = Integer.parseInt(in.nextLine());
							r.Set_price(price);
							t.rides.set(index2, r);
							p.all_drivers.set(index2,t);
							Ride r2 = new Ride(r.source,r.Destination,t);
							System.out.println(r2.Destination+"	"+r2.source+"	"+r2.user.username);
							MessagePublisher Subject = new MessagePublisher();
							for(int i=0;i<p.all_users.size();i++) 
							{
								if(p.all_users.get(i).username.equals(r2.user.username)) 
								{
									
									if(p.all_users.get(i).password.equals(r2.user.password)) 
									{
										Subject.attach(p.all_users.get(i));
									}
								}
							}
							Subject.notifyUpdate(r2);
						}
						
					}
					else
						System.out.println("Your Credentials is wrong Or u are stil on pending list :(");
					
					
				}
				else if(choice2.contains("n")) 
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					/*for(int i=0;i<p.all_admins.size();i++) 
					{
						System.out.println(p.all_admins.get(i).username+"	"+p.all_admins.get(i).password);
					}*/
					Admin n = new Admin(username,password);
					if(p.Login(n)) 
					{
						System.out.println("Login Successfully as a Admin :)");
						boolean y = true;
						while(y==true) {
							System.out.println("List Pending List Or Verify");
							String choice3 = in.nextLine();
							if(choice3.contains("l")) 
							{
								ArrayList <Driver> d = new ArrayList<Driver>();
								d = p.list_allpending();
								for(int i =0;i<d.size();i++) 
								{
									System.out.println(d.get(i).username+"	"+d.get(i).email+"	"+d.get(i).mobile_number+"	"+d.get(i).national_id+"	"+d.get(i).driving_license);
								}
							}
							else if(choice3.contains("v"))
							{
								System.out.println("Please Enter the username of the Driver");
								String driver_name=in.nextLine();
								System.out.println("Please Enter the email of the Driver");
								String driver_email=in.nextLine();
								p.verify(driver_name,driver_email);
							}
							else if(choice3.contains("q")) 
							{
								y=false;
							}
							else
								System.out.println("Unavailable choice :( ");
						}
					}
					else
						System.out.println("Your Credentials is wronggg :(");
				}
				else if(choice2.contains("s")) 
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					User s = new User(username,password);
					/*System.out.println(s.username);
					System.out.println(s.password);
					for(int i=0;i<p.all_users.size();i++) 
					{
						System.out.println(p.all_users.get(i).username+"	"+p.all_users.get(i).password);
					}
					System.out.println(p.Login(s));*/
									
					if(p.Login(s)) 
					{
						System.out.println("Login Successfully as a User :)");
						System.out.println("Do u want to request a ride or see ur ride");
						String c = in.nextLine();
						if(c.equals("ride")) 
						{
							System.out.println("Please Enter the Source area's Name");
							String src=in.nextLine();					
							System.out.println("Please Enter the Destination area's Name");
							String dest=in.nextLine();
							Ride r = new Ride(src,dest,s);
							MessagePublisher Subject = new MessagePublisher();
							for (int i =0;i<p.all_drivers.size();i++) 
							{
								for(int j=0;j<p.all_drivers.get(i).favourite_areas.size();j++) 
								{
									if(p.all_drivers.get(i).favourite_areas.get(j).equals(src)) 
									{
										Subject.attach(p.all_drivers.get(i));
									}
								}
							}
							Subject.notifyUpdate(r);
						}
						else if(c.equals("list")) 
						{
							for(int i=0;i<p.all_users.size();i++) 
							{
								if(p.all_users.get(i).username.equals(s.username)) 
								{
									
									if(p.all_users.get(i).password.equals(s.password)) 
									{
										p.all_users.get(i).print();
									}
								}
							}
						}
					}
					
				}
				else 
				{
					System.out.println("Unavailable choice :(");
				}
					
			}
			else if(choice.contains("r")) 
			{
				System.out.println("Are u Driver Or Admin Or User");
				String choice2 = in.nextLine();
				if(choice2.contains("v"))//driver 
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					System.out.println("Please Enter your mobile Number");
					String mobile=in.nextLine();
					System.out.println("Please Enter your email");
					String email=in.nextLine();
					System.out.println("Please Enter your National ID");
					String id=in.nextLine();
					System.out.println("Please Enter your Driving License");
					String license=in.nextLine();
					System.out.println("Please Enter your Source area");
					String area=in.nextLine();
					Driver d = new Driver(username,password);
					d.set_Driver(username,password,mobile,email,id,license,area);
					p.all_drivers.add(d);
				}
				else if(choice2.contains("n"))//admin
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					Admin a = new Admin(username,password);
					p.all_admins.add(a);
				}
				else if(choice2.contains("s"))//user
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					System.out.println("Please Enter your mobile Number");
					String mobile=in.nextLine();
					System.out.println("Please Enter your email");
					String email=in.nextLine();
					User u = new User(username,password);
					u.set_User(username,mobile,email,password);
					p.all_users.add(u);
				}
				else 
				{
					System.out.println("Unavailable choice :(");
				}
			}
			else if(choice.contains("Q")) 
			{
				x=false;
			}
			else 
			{
				System.out.println("Unavailable choice :(");
			}
		}
		
	}

}
