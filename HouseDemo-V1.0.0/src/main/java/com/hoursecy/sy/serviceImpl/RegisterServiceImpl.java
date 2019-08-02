package com.hoursecy.sy.serviceImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoursecy.common.util.MD5Encrypt;
import com.hoursecy.sy.dao.RegisterMapper;
import com.hoursecy.sy.pojo.UserPojo;
import com.hoursecy.sy.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	RegisterMapper registerMapper;
	
	
	public String ExistUserToDatabase(UserPojo user) {
		try {
			if(user.getNikename()==null||user.getPhone()==null||user.getIdcard()==null) {
				return "RegisterFailure";
			}
		String password = MD5Encrypt.MD5Encipherment(user.getPassword());
		String idcard = MD5Encrypt.MD5Encipherment(user.getIdcard());
		user.setPassword(password);
		user.setIdcard(idcard);
		registerMapper.ExistUserToDatabase(user);
		return "1";
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		
		return null;
	};
	
	

	@Override
	public String IDCardFormat(String idcard) {
		if(idcard.length()==0) {	
			return "false";
		}
		String regex =  "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
			
		Pattern pattern=Pattern.compile(regex);  
		Matcher matcher=pattern.matcher(idcard);
		boolean bool=matcher.matches();
		if(bool==false) return"false";
		try {
			idcard = MD5Encrypt.MD5Encipherment(idcard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.lang.Integer IdcardExist = registerMapper.PhoneExist(idcard);
		if(IdcardExist==null) {
			return "true";
		}
		return "false";
	}
	

	//检验用户名
	@Override
	public String NikenameExist(String nikename) {
		if(nikename.length()==0) {
			return "false";
		}else {
			return "true";
		}
				
			
	}

	//检验手机号
	@Override
	public String PhoneFormat(String phone){
		if(phone.length()==0) {	
			return "false";
		}
		//手机号
		String regex="^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern pattern=Pattern.compile(regex);  
		Matcher matcher=pattern.matcher(phone);
		boolean bool=matcher.matches();
		if(bool==false) return"false";
		java.lang.Integer phoneExist = registerMapper.PhoneExist(phone);
		System.out.println(phoneExist);
		if(phoneExist==null) {
			return "true";
		}
		return "false";
	}


	//检验第一次输入的密码
	@Override
	public String PasswordFormat(String password1) {
		int security = 0;
		if(password1.length()==0) {	
			return "0";
		}
		if(password1.length()<6) {	
			return "1";
		}
		if(password1.length()>16) {	
			return "2";
		}
		
		
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(password1);
		if (m.matches()) {
			security++;
		}
		p = Pattern.compile(".*[a-zA-Z]+.*");
		m = p.matcher(password1);
		if (m.matches()) {
			security++;
		}
		if (security==2&&password1.length()>10) {
			security++;
		}
		if(security==1) return "3";
		if(security==2) return "4";
		if(security==3) return "5";	
		return null;
	}

	//检验两次输入的密码是否一致
	@Override
	public String PasswordFormat(String password1,String passwrod) {
		if(password1.equals(passwrod)==false) {
			return "false";
		}else {
			return "true";
		}
	} 




}
