package com.hoursecy.sy.serviceImpl;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.common.util.MD5Encrypt;
import com.hoursecy.sy.dao.LoginMapper;
import com.hoursecy.sy.pojo.UserPojo;
import com.hoursecy.sy.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public String PhoneIsExist(String phone) {
		if(phone.length()==0) {
			return "false";
		}
		Integer row =0;
		row = loginMapper.PhoneIsExist(phone);
		try {
			if(row!=0) {
				return "true";
			}
			
		} catch (Exception e) {
			return "false";
		}
		
			return "false";
	}
	
	@Override
	public UserPojo accountPasswordExists(String loginphone, String loginpassword) {
			try {
				loginpassword = MD5Encrypt.MD5Encipherment(loginpassword);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserPojo user = loginMapper.accountPasswordExists(loginphone,loginpassword);
			
			if(user.getId()!=0) {
				return user;
			}else {
				user=null;
				return user;
			}
		
	}
}



