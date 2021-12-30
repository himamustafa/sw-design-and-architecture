package com.example.uber;

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
   
	Person1 person = new Person1();
@GetMapping("/google/{picking_up}/{dropping_off}")
   public ModelAndView Api(@PathVariable("picking_up") String source,@PathVariable("dropping_off") String destination) {
           try {
                 //method of DistanceTime Class
        	   Ride ride = new Ride();
        	   ride.setDistance(distance);
               String response=distance.calculate(source,destination);
           System.out.println(response);
          /* JSONParser parser = new JSONParser(response);
           try {

            Object obj = parser.parse();
            JSONObject jsonobj=(JSONObject)obj;

            JSONArray dist=(JSONArray)jsonobj.get("rows");
            JSONObject obj2 = (JSONObject)dist.get(0);
            JSONArray disting=(JSONArray)obj2.get("elements");
            JSONObject obj3 = (JSONObject)disting.get(0);
            JSONObject obj4=(JSONObject)obj3.get("distance");
            JSONObject obj5=(JSONObject)obj3.get("duration");
            System.out.println(obj4.get("text"));
            System.out.println(obj5.get("text"));

       }
   catch(Exception e) {
       e.printStackTrace();
   }*/
           }
           catch(Exception e) {
               System.out.println("Exception Occurred");
           }
           return new ModelAndView("home");
       }
Ride ride= new Ride();
Driver driver = new Driver();
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
	
}
@PostMapping("/endride")
public String end_ride()
{
	driver.EndRide(ride);
	return "ride ended successfully";
}
@PostMapping("/price/{price}")
public void setprice(@PathVariable("price") double price)
{
	ride.Set_price(price);
}
}
