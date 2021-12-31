package com.example.uber;

import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class RideController {
		private DistanceTime distance;
	  
		Actor person = new Actor();
	
	Ride ride= new Ride();
	Driver driver = new Driver();
	Driver drivers = new Driver(driver);
	MessagePublisher subject1 = new MessagePublisher();
	@PostMapping("/requestride/{username}/{source}/{destination}")
	public void request(@PathVariable("username") String username,@PathVariable("source")String source,@PathVariable("destination")String destination)
	{
		for(int i =0; i<person.all_users.size();i++)
		{
			if(person.all_users.get(i).username.equals(username))
			{
				Ride.set_ride(source,destination,person.all_users.get(i));
			}
		}
		for(int i=0;i<driver.favourite_areas.size();i++)
		{
			if(source.equals(driver.favourite_areas))
			{
				subject1.attach(driver);
				driver.attachSubject(subject1);
				subject1.notifyUpdate();
			}
		}
		
	}
	OfferEntity entity;
	OfferModel model;
	User user = new User();
	User users = new User(user);
	MessagePublisher subject2 = new MessagePublisher();
	@PostMapping("/endride/{rideId}")
	public String end_ride(@PathVariable("rideId") int rideId)
	{
		for(int i=0; i<driver.rides.size(); i++)
		{
			if(driver.rides.get(i).rideId==rideId)
			{
				ride.EndRide(driver.rides.get(i));
				return "ride ended successfully";
			}
		}
		ride.EndRide(ride);
		return "ride ended successfully";
	}
	@PostMapping("/selectride/{username}")
	public void selectRide(@PathVariable("username") String username)
	{
		ride.selectRide(username);
	}
	@PostMapping("/price/{driverusername}/{rideid}/{price}")
	public void setOffer(@PathVariable("driverusername")String username,@PathVariable("price") double price,@PathVariable("rideid") int rideId)
	{
		entity.setPrice(price);
		entity.setRideId(rideId);
		model.save(entity);
		for(int p=0;p<person.all_drivers.size();p++)
		{
			if(person.all_drivers.get(p).username.equals(username))
			{
				entity.setDriver(person.all_drivers.get(p));
			}
		}
		for(int i=0;i<person.all_users.size();i++)
		{
			if(rideId==(ride.getbyusername(person.all_users.get(i).username).rideId))
			{
				subject2.attach(person.all_users.get(i));
				person.all_users.get(i).attachSubject(subject2);
				subject2.notifyUpdate();
			}
		}
		
	}
	@PostMapping("/updateprice/{rideid}/{price}")
	public void updateOffer(@PathVariable("price") double price,@PathVariable("rideid") int rideId)
	{
		model.updateOffer(rideId,price);
		for(int i=0;i<person.all_users.size();i++)
		{
			if(rideId==(ride.getbyusername(person.all_users.get(i).username).rideId))
			{
				subject2.attach(person.all_users.get(i));
				person.all_users.get(i).attachSubject(subject2);
				subject2.notifyUpdate();
			}
		}
	}
	
	@PostMapping("/deleteoffer/{rideid}")
	public void deleteOffer(@PathVariable("rideid") int rideId)
	{
		model.deleteOffer(rideId);
	}
	@GetMapping("/listOffers/rideId")
	public ArrayList<OfferEntity> listOffers(@PathVariable("rideId") int rideId)
	{
		return ride.listOffers(rideId);
	}
}
