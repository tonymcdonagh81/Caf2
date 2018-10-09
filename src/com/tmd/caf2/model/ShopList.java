package com.tmd.caf2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement (name = "shoplist")
@XmlAccessorType (XmlAccessType.FIELD)

public class ShopList {
	
	public ShopList() {

	}

    @XmlElement(name="shop")	
	private List<Shop> shops;
	public ShopList(List<Shop> inShops){
		shops=inShops;
	}
	public List<Shop> getShopList(){
		return shops;
	}
	public void setShopList(List<Shop> inShops){
		shops = inShops;
	}

}
