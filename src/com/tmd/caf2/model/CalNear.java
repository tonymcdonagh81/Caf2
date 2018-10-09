package com.tmd.caf2.model;

import java.util.ArrayList;
import java.util.List;


/**
 * CalNear has functions that allow for the filtering of the lists
 * @author tonymcdonagh
 *
 */
public class CalNear {
	public double latMax;
	public double latMin;
	public double lngMax;
	public double lngMin;
	
	

	//calculates the latitude and longitude range for the radius queries
	public void calLatLng(double lat, double lng, double radius) {
		//Earth’s radius, sphere
		double eRadius=6378137;

		double sRadius = radius;

		//Coordinate offsets in radians
		double offsetLat = sRadius/eRadius;
		double offsetLon = sRadius/(eRadius*Math.cos(Math.PI*lat/180));

		//OffsetPosition, decimal degrees
		latMax = lat + offsetLat * (180/Math.PI);
		latMin = lat - offsetLat * (180/Math.PI);
		lngMax = lng + offsetLon * 180/Math.PI;
		lngMin = lng - offsetLon * 180/Math.PI;
	}
	
	
	
	//compares lists to give cross section which is inside the requested radius
	public List<Shop> compareLists (List<Shop> latList, List<Shop> lngList){

		ArrayList<Shop> copylat = new ArrayList<Shop>(latList);
		ArrayList<Shop> copylng = new ArrayList<Shop>(lngList);
		ArrayList<Shop> newList = new ArrayList<Shop>();

		for(int i = 0; i<copylat.size(); i++){

			for(int j = 0; j<copylng.size(); j++){
				if(latList.get(i) == copylng.get(j)){
					newList.add(copylng.get(j));
				}
			}
		}
		return newList;
	}
	
	
	//checks list for requested value 
	public List<Shop> filterChain (List<Shop> inList, String value){

		ArrayList<Shop> inlat = new ArrayList<Shop>(inList);
		ArrayList<Shop> newList = new ArrayList<Shop>();

		for(int i = 0; i<inlat.size(); i++){

			if(inlat.get(i).chainOrIndie.equals(value)){
				newList.add(inlat.get(i));
			}
		}
		return newList;
	}
	
	
	//checks list if take away is requested
	public List<Shop> filterTake (List<Shop> inList){
		ArrayList<Shop> inlat = new ArrayList<Shop>(inList);
		ArrayList<Shop> newList = new ArrayList<Shop>();

		for(int i = 0; i<inlat.size(); i++){
			if(inlat.get(i).takeAway.equals("takeAway")){
				newList.add(inlat.get(i));
			}	
		}	
		return newList;
	}

	//checks list if sit in is requested
	public List<Shop> filterSitIn (List<Shop> inList){
		ArrayList<Shop> inlat = new ArrayList<Shop>(inList);
		ArrayList<Shop> newList = new ArrayList<Shop>();

		for(int i = 0; i<inlat.size(); i++){
			if(inlat.get(i).sitIn.equals("sitIn")){
				newList.add(inlat.get(i));
			}
		}
		return newList;
	}
	
	//checks list if rating is requested at the relevant value
	public List<Shop> filterRating (List<Shop> inList, String rating){
		Double value = Double.valueOf(rating);
		ArrayList<Shop> inlat = new ArrayList<Shop>(inList);
		ArrayList<Shop> newList = new ArrayList<Shop>();

		for(int i = 0; i<inlat.size(); i++){
			Double listValue = inlat.get(i).rating;
			if(listValue >= value && listValue < (value+1) ){
				newList.add(inlat.get(i));
			}
		}
		return newList;
	}
	
	
	

}
