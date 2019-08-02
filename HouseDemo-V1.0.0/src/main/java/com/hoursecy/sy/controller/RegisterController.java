package com.hoursecy.sy.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoursecy.sy.pojo.UserPojo;
import com.hoursecy.sy.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("iDcard")
	@ResponseBody
	public String iDcard(String idcard) {
		return registerService.IDCardFormat(idcard);
	}
	
	
	@RequestMapping("NikenameFormat")
	@ResponseBody
	public String NikenameFormat(String nikename) {
		System.out.println(nikename);
		if(nikename.length()==0) {
			return "false";
		}
		return registerService.NikenameExist(nikename);
	}

	@RequestMapping("PhoneFormat")
	@ResponseBody
	public String PhoneFormat(String phone) {
			return registerService.PhoneFormat(phone);
	}

	@RequestMapping("PasswordFormat1")
	@ResponseBody
	public String PasswordFormat1(String password1) {
		return registerService.PasswordFormat(password1);
	}

	@RequestMapping("PasswordFormat2")
	@ResponseBody
	public String PasswordFormat(String password1,String password) {
		return registerService.PasswordFormat(password1,password);
	}


	@RequestMapping("Register")
	public String Register(UserPojo user) {
		System.out.println(user);
		if(user.getNikename()==""||user.getPhone()==""||user.getIdcard()=="") {
			return "RegisterFailure";
		}
			String resultString = registerService.ExistUserToDatabase(user);
			return "RegisterSucceed";
		
	}
	
	@RequestMapping("returnIndex")
	public String returnIndex() {
		return "iplocation";
	}

}




