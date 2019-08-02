package com.hoursecy.sy.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 封装卖房信息
 */
public class ForSellPojo {
	private int id;
	private int houseid; //房源ID
	private String provence;  //省
	private String city;//市
	private String place;//县/区
	private int room;  //室
	private int door; //厅
	private int toile;  //卫
	private int housetime;  //房产年限
	private String buildage;  //建筑年代
	private String housetype;  //房屋类型
	private String intro;  //房屋描述
	private double size;  //面积
	private double price; //价格
	private double preprice; //多少钱一平
	private String pricetype;  //֧支付方式
	private String location; //详细地址
	private String minprice;//最低多少钱一平ַ
	private String maxprice;//最高多少钱一平
	private String housename; //小区名
	private String floor;//楼层
	private Date issuetime;//发布时间
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public String getProvence() {
		return provence;
	}
	public void setProvence(String provence) {
		this.provence = provence;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public int getToile() {
		return toile;
	}
	public void setToile(int toile) {
		this.toile = toile;
	}
	public int getHousetime() {
		return housetime;
	}
	public void setHousetime(int housetime) {
		this.housetime = housetime;
	}
	public String getBuildage() {
		return buildage;
	}
	public void setBuildage(String buildage) {
		this.buildage = buildage;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPreprice() {
		return preprice;
	}
	public void setPreprice(double preprice) {
		this.preprice = preprice;
	}
	public String getPricetype() {
		return pricetype;
	}
	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}
	public Date getIssuetime() {
		return issuetime;
	}
	public void setIssuetime(Date issuetime) {
		this.issuetime = issuetime;
	}
	@Override
	public String toString() {
		return "ForSellPojo [id=" + id + ", houseid=" + houseid + ", provence=" + provence + ", city=" + city
				+ ", place=" + place + ", room=" + room + ", door=" + door + ", toile=" + toile + ", housetime="
				+ housetime + ", buildage=" + buildage + ", housetype=" + housetype + ", intro=" + intro + ", size="
				+ size + ", price=" + price + ", preprice=" + preprice + ", pricetype=" + pricetype + ", location="
				+ location + ", minprice=" + minprice + ", maxprice=" + maxprice + ", housename=" + housename
				+ ", floor=" + floor + ", issuetime=" + issuetime + ", date=" + date + "]";
	}
	
	
	
	
}
