package com.hoursecy.sy.service;

import org.springframework.stereotype.Service;

import com.hoursecy.sy.pojo.UserPojo;

@Service
public interface LoginService {
	String PhoneIsExist(String phone);
	
	UserPojo accountPasswordExists(String loginphonephone,String loginpassword);
}
