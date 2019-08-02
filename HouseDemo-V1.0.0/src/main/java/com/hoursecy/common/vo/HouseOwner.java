package com.hoursecy.common.vo;

import com.hoursecy.sy.pojo.UserPojo;

/**
 * 	此类封装出售房屋的用户显示信息
 *
 */
public class HouseOwner {
	
	private String name;
	private String phone;
	private UserPojo user;
	
	public HouseOwner() {}
	public HouseOwner(UserPojo user) {
		String nikeName=(String) user.getNikename().subSequence(0,1);
		String gender=(String) user.getGender();
		if(gender.equals("男")) {
			nikeName=nikeName+"先生";
		}else{
			nikeName=nikeName+"女士";
		}
		this.name=nikeName;
		this.phone=user.getPhone();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserPojo getUser() {
		return user;
	}
	public void setUser(UserPojo user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "HouseOwner [name=" + name + ", phone=" + phone + ", user=" + user + "]";
	}
	
	
}
