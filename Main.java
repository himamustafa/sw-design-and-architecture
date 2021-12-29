package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Person1 person= new Person1("" , "");
		User users = new User("","");
	//	Ride rides = new Ride();
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
					Person1 driver = new Driver(username,password);
					if(person.login(driver)) 
					{
						System.out.println("Login Successfully as a driver :)");
						System.out.println("Do u want to add in ur favourite areas list OR List all Rides or end the ride?");
						Driver t = null;
						for(int i=0;i<person.all_drivers.size();i++) 
						{
							if(person.all_drivers.get(i).username.equals(driver.username)) 
							{
								if(person.all_drivers.get(i).password.equals(driver.password) && !(person.all_drivers.get(i).pending)) 
								{
									t=person.all_drivers.get(i);
								}
							}
						}
						String choice3=in.nextLine();
						if(choice3.equals("add")) 
						{
							int index = person.all_drivers.indexOf(t);
							System.out.println("Please Enter the area");
							String area=in.nextLine();//nafs tari2et el login hat5osh tedawar 3ala 3l driver
							t.add_to_favourites(t, area);
							person.all_drivers.set(index, t);
						}
						else if(choice3.equals("list")) 
						{
							t.print();
							System.out.println("Please Enter the username of user u want to suggest him a price");
							String username1 = in.nextLine();
							Ride ride =t.getbyusername(username1);
							
							System.out.println("Please Enter the Price");
							int price = Integer.parseInt(in.nextLine());
							ride.Set_price(price);
							MessagePublisher Subject = new MessagePublisher();
							for(int i=0;i<person.all_users.size();i++) 
							{
								if(person.all_users.get(i).username.equals(ride.user.username)) 
								{
									
									if(person.all_users.get(i).password.equals(ride.user.password)) 
									{
										Subject.attach(person.all_users.get(i));
									}
								}
							}
							Subject.notifyUpdate(ride);
						}
						else if(choice3.equals("end")) 
						{
							System.out.println("Please Enter the username of user u want to end his/her ride");
							String username1 = in.nextLine();
							Ride ride =t.getbyusername(username1);
							t.EndRide(ride);
							Ride.RideHistory.add(ride);
							System.out.println("Ride ended successfully");
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
				
					Admin admin = new Admin(username,password);
					if(person.login(admin)) 
					{
						System.out.println("Login Successfully as a Admin :)");
						boolean y = true;
						while(y==true) {
							System.out.println("List Pending List Or Verify");
							String choice3 = in.nextLine();
							if(choice3.contains("l")) 
							{
								ArrayList <Driver> drivers = new ArrayList<Driver>();
								drivers = admin.list_allpending();				
								for(int i =0;i<drivers.size();i++) 
								{
									System.out.println(drivers.get(i).username+"	"+drivers.get(i).email+"	"+drivers.get(i).mobile_number+"	"+drivers.get(i).national_id+"	"+drivers.get(i).driving_license);
								}
							}
							else if(choice3.contains("v"))
							{
								System.out.println("Please Enter the username of the Driver");
								String driver_name=in.nextLine();
								System.out.println("Please Enter the email of the Driver");
								String driver_email=in.nextLine();
								admin.verify(driver_name,driver_email);
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
					User user = new User(username,password);
							
					if(person.login(user)) 
					{
						System.out.println("Login Successfully as a User :)");
						System.out.println("Do u want to request a ride, see ur ride, list all ride offers, or rate your ride");
						String input = in.nextLine();
						if(input.equals("ride")) 
						{
							System.out.println("Please Enter the Source area's Name");
							String src=in.nextLine();					
							System.out.println("Please Enter the Destination area's Name");
							String dest=in.nextLine();
							Ride r = new Ride(src,dest,user);
							MessagePublisher Subject = new MessagePublisher();
							for (int i =0;i<person.all_drivers.size();i++) 
							{
								for(int j=0;j<person.all_drivers.get(i).favourite_areas.size();j++) 
								{
									if(person.all_drivers.get(i).favourite_areas.get(j).equals(src)) 
									{
										Subject.attach(person.all_drivers.get(i));
									}
								}
							}
							Subject.notifyUpdate(r);
						}
						else if(input.equals("list")) 
						{
							MessagePublisher Subject = new MessagePublisher();
							user.print();
							System.out.println("do you want to select a specific offer");
							String inp = in.nextLine();
							if(inp.equals("yes"))
							{
								System.out.println("enter the ride number");
								int number = Integer.parseInt(in.nextLine());
								for(int i=0;i<user.rides.size(); i++)
								{
									if(user.rides.get(i).equals(user.rides.get(number-1)))
									Subject.attach(user.rides.get(i).driver);
									else
										System.out.println("not an available choice");
								}
							
							}
								
							
						}
						
						else if(input.equals("rate"))
						{
							System.out.println("Please enter the ride id");
							int id = Integer.parseInt(in.nextLine()); 
							System.out.println("Please enter the rate");
							double rate = Double.parseDouble(in.nextLine());
							for(int i=0; i<user.UserHistory.size();i++)
							{
								if(user.UserHistory.get(i).equals(user.UserHistory.get(id-1)))
								{
									//User.rate(users.UserHistory.get(i),rate);
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
					Driver driver = new Driver(username,password);
					driver.set_Driver(username,password,mobile,email,id,license,area);
					driver.register(driver);
				}
				else if(choice2.contains("n"))//admin
				{
					System.out.println("Please Enter your username");
					String username=in.nextLine();
					System.out.println("Please Enter your password");
					String password=in.nextLine();
					Admin admin = new Admin(username,password);
					admin.register(admin);
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
					User user = new User(username,password);
					user.set_User(username,mobile,email,password);
					user.register(user);
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
