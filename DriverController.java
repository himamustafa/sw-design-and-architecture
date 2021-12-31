package com.example.uber;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class DriverController{
Actor person;
	DriverEntity entity;
	@PostMapping("driverregister/{username}/{password}/{mobilenumber}/{email}/{driverlicense}/{nationalid}/{area}")
	public void register(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("mobilenumber") String mobile_number,@PathVariable("email") String email,@PathVariable("nationalid") String national_id,@PathVariable("driverlicense") String driver_license,@PathVariable("area") String area)
	{
		Driver driver = new Driver();
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setMobile_number(mobile_number);
		entity.setEmail(email);
		entity.setDriving_license(driver_license);
		entity.setNational_id(national_id);
		entity.setFav_area(area);
		driver.set_Driver(entity);
		person.all_drivers.add(driver);
	}
	@GetMapping("driverlogin/{username}/{password}")
	public Boolean login(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		for(int i=0;i<person.all_drivers.size();i++) 
		{
			if(person.all_drivers.get(i).username.equals(username)) 
			{
				if(person.all_drivers.get(i).password.equals(password) && !(person.all_drivers.get(i).pending)) 
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
