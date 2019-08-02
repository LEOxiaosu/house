package com.hoursecy.sy.pojo;

public class UserPojo {
	private Integer id;
	private String nikename;
	private String password;
	private String gender;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String phone;
	private String idcard;
	public String getIdcard() {
		return idcard;
	}

	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", nikename=" + nikename + ", password=" + password + ", phone=" + phone
				+ ", idcard=" + idcard + "]";
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNikename() {
		return nikename;
	}
	
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}





	public UserPojo(Integer id, String nikename, String password, String phone, String idcard) {
		super();
		this.id = id;
		this.nikename = nikename;
		this.password = password;
		this.phone = phone;
		this.idcard = idcard;
	}

	public UserPojo() {
		
	}
	
	
	
}
