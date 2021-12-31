package com.example.uber;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.apache.tomcat.util.json.JSONParser;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
@RestController
public class DistanceTime {
    private static final String API_KEY="AIzaSyCCWGB4tDZFGtBA7H22XRKWiLe_jo6YQIg";
    OkHttpClient client = new OkHttpClient();
	@GetMapping("/googles/{picking_up}/{dropping_off}")
	public String calculate(@PathVariable("picking_up")String source ,@PathVariable("dropping_off")String destination) throws IOException {
	
	String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&key="+ API_KEY;
	            Request request = new Request.Builder()
	                .url(url)
	                .build();
	            Response response = client.newCall(request).execute();
	       
	            return response.body().string();
	          }
	@GetMapping("/google/{picking_up}/{dropping_off}")
	public void distancecalc(@PathVariable("picking_up")String source ,@PathVariable("dropping_off")String destination) throws IOException
	{
		String out = calculate(source,destination);
	 	JSONParser parser = new JSONParser(out);
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
    	}
        catch(Exception e) 
        {
 	       e.printStackTrace();
 	    }
	}
}
