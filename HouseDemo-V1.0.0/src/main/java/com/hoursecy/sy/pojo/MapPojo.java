package com.hoursecy.sy.pojo;

public class MapPojo {
	private String city;
	private String location;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "MapPojo [city=" + city + ", location=" + location + "]";
	}
	

}
