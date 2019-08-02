package com.hoursecy.sy.service;

import org.springframework.stereotype.Service;

import com.hoursecy.sy.pojo.UserPojo;

@Service
public interface RegisterService {

	 //校验昵称格式
	String NikenameExist(String nikename);
	 
	 
	 //校验手机号码格式 或者是否存在
	 String PhoneFormat(String phone);
	 
	 //校验密码格式
	 String PasswordFormat(String password1);
	 
	 //校验两次输入密码是否一致
	 String PasswordFormat(String passwrod1,String passwrod);
	 
	 String ExistUserToDatabase(UserPojo user);


	String IDCardFormat(String idcard);
	 
}
