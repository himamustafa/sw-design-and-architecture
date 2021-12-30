package com.example.uber;

import java.util.ArrayList;

public class OfferModel {
	private ArrayList<OfferEntity> offers = new ArrayList<OfferEntity>();
OfferEntity test = new OfferEntity();
	public void save(OfferEntity entiry)
	{
		offers.add(entiry);
	}
	public OfferEntity getOffer(int rideId)
	{
		for(int i=0;i<offers.size();i++)
		{
			if(rideId==(offers.get(i).getRideId()))
			{
				test = offers.get(i);
			}
		}
		return test;
	}
	public void updateOffer(int rideId, double price)
	{
		for(int i=0;i<offers.size();i++)
		{
			if(rideId==(offers.get(i).getRideId()))
			{
				offers.get(i).setPrice(price);
			}
		}
	}
	public void deleteOffer(int rideId)
	{
		for(int i=0;i<offers.size();i++)
		{
			if(rideId==(offers.get(i).getRideId()))
			{
				offers.remove(i);
			}
		}
	}


}
