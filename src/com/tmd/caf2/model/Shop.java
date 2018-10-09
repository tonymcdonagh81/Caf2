package com.tmd.caf2.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name="shop")
@XmlAccessorType (XmlAccessType.FIELD)

@Entity
public class Shop {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   Long id;
   String name;
   String vicinity;
   double lat;
   double lng;
   double rating;
   String sitIn;
   String takeAway;
   String food;
   String chainOrIndie;
   String googleId;
  
    
	public Shop() {}
   
   public Shop(int id, String name, String vicinity, double lat, double lng, double rating, String sitIn, 
		   String takeAway, String food, String chainOrIndie, String googleId) {
		super();
		this.id = (long) id;
		this.name = name;
		this.vicinity = vicinity;
		this.lat = lat;
		this.lng = lng;
		this.rating = rating;
		this.sitIn = sitIn;
		this.takeAway = takeAway;
		this.food = food;
		this.chainOrIndie = chainOrIndie;
		this.googleId = googleId;

	}
   
   public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getLat() {
	return lat;
}
public void setLat(double lat) {
	this.lat = lat;
}
public double getLng() {
	return lat;
}
public void setLng(double lng) {
	this.lng = lng;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public String getSitIn() {
	return sitIn;
}
public void setSitIn(String sitIn) {
	this.sitIn = sitIn;
}
public String getTakeAway() {
	return takeAway;
}
public void setTakeAway(String takeAway) {
	this.takeAway = takeAway;
}
public String getFood() {
	return food;
}
public void setFood(String food) {
	this.food = food;
}
public String getChainOrIndie() {
	return chainOrIndie;
}
public void setChainOrIndie(String chainOrIndie) {
	this.chainOrIndie = chainOrIndie;
}
public String getGoogleId() {
	return googleId;
}
public void setGoogleId(String googleId) {
	this.googleId = googleId;
}
public String getVicinity() {
	return vicinity;
}
public void setVicinity(String vicinity) {
	this.vicinity = vicinity;
}
@Override
public String toString() {
	return "Shop [id=" + id + ",lat=" + lat+ ", lng=" + lng +", name=" + name + ",vicinity=" + vicinity + ", rating=" + rating
			+ ", sitIn=" + sitIn + ", takeAway=" + takeAway + ", food="
			+ food + ", chainOrIndie=" + chainOrIndie + ", googleId=" + googleId + "]";
}   
}
