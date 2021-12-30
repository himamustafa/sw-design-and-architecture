package com.example.uber;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	Admin admin = new Admin();
	
	@PostMapping("/registeradmin/{username}/{password}")
	public void register(@PathVariable("username") String username, @PathVariable("password") String password)
	{
		Admin adminn = new Admin(username,password);
		adminn.register(adminn);
	}
	
	@GetMapping("adminlogin/{username}/{password}")
	public void login(@PathVariable("username") String username, @PathVariable("password") String password)
	{
		Admin adminn = new Admin(username,password);
		adminn.login(adminn);
	}
	@PostMapping("adminverify/{driverusername}/{driveremail}")
	public void verify(@PathVariable("driverusername") String username, @PathVariable("driveremail") String email)
	{
		
		admin.verify(username,email);
		
	}
	@GetMapping("/pendingdrivers")
	public ArrayList <Driver>  list_drivers()
	{
		ArrayList <Driver> drivers = new ArrayList<Driver>();
		drivers = admin.list_allpending();		
		return drivers;
	}

}
