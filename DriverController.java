package com.example.uber;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class DriverController extends Person1{

	
	@PostMapping("driverregister/{username}/{password}/{mobilenumber}/{email}/{driverlicense}/{nationalid}/{area}")
	public void register(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("mobilenumber") String mobile_number,@PathVariable("email") String email,@PathVariable("nationalid") String national_id,@PathVariable("driverlicense") String driver_license,@PathVariable("area") String area)
	{
		Driver driver = new Driver();
		driver.set_Driver(username,password,mobile_number,email,national_id,driver_license,area);
		all_drivers.add(driver);
	}
	@GetMapping("driverlogin/{username}/{password}")
	public Boolean login(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		for(int i=0;i<all_drivers.size();i++) 
		{
			if(all_drivers.get(i).username.equals(username)) 
			{
				if(all_drivers.get(i).password.equals(password) && !(all_drivers.get(i).pending)) 
				{
					return true;
				}
				else 
					return false;
			}
		}
		return false;
	}
	
	@GetMapping("/listrides")
	public void list_rides()
	{
		Driver driverr = new Driver();
		driverr.print();
	}


	@PostMapping("/addarea/{area}")
	public void addArea(@RequestBody Driver driver, @PathVariable("area") String area )
	{
		Driver driverr = new Driver();
		driverr.add_to_favourites(driver,area);
	}


}
