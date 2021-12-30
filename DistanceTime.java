package com.example.uber;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class DistanceTime {

    private static final String API_KEY="AIzaSyCCWGB4tDZFGtBA7H22XRKWiLe_jo6YQIg";
    OkHttpClient client = new OkHttpClient();


public String calculate(String source ,String destination) throws IOException {
String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&key="+ API_KEY;
            Request request = new Request.Builder()
                .url(url)
                .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
          }
}
